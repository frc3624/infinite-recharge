package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballhandling.BallTrack;

public class AdvanceBallTrack extends CommandBase {
	private final BallTrack ballTrack;

	public AdvanceBallTrack(BallTrack ballTrack) {
		this.ballTrack = ballTrack;
		addRequirements(ballTrack);
	}
	
	@Override
	public void execute() {
		ballTrack.advanceToNextPosition(ballTrack.getCurrentPosition());
	}

	@Override
	public void end(final boolean interrupted) {
		ballTrack.setMotorSpeed(0);
	}
}
