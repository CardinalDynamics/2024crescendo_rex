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
    CANSparkMax m_leftArm;
    CANSparkMax m_rightArm;
    RelativeEncoder m_encoder;
    PIDController m_controller;

    // constructor
    public Arm() {
        super(new PIDController(kP, kI, kD));
        m_leftArm = new CANSparkMax(kArmID, MotorType.kBrushless);
        m_rightArm = new CANSparkMax(kSecondArmID, MotorType.kBrushless);
        m_leftArm.setInverted(true);
        m_rightArm.setInverted(false);

        m_encoder = m_leftArm.getEncoder();
        m_encoder.setPosition(0);
        m_encoder.setPositionConversionFactor((360/105));
    }

    public double getMeasurement() {
        return m_encoder.getPosition();
    }

    public void useOutput(double output, double setpoint) {
        m_leftArm.setVoltage(output);
        m_rightArm.setVoltage(output);
    }

    public boolean atSetpoint() {
        return m_controller.atSetpoint();
    }

    public void setArmVoltage(double voltage) {
        m_rightArm.setVoltage(voltage);
        m_leftArm.setVoltage(voltage);
    }

    public void setArmSpeed(double speed) {
        m_leftArm.set(speed);
        m_leftArm.set(speed);
    }
    
    // defining method to stop arm motors
    public void armStop() {
        m_leftArm.set(0);
        m_rightArm.set(0);
    }

    public void zeroEncoder() {
        m_encoder.setPosition(0);
    }
}