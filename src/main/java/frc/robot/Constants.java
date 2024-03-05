// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    // Port numbers for driver and operator gamepads. These correspond with the numbers on the USB
    // tab of the DriverStation
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }

  public static class DrivetrainConstants {
    // CAN IDs for drive motor controllers
    public static final int kLeftRearID = 8;
    public static final int kLeftFrontID = 12;
    public static final int kRightFrontID = 3;
    public static final int kRightRearID = 2;
    

    // Current limit for drivetrain motors
    public static final int kCurrentLimit = 60;
  }

  public static class IntakeConstants {
    // CAN IDs for intake/manipulator, shooter motor speed
    public static final int kTopShooterID = 6;
    public static final int kBottomShooterID = 5;
    public static final int kIntakeID = 4;
    public static final double kShooterSpeed = 1;
    // public static final double kBottomShooterSpeed = -.9;
  }

  public static class SolenoidConstants {
    // solenoid CAN ID
    public static final int kRotatorForward = 1;
    public static final int kRotatorReverse = 7;
    public static final int kPneumaticsHubID = 1;
  }

  public static class ArmConstants {
    // Arm motorcontroller CAN IDs and motor speeds
    public static final int kArmID = 7;
    public static final int kSecondArmID = 9;
    public static final double kArmSpeedUp = .5;
    public static final double kArmSpeedDown = -.5;

    public static final int kSourceA = 3;
    public static final int kSourceB = 4;
  }

  public static class ArmPIDConstants {
    public static final double kP = .05;
    public static final double kI = 0;
    public static final double kD = 0.0001;

    public static final double kArmUpSetPoint = 95;
    public static final double kShootingPositionSetPoint = 0;
  }
}