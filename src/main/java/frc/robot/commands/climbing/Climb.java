/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                                                         */
/* Open Source Software - may be modified and shared by FRC teams. The code     */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                                                                                             */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climbing;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class Climb extends CommandBase {
	private final Climber climber;
	private final double speed;
	
	public Climb(Climber climber, double speed) {
		this.climber = climber;
		this.speed = speed;
		addRequirements(climber);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		climber.move(speed);
	}

	@Override
	public void end(boolean interrupted) {
		climber.move(0);
	}

	@Override
	public boolean isFinished() {
	return false;
	}
}
