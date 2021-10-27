// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.subsystems.BallTrack;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

// We are using a separate class so it's easier to understand our approach when looking at this folder
public class RunShootingSystem extends ParallelDeadlineGroup {
  public RunShootingSystem(BallTrack ballTrack, Shooter shooter, Limelight limelight) {
    super(new EmptyBallTrack(ballTrack));
    addCommands(new Shoot(shooter, limelight));
  }
}
