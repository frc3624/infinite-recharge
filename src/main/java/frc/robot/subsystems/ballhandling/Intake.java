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

// Note for anybody who wants to use these. You probably are having issues importing this library. Go to the .json for REVRobotics
// (this is located in vendordeps) and lower the version by .01. I hate REV Robotics
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public  class Intake extends SubsystemBase {
	private final CANSparkMax intakeMotor = new CANSparkMax(INTAKE_MOTOR_ID, MotorType.kBrushless);
	private final Solenoid liftPiston = new Solenoid(PCM_CAN_ID, SOLENOID_ID);

	public Intake() {
		liftPiston.set(false);
	}

	@Override
	public void periodic() {
	}

	/**
	 * Sets speed for the intake wheels
	 * @param speed Value from [-1,1]
	 */
	public void spinIntakeWheels(double speed) {
		intakeMotor.set(-speed);
	}

	/**
	 * Method to toggle the solenoid which is attached to the intake.
	 * Will either draw or release the intake arm
	 */
	public void toggleIntakePosition() {
		liftPiston.set(!liftPiston.get());
	}

	public void intakeUp() {
		liftPiston.set(true);
	}
	public void intakeDown() {
		liftPiston.set(false);
	}
}
