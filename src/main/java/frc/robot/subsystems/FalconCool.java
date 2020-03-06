/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

// The falcons are hotter than Kyle Bobert Diaz and need to be cooled
public class FalconCool extends SubsystemBase {
  private final Solenoid driveSolenoid = new Solenoid(PCM_CAN_ID, DRIVE_SOLENOID_PCM_ID);
  private final Solenoid shooterSolenoid = new Solenoid(PCM_CAN_ID, SHOOTER_SOLENOID_PCM_ID);
  public FalconCool() {
    driveSolenoid.set(true);
    shooterSolenoid.set(false);
  }

  @Override
  public void periodic() {
  }

  public void coolDriveBase() {
    driveSolenoid.set(true);
  }
  public void coolShooter() {
    shooterSolenoid.set(true);
  }

  public void stopCoolingDriveBase() {
    driveSolenoid.set(false);
  }
  public void stopCoolingShooter() {
    shooterSolenoid.set(false);
  }

  public boolean isDriveCooling() {
    if (driveSolenoid.get() == true) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isShooterCooling() {
    if (shooterSolenoid.get() == true) {
      return true;
    } else {
      return false;
    }
  }
}
