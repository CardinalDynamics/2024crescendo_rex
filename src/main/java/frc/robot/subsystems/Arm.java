// this file holds the subystem for lifting and lowering the arm
package frc.robot.subsystems;

import static frc.robot.Constants.ArmConstants.*;
import static frc.robot.Constants.ArmPIDConstants.*;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class Arm extends PIDSubsystem {
    CANSparkMax m_arm;
    CANSparkMax m_arm2;
    RelativeEncoder m_encoder;
    PIDController m_controller;

    // constructor
    public Arm() {
        super(new PIDController(kP, kI, kD));
        m_arm = new CANSparkMax(kArmID, MotorType.kBrushless);
        m_arm2 = new CANSparkMax(kSecondArmID, MotorType.kBrushless);

        m_encoder = m_arm.getEncoder();
        m_encoder.setPositionConversionFactor(0.21875);
        m_arm2.follow(m_arm);
    }

    public double getMeasurement() {
        return m_encoder.getPosition();
    }

    public void useOutput(double output, double setpoint) {
        m_arm.setVoltage(output);
    }

    public boolean atSetpoint() {
        return m_controller.atSetpoint();
    }

    public void setArmVoltage(double voltage) {
        m_arm.setVoltage(voltage);
    }
    
    // defining method to stop arm motors
    public void armStop() {
        m_arm.set(0);
        m_arm2.set(0);
    }
}