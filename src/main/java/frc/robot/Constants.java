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

    public static final int DRIVE_LEFT_MASTER_ID = 1; // Front Left
    public static final int DRIVE_RIGHT_MASTER_ID = 3; // Front right
    public static final int DRIVE_LEFT_SLAVE_ID = 2; // Back Left
    public static final int DRIVE_RIGHT_SLAVE_ID = 4; // Back Right

    public static final int SHOOTER_MOTOR_ID = 7;

    public static final int LEFT_CLIMB_MOTOR_ID = 5;
    public static final int RIGHT_CLIMB_MOTOR_ID = 6;

    public static final int JOYSTICK_ID = 0;
    public static final int SPEED_SHIFT_BUTTON_ID = 6;
    public static final int SHOOT_BUTTON_ID = 1;
    public static final int CLIMB_BUTTON_ID = 2;
}
