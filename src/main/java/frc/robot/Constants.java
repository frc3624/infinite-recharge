/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

	// Driving
	 public static final int DRIVE_LEFT_MASTER_ID = 1; // Front Left
	 public static final int DRIVE_RIGHT_MASTER_ID = 3; // Front right
	 public static final int DRIVE_LEFT_SLAVE_ID = 2; // Back Left
	 public static final int DRIVE_RIGHT_SLAVE_ID = 4; // Back Right

	// Intake, Conveyor, Shooting
	 public static final int SHOOTER_MOTOR_ID = 27;
	 public static final int BALL_TRACK_ID = 7;
	 public static final int INTAKE_MOTOR_ID = 10;
	 public static final int PCM_CAN_ID = 0;
	
	// Limit Switches
	 public static final int DIO_START_ID = 5;
	 public static final int DIO_POS_1_ID = 1;
	 public static final int DIO_POS_2_ID = 2;
	 public static final int DIO_POS_3_ID = 3;
	 public static final int DIO_POS_4_ID = 4;


	// Controller Buttons
	 public static final int XBOX_1_ID = 0;
	 public static final int BUTTON_A = 1;
	 public static final int BUTTON_B = 2;
	 public static final int BUTTON_X = 3;
	 public static final int BUTTON_Y = 4;
	 public static final int BUTTON_LB = 5;
	 public static final int BUTTON_RB = 6;
	 public static final int LEFT_TRIGGER = 2; //axis number
	 public static final int RIGHT_TRIGGER = 3; //axis number
}
