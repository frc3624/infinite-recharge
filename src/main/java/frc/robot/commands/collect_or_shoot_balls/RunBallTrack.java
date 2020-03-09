/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.collect_or_shoot_balls;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Conveyor;

public class RunBallTrack extends CommandBase {

  private final Conveyor conveyor;
  private double speed;
  public RunBallTrack(Conveyor conveyor, double speed) {
    this.conveyor = conveyor;
    this.speed = speed;
    addRequirements(conveyor);
    
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    conveyor.setMotorSpeed(speed);
  }

  @Override
  public void end(boolean interrupted) {
    conveyor.setMotorSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
