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
import static frc.robot.Constants.DIO_START_ID;
import static frc.robot.Constants.DIO_POS_1_ID;
import static frc.robot.Constants.DIO_POS_2_ID;
import static frc.robot.Constants.DIO_POS_3_ID;
import static frc.robot.Constants.DIO_POS_4_ID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallTrack extends SubsystemBase {
	private final WPI_TalonSRX ballTrack = new WPI_TalonSRX(BALL_TRACK_ID);

	private final DigitalInput startSwitch = new DigitalInput(DIO_START_ID);
	private final DigitalInput pos1Switch = new DigitalInput(DIO_POS_1_ID);
	private final DigitalInput pos2Switch = new DigitalInput(DIO_POS_2_ID);
	private final DigitalInput pos3Switch = new DigitalInput(DIO_POS_3_ID);
	private final DigitalInput pos4Switch = new DigitalInput(DIO_POS_4_ID);
	private DigitalInput[] limSwitches = {pos1Switch, pos2Switch, pos3Switch, pos4Switch};

	// // Jamming protection
	// private Timer timer = new Timer();
	// private double runBackStartTime = -1; // setting initial time to -1 as to avoid issues in isUnJamming()
	// private double unJamResetTime = -1;
	// private boolean isJammed = false;

	public BallTrack() {
		//timer.start();
	}

	@Override
	public void periodic() {
	}

	public boolean isBallAtStart() {
		return !startSwitch.get();
	}
	public boolean isBallAtPos1() {
		return !pos1Switch.get();
	}
	public boolean isBallAtPos2() {
		return !pos2Switch.get();
	}
	public boolean isBallAtPos3() {
		return !pos3Switch.get();
	}
	public boolean isBallAtPos4() {
		return !pos4Switch.get();
	}
	public boolean hasBalls() {
		return isBallAtPos1() || isBallAtPos2() || isBallAtPos3() || isBallAtPos4();
	}
	public boolean isFull() {
		return isBallAtPos1() && isBallAtPos2() && isBallAtPos3() && isBallAtPos4();

	}

	public void setMotorSpeed(double speed) {
		ballTrack.set(ControlMode.PercentOutput, speed);
	}

	/**
	 * Iterates through array of limit switches, and return the furthest limit switch which is activated
	 * @return Furthest activated limit switch
	 */
	public int getCurrentPosition() {
		for(int i = limSwitches.length - 1; i >= 0; i--) {
			if (!limSwitches[i].get()) {
				return i;
			}
		}
		return 0;
	}

	public void advanceToNextPosition(int switchVal) {
		if(isBallAtStart()) {
			System.out.println(!limSwitches[switchVal].get());
			while(!limSwitches[switchVal].get()) {
				ballTrack.set(ControlMode.PercentOutput, .5);
			}
			ballTrack.set(ControlMode.PercentOutput, 0);
		}
		if(switchVal < limSwitches.length - 1 && isBallAtStart())
			advanceToNextPosition(switchVal + 1);
	}


	// Mr. Wilson said to ditch the unjamming code, we'll bring it back if we want to have it 

	// /**
	//  * Sets the speed for the motors. In the event that the motors jam, it reverses the direction of the motors.
	//  * Detects if the 
	//  * @param speed Value from [-1,1]
	//  */
	// public void setMotorSpeed(double speed) {
	// 	// System.out.println(ballTrack.getStatorCurrent());
	// 	// System.out.println("boolean val: " + isJammed);
	// 	// System.out.println("time: " + runBackStartTime);
	// 	double activeCurrent = ballTrack.getStatorCurrent();
	// 	if(isJamming(activeCurrent)) {
	// 		runBackStartTime = timer.get();
	// 	}
	// 	if(isUnJamming(activeCurrent)) {
	// 		isJammed = true;
	// 		ballTrack.set(ControlMode.PercentOutput, -speed);
	// 	} else {
	// 		isJammed = false;
	// 		ballTrack.set(ControlMode.PercentOutput, speed);
	// 	}
	// }

	// /**
	//  * Is the motor's current currently greater than the our threshold of 8 Amps?
	//  * Also, did the code to check if it's unjamming say it is not jamming?
	//  * @return If the ball track is jamming currently
	//  */
	// private boolean isJamming(double activeCurrent) {
	// 	return activeCurrent >= 9 && !isJammed;
	// }
	
	// /**
	//  * Is the motor currently reversed to unjam the ball track?
	//  * @return If the ball track is currently unjamming itself
	//  */
	// private boolean isUnJamming(double activeCurrent) {
	// 	// System.out.println("UnJam Time: " + unJamResetTime);
	// 	// System.out.println("-------------");
	// 	double unjamCurrent = ballTrack.getStatorCurrent();
	// 	if (activeCurrent < 0 && unjamCurrent > 0) {
	// 		unJamResetTime = timer.get();
	// 	}
	// 	if (isFinishedUnJamming()) {
	// 		return false;
	// 	} else {
	// 		return timer.get() - runBackStartTime < 1;
	// 	}
	// }

	// private boolean isFinishedUnJamming() {
	// 	return timer.get() - unJamResetTime < 1;
	// }
}
