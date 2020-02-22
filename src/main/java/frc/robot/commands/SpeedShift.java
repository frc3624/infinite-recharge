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

  public SpeedShift(Drive drive) {
    this.drive = drive;
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("oof");
    
    if(Drive.speedMultiplier == 1) {
      drive.lowGear();
    } else {
      drive.highGear();
    }
  }
}
