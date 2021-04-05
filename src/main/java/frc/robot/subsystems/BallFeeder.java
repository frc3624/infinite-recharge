// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BallFeeder extends SubsystemBase {
  /** Creates a new BallFeeder. */
  private TalonSRX positionerMotor;
  public BallFeeder() {
    positionerMotor = new TalonSRX(Constants.SHOOT_POSITIONER_MOTOR_ID);
  }

  public void setPositionerSpeed(double speed) {
    positionerMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("positionerMotor", positionerMotor.getSelectedSensorPosition());
    // This method will be called once per scheduler run
  }
}