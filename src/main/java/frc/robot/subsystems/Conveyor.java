/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.Constants.BALL_TRACK_ID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyor extends SubsystemBase {
	
	private final WPI_TalonSRX ballTrack = new WPI_TalonSRX(BALL_TRACK_ID);
		public Conveyor() {
	}

	@Override
	public void periodic() {
	}

	public void setMotorSpeed(double a) {
		ballTrack.set(ControlMode.PercentOutput, a);
	}
}
