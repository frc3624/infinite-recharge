package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallTrack;

public class EmptyBallTrack extends CommandBase {
	private final BallTrack ballTrack;

	public EmptyBallTrack(BallTrack ballTrack) {
		this.ballTrack = ballTrack;
		addRequirements(ballTrack);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		ballTrack.setMotorSpeed(.6);
	}

	@Override
	public void end(final boolean interrupted) {
		ballTrack.setMotorSpeed(0);
	}

	@Override
	public boolean isFinished() {
		return !ballTrack.hasBalls();
	}
}
