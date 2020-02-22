/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Drive extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private WPI_TalonFX leftMaster = new WPI_TalonFX(DRIVE_LEFT_MASTER_ID);
  private WPI_TalonFX rightMaster = new WPI_TalonFX(DRIVE_RIGHT_MASTER_ID);
  private WPI_TalonFX leftSlave = new WPI_TalonFX(DRIVE_LEFT_SLAVE_ID);
  private WPI_TalonFX rightSlave = new WPI_TalonFX(DRIVE_RIGHT_SLAVE_ID);
  private DifferentialDrive diffDrive1 = new DifferentialDrive(leftMaster,rightMaster); //Slavery still doesn't work :/
  private DifferentialDrive diffDrive2 = new DifferentialDrive(leftSlave, rightSlave);

  public Drive() {
    //leftSlave.set(ControlMode.Follower, DRIVE_LEFT_MASTER_ID);
    //rightSlave.set(ControlMode.Follower, DRIVE_RIGHT_MASTER_ID);
    //leftSlave.follow(leftMaster);
    //rightSlave.follow(rightMaster);
  }
  
  public void displayOnShuffleboard() {
    SmartDashboard.putData("leftMaster", leftMaster);
    SmartDashboard.putData("rightMaster", rightMaster);
    SmartDashboard.putData("leftSlave", leftSlave);
    SmartDashboard.putData("rightSlave", rightSlave);
    SmartDashboard.putData("diffDrive1", diffDrive1);
  }

  private double speedMultiplier = 1;

  public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive1.arcadeDrive(speedMultiplier * xSpeed, zRotation);
    diffDrive2.arcadeDrive(speedMultiplier * xSpeed, zRotation);
  }

  public void highGear() {
    speedMultiplier = 1;
  }
  public void lowGear() {
    speedMultiplier = .5;
  }

  @Override
  public void periodic() {
    displayOnShuffleboard();
  }
}