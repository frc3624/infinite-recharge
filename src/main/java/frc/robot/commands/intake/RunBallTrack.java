package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallTrack;

/**
 * High likelihood this section is not completed properly in interest saving time for the invitational
 * The proper way to do this would involve checking about 4 DIO limit switches so we could know how many
 * balls are present in the ball track system. Due to the time constraints, we'll most likely just resort
 * to guessing how many balls are being contained at the current moment and not adjusting the motors to 
 * correct for every new ball introduced.
*/

public class RunBallTrack extends CommandBase {
	@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
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
