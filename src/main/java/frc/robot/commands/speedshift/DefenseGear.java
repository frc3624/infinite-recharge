package frc.robot.commands.speedshift;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drive;

public class DefenseGear extends InstantCommand {
	private final Drive drive;

	public DefenseGear(Drive drive) {
		this.drive = drive;
		addRequirements(drive);
	}

	@Override
	public void execute() {
		drive.defenseGear();
	}
}
