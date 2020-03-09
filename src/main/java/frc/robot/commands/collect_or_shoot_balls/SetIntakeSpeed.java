/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.collect_or_shoot_balls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class SetIntakeSpeed extends CommandBase {
  private final Intake intake;
  private final double speed;
  public SetIntakeSpeed(Intake intake, double speed) {
    this.intake = intake;
    this.speed = speed;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intake.spinIntakeWheels(speed);
  }

  @Override
  public void end(boolean interrupted) {
    intake.spinIntakeWheels(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
