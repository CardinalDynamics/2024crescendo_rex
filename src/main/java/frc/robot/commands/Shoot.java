// this file contains the shoot command, which shoots notes
package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command{
    Shooter m_shooter;
    double speed;
    
    // contructor. uses shooter subsystem
    public Shoot(Shooter shooter) {
        m_shooter = shooter;
        speed = kShooterSpeed;

        // shoot requires shooter
        addRequirements(m_shooter);
    }

    // when this command is started, it calls shootNote(), which runs the shooter motors at kShooterSpeed.
    // it is not neccessary to have an execute() method, as the motor runs at the set speed until stopped
    public void initialize() {
        m_shooter.shootNote(speed);
    }

    public boolean isFinished() {
        return false;
    }

    // calls stopShooting() (which sets the speed of the shooter motors to 0 (stops shooter motors)) when command ends
    public void end(Boolean interrupted) {
        m_shooter.stopShooting();
    }
}