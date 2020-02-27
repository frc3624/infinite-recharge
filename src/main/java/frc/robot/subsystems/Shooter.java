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
  /**
   * Creates a new Shootr.
   */
  private final static double SHOOTER_WHEEL_RADIUS = 2.0 / 12.0;
  double gP = 1;
  double gI = 0;
  double gD = 0;
  private final int MAXRPM = 5200;
  private WPI_TalonFX shoot;

  public Shooter() {
    shoot = new WPI_TalonFX(SHOOTER_MOTOR_ID);
    shoot.config_kP(0, gP);
    shoot.config_kI(0, gI);
    shoot.config_kD(0, gD);
  }

  public void displayOnShuffleboard() {
    SmartDashboard.putNumber("Velocity", shoot.getSelectedSensorVelocity());
  }

  public void setLinearSpeed(double linearVelocity) {

    double rotationalVelocity = linearVelocity / SHOOTER_WHEEL_RADIUS;
    shoot.set(ControlMode.Velocity, rotationalVelocity);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setShootMotorSpeed(double a) {
    shoot.set(ControlMode.Velocity, a * MAXRPM);
  }
}
