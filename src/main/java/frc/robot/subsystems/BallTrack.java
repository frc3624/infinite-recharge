/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


/**
 * TODO
 * 
 * Add Implementation for detecting number of balls in the ball track
 * 
 * Make the command be constantly called in order to be able to pick up balls
 * whenever the intake hits the limit switch at the front
 * 
 * Create ParallelCommandGroup w/ Shooting in order to dump 4 balls at once
 * 
 */
package frc.robot.subsystems;

import static frc.robot.Constants.BALL_TRACK_ID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallTrack extends SubsystemBase {
	private final WPI_TalonSRX ballTrack = new WPI_TalonSRX(BALL_TRACK_ID);

	private Timer timer = new Timer();
	private double runBackStartTime = -1; // setting initial time to -1 as to avoid issues in isUnJamming()
	private boolean isJammed = false;
	
	public BallTrack() {
		timer.start();
	}

	@Override
	public void periodic() {
	}

	/**
	 * Sets the speed for the motors. In the event that the motors jam, it reverses the direction of the motors.
	 * Detects if the 
	 * @param speed Value from [-1,1]
	 */
	public void setMotorSpeed(double speed) {
		if(isJamming()) {
			runBackStartTime = timer.get();
		}
		if(isUnJamming()) {
			isJammed = true;
			ballTrack.set(ControlMode.PercentOutput, -speed);
		} else {
			isJammed = false;
			ballTrack.set(ControlMode.PercentOutput, speed);
		}
	}

	/**
	 * Is the motor's current currently greater than the our threshold of 8 Amps?
	 * Also, did the code to check if it's unjamming say it is not jamming?
	 * @return If the ball track is jamming currently
	 */
	private boolean isJamming() {
		return ballTrack.getStatorCurrent() >= 8 && !isJammed;
	}
	
	/**
	 * Is the motor currently reversed to unjam the ball track?
	 * @return If the ball track is currently unjamming itself
	 */
	private boolean isUnJamming() {
		return timer.get() - runBackStartTime < 1;
	}
}
