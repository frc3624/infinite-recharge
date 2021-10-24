// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallTrack;

public class RunBallTrack extends CommandBase {
	private final BallTrack ballTrack;
  private final double speed;

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
	public void end(final boolean interrupted) {
		ballTrack.setMotorSpeed(0);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
