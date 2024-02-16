// this file holds the subystem for lifting and lowering the arm
package frc.robot.subsystems;

import static frc.robot.Constants.ArmConstants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class Arm extends SubsystemBase {
    CANSparkMax m_arm;
    CANSparkMax m_arm2;

    // constructor
    public Arm() {
        m_arm = new CANSparkMax(kArmID, MotorType.kBrushless);
        m_arm2 = new CANSparkMax(kSecondArmID, MotorType.kBrushless);
    }

    // defining method that runs arm motors to raise arm
    public void armUp() {
        m_arm.set(.5);
        m_arm2.set(.5);
    }

    // defining method to stop arm motors
    public void armStop() {
        m_arm.set(0);
        m_arm2.set(0);
    }

    // defining method that runs arm motors to lower arm
    public void armDown() {
        m_arm.set(-.5);
        m_arm2.set(.5);
    }
}