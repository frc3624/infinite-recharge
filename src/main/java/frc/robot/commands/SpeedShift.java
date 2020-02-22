/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drive;

public class SpeedShift extends InstantCommand {
  /**
   * Creates a new GearShift.
   */
  private final Drive drive;
  private final DriveTrain driveTrain;

  public SpeedShift(Drive drive, DriveTrain driveTrain) {
    this.drive = drive;
    this.driveTrain = driveTrain;
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("oof");
    /*if (drive.getCurrentCommand() == driveTrain) {
      slowDriveTrain.schedule();
      drive.setDefaultCommand(slowDriveTrain);
    }
    if (drive.getCurrentCommand() == slowDriveTrain) {
      driveTrain.schedule();
      drive.setDefaultCommand(driveTrain);
    }*/

    
  }
}
