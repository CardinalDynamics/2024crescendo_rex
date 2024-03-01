// this file contains the chomp command, which intakes notes
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class Chomp extends Command{
    Intake m_intake;
    
    // contructor. uses intake subystem
    public Chomp(Intake intake) {
        m_intake = intake;

        // chomp requires the intake subsystem
        addRequirements(m_intake);
    }

    // when this command is started, it calls intakeNote(), which runs the intake motor.
    // it is not neccessary to have an execute() method, as the motor runs at the set speed until stopped
    public void initialize() {
        m_intake.intakeNote();
    }

    public boolean isFinished() {
        return false;
    }

    // calls stopIntake() (stops intake motor) when command ends
    public void end(Boolean interrupted) {
        m_intake.stopIntake();
    }
}