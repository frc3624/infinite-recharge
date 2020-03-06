/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveTrain extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive drive;
  private XboxController driveController;
  /**
   * @param drive The subsystem used by this command.
   */
  public DriveTrain(Drive drive, XboxController driveController) {
    this.drive = drive;
    this.driveController = driveController;
    addRequirements(drive);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    drive.arcadeDrive(-driveController.getY(Hand.kLeft), driveController.getX(Hand.kRight));
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
