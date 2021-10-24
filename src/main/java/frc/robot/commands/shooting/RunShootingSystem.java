// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.BallTrack;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class RunShootingSystem extends ParallelCommandGroup {
  public RunShootingSystem(BallTrack ballTrack, Shooter shooter, Limelight limelight) {
    addCommands(new EmptyBallTrack(ballTrack), new Shoot(shooter, limelight));
  }
}
