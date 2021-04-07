// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  private WPI_TalonFX leftMaster;
  private WPI_TalonFX rightMaster;
  private WPI_TalonFX leftSlave;
  private WPI_TalonFX rightSlave;
  private DifferentialDrive diffDrive;

  /** Creates a new Drive. */
  public Drive() {
    this.leftMaster = new WPI_TalonFX(Constants.DRIVE_LEFT_MASTER_ID);
    this.rightMaster = new WPI_TalonFX(Constants.DRIVE_RIGHT_MASTER_ID);
    this.leftSlave = new WPI_TalonFX(Constants.DRIVE_LEFT_SLAVE_ID);
    this.rightSlave = new WPI_TalonFX(Constants.DRIVE_RIGHT_SLAVE_ID);
    this.diffDrive = new DifferentialDrive(leftMaster, rightMaster);
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive.arcadeDrive(xSpeed, zRotation*0.8);
  }
}
