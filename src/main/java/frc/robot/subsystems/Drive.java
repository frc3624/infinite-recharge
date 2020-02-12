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
  private WPI_TalonFX leftMaster;
  private WPI_TalonFX rightMaster;
  private WPI_TalonFX leftSlave;
  private WPI_TalonFX rightSlave;
  private DifferentialDrive diffDrive1;
  private DifferentialDrive diffDrive2;
  public Drive() {
    leftMaster = new WPI_TalonFX(Constants.driveLeftMasterId);
    rightMaster = new WPI_TalonFX(Constants.driveRightMasterId);
    leftSlave = new WPI_TalonFX(Constants.driveLeftSlaveId);
    rightSlave = new WPI_TalonFX(Constants.driveRightSlaveId);
    diffDrive1 = new DifferentialDrive(leftMaster,rightMaster);
    diffDrive2 = new DifferentialDrive(leftSlave, rightSlave);

  }
  
  public void displayOnShuffleboard() {
    SmartDashboard.putData("leftMaster", leftMaster);
    SmartDashboard.putData("rightMaster", rightMaster);
    SmartDashboard.putData("leftSlave", leftSlave);
    SmartDashboard.putData("rightSlave", rightSlave);
    SmartDashboard.putData("diffDrive1", diffDrive1);
  }
  public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive1.arcadeDrive(xSpeed, zRotation);
    diffDrive2.arcadeDrive(xSpeed, zRotation);
  }
  @Override
  public void periodic() {
    displayOnShuffleboard();
  }
}
