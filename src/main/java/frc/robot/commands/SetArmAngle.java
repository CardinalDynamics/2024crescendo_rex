package frc.robot.commands;

import static frc.robot.Constants.ArmPIDConstants.*;
import frc.robot.subsystems.*;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;

public class SetArmAngle extends PIDCommand{
    Arm m_arm;

    public SetArmAngle(double angle, Arm arm) {
        super(new PIDController(kP, kI, kD), arm::getMeasurement, angle, (output) -> {arm.useOutput(output, angle);}, arm);

        // getController().enableContinuousInput(0, 360);
        getController().setTolerance(.05);
    }

    @Override
    public boolean isFinished() {
      return false;
    }
}
