package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class JoystickDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive drive;
  private final XboxController driveController;

  public JoystickDrive(Drive drive, XboxController driveController) {
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
  public void end(final boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
