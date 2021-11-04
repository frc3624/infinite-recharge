/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                                                         */
/* Open Source Software - may be modified and shared by FRC teams. The code     */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                                                                                             */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight.LedMode;
import frc.robot.subsystems.ballhandling.Shooter;
///import frc.util.RollingAverage;
import frc.robot.subsystems.Limelight;

public class Shoot extends CommandBase {
	private final Limelight limelight;
	private final Shooter shooter;
	//private RollingAverage rollingAverage;
	
	public Shoot(Shooter shooter, Limelight limelight) {
		this.shooter = shooter;
		this.limelight = limelight;
		addRequirements(shooter);
	}

	@Override
	public void initialize() {
		limelight.setLedMode(LedMode.ON);
	}

	@Override
	public void execute() {
		//shooter.setShootMotorSpeed(.6);
		shooter.setLinearSpeed();
		// We'll put in the limelight code once we are able to use it properly
		// if(limelight.hasValidTarget()) {
		// 	rollingAverage.add(limelight.getVerticalDistance());
		// 	//shooter.setPosition(rollingAverage.get());
		// }
	}

	@Override
	public void end(boolean interrupted) {
		limelight.setLedMode(LedMode.CURRENT);
		shooter.setShootMotorSpeed(0);
	}

	@Override
	public boolean isFinished() {
	return false;
	}
}
