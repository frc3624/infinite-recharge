package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
//import frc.robot.commands.Autonomous.*;
import frc.robot.commands.speedshift.*;
import frc.robot.commands.intake_and_shooting.*;
import frc.robot.commands.climbing.*;
import frc.robot.commands.drive.DriveTrain;
import frc.robot.commands.drive.TurnInPlace;
import frc.robot.subsystems.*;
import static frc.robot.Constants.*;
import frc.controls.*;

public class RobotContainer {
  //Subsystems
  private final Drive drive = new Drive();
  private final Shooter shooter = new Shooter();
  private final Climber climber = new Climber();
  private final Intake intake = new Intake();
  private final BallTrack ballTrack = new BallTrack();
  private final FalconCool falconCool = new FalconCool();

  //Commands
  private final DriveTrain driveTrain = new DriveTrain(drive, driver1); 
  private final DefenseGear defenseGear = new DefenseGear(drive); 
  private final LowGear lowGear = new LowGear(drive); 
  private final HighGear highGear = new HighGear(drive); 
  private final ConditionalCommand speedShift = new ConditionalCommand(lowGear, highGear, drive::isHighGear);
  private final TurnInPlace turnInPlace = new TurnInPlace(drive);

  private final Shoot shoot = new Shoot(shooter, driver1); // Shooting, Intake, and Ball Track
  private final SetIntakeSpeed setIntakeSpeed = new SetIntakeSpeed(intake, 0.6);
  private final RunBallTrack runBallTrackInwards = new RunBallTrack(ballTrack, 1);
  private final RunBallTrack runBallTrackOutwards = new RunBallTrack(ballTrack, -1);

  private final Climb climb = new Climb(climber, 1.0); //Climbing

  private final FalconCooler falconCooler = new FalconCooler(falconCool);

  //private final AutoCommand ac = new AutoCommand(drive); //Autonomous


  //The Buttons and Controllers
  public static XboxController driver1 = new XboxController(XBOX_1_ID);
  public static XboxController driver2 = new XboxController(XBOX_2_ID);
  private final JoystickButton speedShiftButton = new JoystickButton(driver1, BUTTON_RB);
  private final JoystickButton turnInPlaceButton = new JoystickButton(driver1, BUTTON_A);
  private final JoystickButton defenseShiftButton = new JoystickButton(driver1, BUTTON_LB);
  private final JoystickButton shootButton = new JoystickButton(driver1, BUTTON_X);
  private final JoystickButton climbUpButton = new JoystickButton(driver1, BUTTON_Y);
  private final JoystickButton climbDownButton = new JoystickButton(driver1, BUTTON_X);
  private final JoystickButton intakeButton = new JoystickButton(driver1, BUTTON_B);//our robot has arms apparently
  private final JoystickButton ballTrackInButton = new JoystickButton(driver2, DPAD_UP);//conveyor belt looking thing
  private final JoystickButton ballTrackOutButton = new JoystickButton(driver2, DPAD_DOWN);
  private final JoystickButton coolFalconButton = new JoystickButton(driver2, 5);
  private final TriggerButton shiftLowGearTrigger = new TriggerButton(driver1, );
  

  public RobotContainer() {
    configureButtonBindings();
    drive.setDefaultCommand(driveTrain);
  }

  private void configureButtonBindings() {
    speedShiftButton.whenPressed(speedShift);
    defenseShiftButton.whenPressed(defenseGear);

    shootButton.whileHeld(shoot);
    //intakeButton.whileHeld(i); //We have to sort out the intake button :/
    ballTrackOutButton.whileHeld(runBallTrackOutwards);
    ballTrackInButton.whileHeld(runBallTrackInwards);

    //climbButton.whileHeld(climb);
    turnInPlaceButton.whenPressed(turnInPlace);

    coolFalconButton.whenPressed(falconCooler);
  }

  public Command getAutonomousCommand() {
    return driveTrain;
  }
}