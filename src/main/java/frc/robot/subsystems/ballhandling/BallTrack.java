/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.ballhandling;

import static frc.robot.Constants.BALL_TRACK_ID;
 import static frc.robot.Constants.DIO_START_ID;
 import static frc.robot.Constants.DIO_POS_1_ID;
 import static frc.robot.Constants.DIO_POS_2_ID;
 import static frc.robot.Constants.DIO_POS_3_ID;
 import com.ctre.phoenix.motorcontrol.ControlMode;
 import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
 import edu.wpi.first.wpilibj.DigitalInput;
 import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * This class was made for the internal ball intake system. This was an admittedly 
 * GARBAGE design, and we actually tried scrapping it, but Mr. Vessey starting working
 * on it again without knowing how genuinely terrible it was. Hopefully, you'll never
 * need to reuse this code, but if you do, here's how it worked.
 * 
 * The ball would enter the system from the front intake wheels. After entering, it'd
 * enter the ball track. Once in, it would trigger a pressure plate and trigger the code.
 * There was a toggle button which the driver would press, and the sequence would initiate.
 * Once in, the track would keep running until the ball would reach the next position.
 * 
 * This especially sucked because all the positions in the track ran off the same chain,
 * but the pressure upon the bar was variable. Basic physics makes it clear it'd suck,
 * as Pressure is Mass * dv/dt (acceleration for non calc kids) over the Area. You can
 * probably see what happened. The velocity was variable within the conveyor, and balls
 * subjected to higher pressure got faster and faster. This stifled our intake capacity
 * without jamming, so we had to resort to only 3 balls for the capacity.
 * 
 * Overall, garbage system, but hopefully you can learn how to interface with switches
 * better from this code.
 */

public class BallTrack extends SubsystemBase {
	private final WPI_TalonSRX ballTrack = new WPI_TalonSRX(BALL_TRACK_ID);

	private final DigitalInput startSwitch = new DigitalInput(DIO_START_ID);
	private final DigitalInput pos1Switch = new DigitalInput(DIO_POS_1_ID);
	private final DigitalInput pos2Switch = new DigitalInput(DIO_POS_2_ID);
	private final DigitalInput pos3Switch = new DigitalInput(DIO_POS_3_ID);
	private final DigitalInput[] limSwitches = {pos1Switch, pos2Switch, pos3Switch};

	private boolean isBallAtStart() {
		return !startSwitch.get();
	}
	public boolean hasBalls() {
		return !pos1Switch.get() || !pos2Switch.get() || !pos3Switch.get();
	}
	public boolean isFull() {
		return !pos1Switch.get() && !pos2Switch.get() && !pos3Switch.get();
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
			if (!limSwitches[i].get()) { // .get() returns false when activated (weird ik), so we're negating it
				return i;
			}
		}
		return -1	;
	}

	/**	
	 * Recursive approach to advancing the ball in the track
	 * 
	 * Check if a new ball is entering the system, and if it is, spin the track until the furthest ball advances another position
	 * Once this is done, call the method again if there is another ball at the start, and advance the ball to the next position
	 * @param switchVal Location of the ball which is the furthest along
	 */
	public void advanceToNextPosition(int switchVal) {
		if(isBallAtStart()) {
			if(switchVal == -1) {
				while(limSwitches[0].get()) {
					ballTrack.set(ControlMode.PercentOutput, .6);
				}
				ballTrack.set(ControlMode.PercentOutput, 0);
			} else {
				while(limSwitches[switchVal].get()) { 
					ballTrack.set(ControlMode.PercentOutput, .6);
				}
				ballTrack.set(ControlMode.PercentOutput, 0);
			}
		}
		if(switchVal < limSwitches.length - 1 && isBallAtStart()){
			advanceToNextPosition(getCurrentPosition() + 1);
		}
		System.out.println(hasBalls());
	}
}
