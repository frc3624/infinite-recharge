// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.intake.RunIntake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.ballhandling.BallTrack;
import frc.robot.subsystems.ballhandling.Intake;
import frc.robot.subsystems.ballhandling.Shooter;

// We are using a separate class so it's easier to understand our approach when looking at this folder
public class RunShootingSystem extends ParallelDeadlineGroup {
  public RunShootingSystem(BallTrack ballTrack, Intake intake, Shooter shooter, Limelight limelight) {
    super(new EmptyBallTrack(ballTrack));
    addCommands(new RunIntake(intake), new Shoot(shooter, limelight));
  }
}
