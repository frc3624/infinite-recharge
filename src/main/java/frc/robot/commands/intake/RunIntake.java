package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ballhandling.Intake;

// Temporary command as long as the automatic unjamming is not sorted out
public class RunIntake extends CommandBase {
	private final Intake intake;

	public RunIntake(Intake intake) {
		this.intake = intake;
		addRequirements(intake);
	}

	@Override
	public void execute() {
		intake.spinIntakeWheels(.4);
	}

	@Override
	public void end(final boolean interrupted) {
		intake.spinIntakeWheels(0);
	}
}
