package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class Rotate extends Command{
    Rotator m_rotator;

    public Rotate(Rotator rotator) {
        m_rotator = rotator;
        addRequirements(m_rotator);
    }    
    
    public void initialize() {
        
        m_rotator.toggleRotator();
    }

    public boolean isFinished() {
        return false;
    }
}
