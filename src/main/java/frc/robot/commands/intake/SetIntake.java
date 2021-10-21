package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class SetIntake extends CommandBase {
	@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
	private final Intake intake;
	private final double speed;

	public SetIntake(Intake intake, double speed) {
		this.intake = intake;
		this.speed = speed;
		addRequirements(intake);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		intake.spinIntakeWheels(speed);
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
