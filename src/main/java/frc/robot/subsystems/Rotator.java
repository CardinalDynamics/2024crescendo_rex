// this file holds the subystem for the rotator mechanism which rotates the intake

package frc.robot.subsystems;

import static frc.robot.Constants.SolenoidConstants.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Rotator extends SubsystemBase {
    
    DoubleSolenoid m_solenoid;

    // constructor
    public Rotator () {
        m_solenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, kRotatorForward, kRotatorReverse);
    }

    // defining method to toggle the rotator from being up to down and vice versa
    public void toggleRotator() {
        m_solenoid.toggle();
    }

    // defining method to put the rotator up (retract)
    public void setUp() {
        m_solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    // defining method to put the rotator down (extend)
    public void setDown() {
        m_solenoid.set(DoubleSolenoid.Value.kForward);
    }
}