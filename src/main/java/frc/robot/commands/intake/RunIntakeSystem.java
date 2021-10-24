// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.BallTrack;
import frc.robot.subsystems.Intake;

public class RunIntakeSystem extends ParallelCommandGroup {
  public RunIntakeSystem(Intake intake, BallTrack ballTrack) {
    addCommands(new RunIntake(intake), new AdvanceBallTrack(ballTrack));
  }
}
