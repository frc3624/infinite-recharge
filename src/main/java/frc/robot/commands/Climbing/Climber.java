/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Climbing;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class Climber extends CommandBase {
  private final Climb climb;
  private final double speed;
  public Climber(Climb c, double speed) {
    this.climb =c;
    addRequirements(c);
    this.speed = speed;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    climb.move(speed);
  }

  @Override
  public void end(boolean interrupted) {
    climb.move(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
