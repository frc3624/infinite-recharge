package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveTrain;
import frc.robot.commands.MoveBallPositioner;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.BallFeeder;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  // The Buttons and Controllers
  private XboxController driver1;
  private JoystickButton driver1ButtonA;
  private JoystickButton driver1ButtonB;
    
  // Subsystems
  private Drive drive;
  private Shooter shooter;
  private BallFeeder feeder;
  
  //Commands
  private DriveTrain driveTrain;
  private Shoot shoot;
  private MoveBallPositioner moveBallPositioner;

  public RobotContainer() {
    configureButtonBindings();
    configureSubsystems();
    configureCommands();
    //drive.setDefaultCommand(driveTrain);
    driver1ButtonA.whenHeld(shoot);
    driver1ButtonB.whenHeld(moveBallPositioner);
  }

  private void configureButtonBindings() {
    driver1 = new XboxController(0);
    driver1ButtonA = new JoystickButton(driver1, Constants.XBOX_A_BUTTON);
    driver1ButtonB = new JoystickButton(driver1, Constants.XBOX_B_BUTTON);
  }

  private void configureSubsystems() {
    drive = new Drive();
    shooter = new Shooter();
    feeder = new BallFeeder();
  }

  private void configureCommands() {
    driveTrain = new DriveTrain(drive, driver1);
    shoot = new Shoot(shooter);
    moveBallPositioner = new MoveBallPositioner(feeder);
  }

  public Command getAutonomousCommand() {
    //return driveTrain;
    return null;
  }
}