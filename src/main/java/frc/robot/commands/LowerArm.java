// this file contains the LowerArm command, which lowers the arm.
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

public class LowerArm extends Command{
    Arm m_arm;

    // contructor. uses arm subsystem
    public LowerArm(Arm arm) {
        m_arm = arm;

        // LowerArm requires arm
        addRequirements(m_arm);
    }

    // when this command is started, it calls armDown(), which runs the arm motors backwards to lower the arm.
    // it is not neccessary to have an execute() method, as the motor runs at the set speed until stopped
    public void initialize() {
        m_arm.armDown();
    }

    public boolean isFinished() {
        return false;
    }

    // calls armStop() (which sets the speed of the arm motors to 0 (stops arm motors)) when command ends
    public void end(Boolean interrupted) {
        m_arm.armStop();
    }
}