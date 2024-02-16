// this file holds the subystem for the shooter mechanism
package frc.robot.subsystems;

import static frc.robot.Constants.IntakeConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    CANSparkMax topShooter;
    CANSparkMax bottomShooter;

    // constructor
    public Shooter() {
        topShooter = new CANSparkMax(kTopShooterID, MotorType.kBrushless);
        bottomShooter = new CANSparkMax(kBottomShooterID, MotorType.kBrushless);
        
        // bottomshooter follows top shooter
        bottomShooter.follow(topShooter);

        // Top and bottom shooter should both be going outwards given positive input.
        bottomShooter.setInverted(false);
        topShooter.setInverted(false);
    }

    // defning method to run shooter motors, to shoot note
    public void shootNote(double shooterSpeed) {
        topShooter.set(shooterSpeed);
    }

    // method to stop shooter motors
    public void stopShooting() {
        topShooter.set(0);
    }
}