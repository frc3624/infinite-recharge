// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private TalonFX shootMotor;
  
  /** Creates a new Shoot. */
  public Shooter() {
    shootMotor = new TalonFX(Constants.SHOOT_MOTOR_ID);   
  }

  public void setShootMotorSpeed(double speed) {
    shootMotor.set(ControlMode.PercentOutput, speed);
    System.out.println(shootMotor.getSelectedSensorPosition());
  }

  @Override
  public void periodic() {
    
  }
}
