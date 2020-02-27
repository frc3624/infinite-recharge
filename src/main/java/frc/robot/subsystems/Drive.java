/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Drive extends SubsystemBase {
  WPI_TalonFX leftMotor1 = new WPI_TalonFX(DRIVE_LEFT_MASTER_ID);
  WPI_TalonFX leftMotor2 = new WPI_TalonFX(DRIVE_LEFT_SLAVE_ID);
  WPI_TalonFX rightMotor1 = new WPI_TalonFX(DRIVE_RIGHT_MASTER_ID);
  WPI_TalonFX rightMotor2 = new WPI_TalonFX(DRIVE_RIGHT_SLAVE_ID);

  DifferentialDrive diffDrive = new DifferentialDrive(leftMotor1, rightMotor1);
  public Drive() {
    leftMotor2.follow(leftMotor1);
    rightMotor2.follow(rightMotor1);
  }
<<<<<<< HEAD
  
  public void displayOnShuffleboard() {
    SmartDashboard.putData("leftMaster", leftMaster);
    SmartDashboard.putData("rightMaster", rightMaster);
    SmartDashboard.putData("leftSlave", leftSlave);
    SmartDashboard.putData("rightSlave", rightSlave);
    SmartDashboard.putData("diffDrive1", diffDrive1);
  }

  public static double speedMultiplier = 1;

  public void highGear() {
    speedMultiplier = 1;
  }
  public void lowGear() {
    speedMultiplier = .5;
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive1.arcadeDrive(speedMultiplier * xSpeed, speedMultiplier * zRotation);
    diffDrive2.arcadeDrive(speedMultiplier * xSpeed, speedMultiplier * zRotation);
  }

=======
  public void arcadeDrive(double xSpeed, double yRotation)
  {
    diffDrive.arcadeDrive(xSpeed*-1, yRotation);
  } 
>>>>>>> 948b7923640a7a4e180a54278550b066249ad97a
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
