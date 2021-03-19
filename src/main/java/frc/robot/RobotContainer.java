package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveTrain;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  // The Buttons and Controllers
  private XboxController driver1;
  private JoystickButton driver1ButtonA;
    
  // Subsystems
  private Drive drive;
  private Shooter shooter;
  private Shoot shoot;
  
  //Commands
  private DriveTrain driveTrain;

  public RobotContainer() {
    configureButtonBindings();
    configureSubsystems();
    configureCommands();
    drive.setDefaultCommand(driveTrain);
    driver1ButtonA.whenHeld(shoot);
  }

  private void configureButtonBindings() {
    driver1 = new XboxController(0);
    driver1ButtonA = new JoystickButton(driver1, 1);
  }

  private void configureSubsystems() {
    drive = new Drive();
    shooter = new Shooter();
  }

  private void configureCommands() {
    driveTrain = new DriveTrain(drive, driver1);
    shoot = new Shoot(shooter);
  }

  public Command getAutonomousCommand() {
    //return driveTrain;
    return null;
  }
}