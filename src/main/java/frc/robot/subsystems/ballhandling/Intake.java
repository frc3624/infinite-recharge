/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.ballhandling;

import static frc.robot.Constants.INTAKE_MOTOR_ID;
 import static frc.robot.Constants.PCM_CAN_ID;
 import static frc.robot.Constants.SOLENOID_ID;
 import com.revrobotics.CANSparkMax;
 import com.revrobotics.CANSparkMaxLowLevel.MotorType;
 import edu.wpi.first.wpilibj.Solenoid;
 import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Incredibly simple class. Runs the intake wheels at the front of the robot, and sends the ball in. Thing to note, this
 * is the only * mechanism which uses a SparkMax. Methods are slightly different, but concept is the same.
 * 
 * Note for anybody who wants to use these. You probably are having issues importing this library. Go to the .json for 
 * REVRobotics (this is located in vendordeps) and lower the version by .01. I hate REV Robotics
 */
public class Intake extends SubsystemBase {
	private final CANSparkMax intakeMotor = new CANSparkMax(INTAKE_MOTOR_ID, MotorType.kBrushless);
	private final Solenoid liftPiston = new Solenoid(PCM_CAN_ID, SOLENOID_ID);

	public Intake() {
		liftPiston.set(false);
	}

	/**
	 * Sets speed for the intake wheels
	 * @param speed Value from [-1,1]
	 */
	public void spinIntakeWheels(double speed) {
		intakeMotor.set(-speed);
	}

	/**
	 * These two methods should have been consolidated into one method (a toggle method). This could not happen because you can't
	 * toggle with regular Solenoids properly, you need a DoubleSolenoid. It was all we had on hand though, so ¯\_(ツ)_/¯
	 */
	public void intakeUp() {
		liftPiston.set(true);
	}
	public void intakeDown() {
		liftPiston.set(false);
	}
}
