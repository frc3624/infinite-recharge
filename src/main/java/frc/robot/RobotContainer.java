package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveTrain;
import frc.robot.subsystems.Drive;

public class RobotContainer {
  // The Buttons and Controllers
  private XboxController driver1;
    
  // Subsystems
  private Drive drive;
  
  //Commands
  private DriveTrain driveTrain;

  public RobotContainer() {
    configureButtonBindings();
    configureSubsystems();
    configureCommands();
    drive.setDefaultCommand(driveTrain);
  }

  private void configureButtonBindings() {
    driver1 = new XboxController(0);

  }

  private void configureSubsystems() {
    drive = new Drive();
  }

  private void configureCommands() {
    driveTrain = new DriveTrain(drive, driver1);
  }

  public Command getAutonomousCommand() {
    //return driveTrain;
    return null;
  }
}