/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Intake_and_Shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallTrack;

public class RunBallTrack extends CommandBase {

  private final BallTrack ballTrack;
  private double speed;
  public RunBallTrack(BallTrack ballTrack, double speed) {
    this.ballTrack = ballTrack;
    this.speed = speed;
    addRequirements(ballTrack);
    
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    ballTrack.setMotorSpeed(speed);
  }

  @Override
  public void end(boolean interrupted) {
    ballTrack.setMotorSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
