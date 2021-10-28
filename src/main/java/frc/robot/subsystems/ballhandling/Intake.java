/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.ballhandling;

import static frc.robot.Constants.INTAKE_MOTOR_ID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
	
	private final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(INTAKE_MOTOR_ID);

	public Intake() {
	}

	@Override
	public void periodic() {
	}

	/**
	 * Sets speed for the intake wheels
	 * @param speed Value from [-1,1]
	 */
	public void spinIntakeWheels(double speed) {
		intakeMotor.set(ControlMode.PercentOutput, speed);
	}
}
