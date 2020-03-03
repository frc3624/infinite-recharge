/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase {
  private final static double SHOOTER_WHEEL_RADIUS = 2.0 / 12.0;
  double kP = 1;
  double kI = 0;
  double kD = 0;
  private final int MAXRPM = 5200;
  private WPI_TalonFX shoot = new WPI_TalonFX(SHOOTER_MOTOR_ID);

  public Shooter() {
    /*
    shoot.config_kP(0, gP);
    shoot.config_kI(0, gI);
    shoot.config_kD(0, gD);*/
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /*public void displayOnShuffleboard() {
    SmartDashboard.putNumber("Velocity", shoot.getSelectedSensorVelocity());
  }

  public void setLinearSpeed(double linearVelocity) {

    double rotationalVelocity = linearVelocity / SHOOTER_WHEEL_RADIUS;
    shoot.set(ControlMode.Velocity, rotationalVelocity);

  }

  */
  public void setShootMotorSpeed(double a) {
    shoot.set(ControlMode.PercentOutput, a);
  }
}
