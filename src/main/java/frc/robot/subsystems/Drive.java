/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private WPI_TalonFX frontLeft;
  private WPI_TalonFX frontRight;
  private WPI_TalonFX backLeft;
  private WPI_TalonFX backRight;
  private DifferentialDrive diffDrive1;
  private DifferentialDrive diffDrive2;
  public Drive() {
    frontLeft = new WPI_TalonFX(Constants.driveFrontLeftId);
    frontRight = new WPI_TalonFX(Constants.driveFrontRightId);
    backLeft = new WPI_TalonFX(Constants.driveBackLeftId);
    backRight = new WPI_TalonFX(Constants.driveBackRightId);
    diffDrive1 = new DifferentialDrive(frontLeft,frontRight);
    diffDrive2 = new DifferentialDrive(backLeft, backRight);
  }
  
  public void displayOnShuffleboard() {
    SmartDashboard.putData("leftMaster", frontLeft);
    SmartDashboard.putData("rightMaster", frontRight);
    SmartDashboard.putData("leftSlave", backLeft);
    SmartDashboard.putData("rightSlave", backRight);
    SmartDashboard.putData("diffDrive1", diffDrive1);
  }
  public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive1.arcadeDrive(xSpeed, zRotation);
    diffDrive2.arcadeDrive(xSpeed, zRotation);
  }
  public void setMotorSpeed(double speed) {
    frontLeft.set(ControlMode.PercentOutput, speed);
    frontRight.set(ControlMode.PercentOutput, speed);
    backLeft.set(ControlMode.PercentOutput, speed);
    backRight.set(ControlMode.PercentOutput, speed);
  }
  @Override
  public void periodic() {
    displayOnShuffleboard();
  }
}
