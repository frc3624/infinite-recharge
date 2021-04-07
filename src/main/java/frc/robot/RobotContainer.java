package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.BallFeeder;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  // The Buttons and Controllers
  //private XboxController driver1;
  private XboxController shootStick;
  private JoystickButton speed1Button;
  private JoystickButton speed2Button;
  private JoystickButton speed3Button;
  private JoystickButton speed4Button;
  private JoystickButton trackButton;
  //private JoystickButton driver1ButtonA;
  //private JoystickButton driver1ButtonB;
    
  // Subsystems
  private Drive drive;
  private Shooter shooter;
  private BallFeeder feeder;
  
  //Commands - FOREWARNING I KNOW THIS IS GARBAGE, WE'LL FIX IT LATER THIS IS JUST THE LAZIEST WAY TO DO IT TO APPEASE WILSON
  private DriveTrain driveTrain;
  private MoveBallPositioner moveBallPositioner;
  private Speed1 speed1;
  private Speed2 speed2;
  private Speed3 speed3;
  private Speed4 speed4;

  public RobotContainer() {
    configureButtonBindings();
    configureSubsystems();
    configureCommands();
    drive.setDefaultCommand(driveTrain);
    
    speed1Button.whenHeld(speed1);
    speed2Button.whenHeld(speed2);
    speed3Button.whenHeld(speed3);
    speed4Button.whenHeld(speed4);

    trackButton.whenHeld(moveBallPositioner);
  }

  private void configureButtonBindings() {
    //driver1 = new XboxController(0);
    shootStick = new XboxController(0);
    trackButton = new JoystickButton(shootStick, 6);
    speed1Button = new JoystickButton(shootStick, 1);
    speed2Button = new JoystickButton(shootStick, 3);
    speed3Button = new JoystickButton(shootStick, 4);
    speed4Button = new JoystickButton(shootStick, 2);

    //driver1ButtonA = new JoystickButton(driver1, Constants.XBOX_A_BUTTON);
    //driver1ButtonB = new JoystickButton(driver1, Constants.XBOX_B_BUTTON);
  }

  private void configureSubsystems() {
    drive = new Drive();
    shooter = new Shooter();
    feeder = new BallFeeder();
  }

  private void configureCommands() {
    driveTrain = new DriveTrain(drive, shootStick);
    moveBallPositioner = new MoveBallPositioner(feeder);
    speed1 = new Speed1(shooter);
    speed2 = new Speed2(shooter);
    speed3 = new Speed3(shooter);
    speed4 = new Speed4(shooter);
  }

  public Command getAutonomousCommand() {
    //return driveTrain;
    return null;
  }
}