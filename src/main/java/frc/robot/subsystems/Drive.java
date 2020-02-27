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
  WPI_TalonFX leftMaster = new WPI_TalonFX(DRIVE_LEFT_MASTER_ID);
  WPI_TalonFX leftSlave = new WPI_TalonFX(DRIVE_LEFT_SLAVE_ID);
  WPI_TalonFX rightMaster = new WPI_TalonFX(DRIVE_RIGHT_MASTER_ID);
  WPI_TalonFX rightSlave = new WPI_TalonFX(DRIVE_RIGHT_SLAVE_ID);

  DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster);
  public Drive() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }
  
  public void displayOnShuffleboard() {
    SmartDashboard.putData("leftMaster", leftMaster);
    SmartDashboard.putData("rightMaster", rightMaster);
    SmartDashboard.putData("leftSlave", leftSlave);
    SmartDashboard.putData("rightSlave", rightSlave);
    SmartDashboard.putData("diffDrive1", diffDrive);
  }

  public static double speedMultiplier = 0.8; //Aryan wanted this plz no kill Kyle dad

  public void highGear() {
    speedMultiplier = 0.8;
    System.out.println("high gear");
  }
  public void lowGear() {
    speedMultiplier = .5;
    System.out.println("low gear");
  }
  public void defenseGear() {
    speedMultiplier = 1;
    System.out.println("defense gear");
  }

  public boolean isHighGear() {
    if(speedMultiplier == 0.8) {
      return true;
    } else {
      return false;
    }
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive.arcadeDrive(speedMultiplier * xSpeed, (0.9 * speedMultiplier) * zRotation);
  }
  
  @Override
  public void periodic() {
    System.out.println(speedMultiplier);
  }
}
