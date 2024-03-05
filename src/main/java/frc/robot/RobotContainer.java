// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import static frc.robot.Constants.ArmPIDConstants.*;
import static frc.robot.Constants.IntakeConstants.*;
import static frc.robot.Constants.SolenoidConstants.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Chomp;
import frc.robot.commands.Rotate;
import frc.robot.commands.SetArmAngle;
import frc.robot.commands.Shoot;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Rotator;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Drivetrain m_drivetrain = new Drivetrain();
  public final Intake m_intake = new Intake();
  // public so I can use smartdashboard
  public final Arm m_arm = new Arm();
  public final Shooter m_shooter = new Shooter();
  public final Rotator m_rotator = new Rotator();
  
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_operatorController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    m_drivetrain.setDefaultCommand(
      new RunCommand(
        () -> m_drivetrain.arcadeDrive(m_driverController.getLeftY(), m_driverController.getRightX()),
        m_drivetrain
      ));

    m_shooter.setDefaultCommand(new RunCommand(() -> m_shooter.stopShooting(), m_shooter));
    m_arm.setDefaultCommand(new RunCommand(() -> m_arm.armStop(), m_arm));
    //m_operatorController.leftTrigger().whileTrue(new Chomp(m_intake));
    
    m_operatorController.rightTrigger().whileTrue(new Shoot(m_shooter));
    //m_operatorController.rightTrigger().onTrue(new RunCommand(() -> m_shooter.shootNote(kShooterSpeed), m_shooter)).whileFalse((new RunCommand(() -> m_shooter.shootNote(0), m_shooter)));
    
    m_operatorController.a().whileTrue(new RunCommand(() -> m_arm.setArmSpeed(-.1), m_arm));

   //~~~~~~~~~STOP NO STOP~~~~~~Things below here seem to work correctly~~~~~~~~~~~~~~~~~~~~~~~

//Note intake/outtake
    m_operatorController.leftBumper().onTrue(new RunCommand(() -> m_intake.intakeNote(), m_intake)).onFalse(new RunCommand(() -> m_intake.stopIntake(), m_intake));
    m_operatorController.rightBumper().onTrue(new RunCommand(() -> m_intake.outtakeNote(), m_intake)).onFalse(new RunCommand(() -> m_intake.stopIntake(), m_intake));
      
//Solenoid operation
    m_operatorController.x().onTrue(new RunCommand(() -> m_rotator.setUp(), m_rotator));
    m_operatorController.y().onTrue(new RunCommand(() -> m_rotator.setDown(), m_rotator));
  }

  // ABOVE THIS UNTIL NONO LINE NEEDS TO BE FIXED AS IT IS BAD GOUDE CODE.
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    SequentialCommandGroup commandGroup = new SequentialCommandGroup(
      new InstantCommand(() -> m_arm.setArmVoltage(-10), m_arm),
      new WaitCommand(0.1),
      new InstantCommand(() -> m_arm.setArmVoltage(0), m_arm),
      (new WaitCommand(0.5)),
      (new RunCommand(() -> m_drivetrain.arcadeDrive(-.5, 0), m_drivetrain)).withTimeout(2)
    );
    return commandGroup;
  }
  }