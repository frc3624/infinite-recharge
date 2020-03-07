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

  public enum GearState {
    HighGear, LowGear, DefenseGear;
  }
  WPI_TalonFX leftMaster = new WPI_TalonFX(DRIVE_LEFT_MASTER_ID);
  WPI_TalonFX leftSlave = new WPI_TalonFX(DRIVE_LEFT_SLAVE_ID);
  WPI_TalonFX rightMaster = new WPI_TalonFX(DRIVE_RIGHT_MASTER_ID);
  WPI_TalonFX rightSlave = new WPI_TalonFX(DRIVE_RIGHT_SLAVE_ID);

  DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster);

  private GearState currentGear = GearState.HighGear;
  public Drive() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }
  
  public void displayOnShuffleboard() {
    SmartDashboard.putString("Current Gear", currentGear.toString());
  }

  public static double speedMultiplier = 0.8; 
  public static double turnSpeedMultiplier = 0.9 * speedMultiplier; 
  public void highGear() {
    speedMultiplier = 0.8;
    currentGear = GearState.HighGear;
    turnSpeedMultiplier = speedMultiplier * .9;
  }

  public void lowGear() {
    speedMultiplier = .5;
    turnSpeedMultiplier = speedMultiplier * .9;
    currentGear = GearState.LowGear;
  }

  public void defenseGear() {
    speedMultiplier = 1;
    currentGear = GearState.DefenseGear;
    turnSpeedMultiplier = speedMultiplier * .9;
  }

  public boolean isHighGear() {
    if(speedMultiplier == 0.8)
      return true;
    else
      return false;
  }

  public boolean isLowGear() {
    if(speedMultiplier == 0.5)
      return true;
    else
      return false;
  }

  public boolean isDefenseGear() {
    if(speedMultiplier == 1) 
      return true;
    else
      return false;
  }

  public void turnInPlace() {
    if(turnSpeedMultiplier != 1)
      turnSpeedMultiplier = 1;
    else
      turnSpeedMultiplier = speedMultiplier * .9;
  }
  
  public GearState getCurrentGear() {
    return currentGear;
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive.arcadeDrive(speedMultiplier * xSpeed, turnSpeedMultiplier * zRotation);
  }
  
  @Override
  public void periodic() {
    System.out.println(speedMultiplier);
  }
}
