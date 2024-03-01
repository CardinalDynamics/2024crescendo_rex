// this file holds the subystem for the feeder/intake mechanism

package frc.robot.subsystems;

import static frc.robot.Constants.IntakeConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    CANSparkMax m_intake;

    // constructor
    public Intake () {
        m_intake = new CANSparkMax(kIntakeID, MotorType.kBrushless);

        // Intake motor should run inwards when given a positive input
        m_intake.setInverted(true);
    }

    // defining method to start the intake motor
    public void intakeNote() {
        m_intake.set(1.0);
    }

    public void outtakeNote() {
        m_intake.set(-1.0);
    }

    // defining method to stop the intake motor
    public void stopIntake() {
        m_intake.set(0);
    }
}