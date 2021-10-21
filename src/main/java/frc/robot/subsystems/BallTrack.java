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

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallTrack extends SubsystemBase {
	private final WPI_TalonSRX ballTrack = new WPI_TalonSRX(BALL_TRACK_ID);
	
	public BallTrack() {
	}

	@Override
	public void periodic() {
	}

	/**
	 * Sets the speed for the motors. In the event that the motors jam, it reverses the direction of the motors.
	 * @param speed Value from [-1,1]
	 */
	public void setMotorSpeed(double speed) {
		if(ballTrack.getStatorCurrent() >= 7) {
			Timer timer = new Timer();
			timer.start();
			while(timer.get() < 1) {
				ballTrack.set(ControlMode.PercentOutput, -speed);
			}
		}
		else
			ballTrack.set(ControlMode.PercentOutput, speed);

	}
}
