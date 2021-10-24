package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunIntake extends CommandBase {
	private final Intake intake;

	public RunIntake(Intake intake) {
		this.intake = intake;
		addRequirements(intake);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		intake.spinIntakeWheels(.6);
	}

	@Override
	public void end(final boolean interrupted) {
		intake.spinIntakeWheels(0);
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
