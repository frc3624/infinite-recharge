package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import frc.robot.commands.Autonomous.*;
import frc.robot.commands.speedshift.*;
import frc.robot.commands.intake_and_shooting.*;
import frc.robot.commands.climbing.*;
import frc.robot.commands.cooling.*;
import frc.robot.commands.drive.DriveTrain;
import frc.robot.subsystems.*;
import static frc.robot.Constants.*;
import frc.controls.*;
import static frc.controls.DPadButton.DPadDirection;
import frc.controls.TriggerButton.Trigger;

public class RobotContainer {
  // The Buttons and Controllers
  private static XboxController driver1 = new XboxController(XBOX_1_ID);
  private static XboxController driver2 = new XboxController(XBOX_2_ID);

  private final TriggerButton shiftLowGearTrigger = new TriggerButton(driver1, Trigger.RIGHT_TRIGGER, .9);
  private final JoystickButton turnInPlaceButton = new JoystickButton(driver1, BUTTON_A);
  private final JoystickButton speedShiftButton = new JoystickButton(driver1, BUTTON_RB);
  private final JoystickButton defenseShiftButton = new JoystickButton(driver1, BUTTON_LB);  
  private final JoystickButton climbUpButton = new JoystickButton(driver1, BUTTON_Y);
  private final JoystickButton climbDownButton = new JoystickButton(driver1, BUTTON_X);
  private final JoystickButton intakeButton = new JoystickButton(driver1, BUTTON_B);

  private final JoystickButton shootButton = new JoystickButton(driver2, BUTTON_X);
  private final DPadButton ballTrackInButton = new DPadButton(driver2, DPadDirection.DPAD_UP);
  private final DPadButton ballTrackOutButton = new DPadButton(driver2, DPadDirection.DPAD_DOWN);
  private final JoystickButton coolFalconButton = new JoystickButton(driver2, BUTTON_LB);
    
  // Subsystems
  private final Drive drive = new Drive();
  private final Shooter shooter = new Shooter();
  private final Climber climber = new Climber();
  private final Intake intake = new Intake();
  private final BallTrack ballTrack = new BallTrack();
  private final FalconCool falconCool = new FalconCool();
  private final Compressor compressor = new Compressor(0);

  // Commands

  private final DriveTrain driveTrain = new DriveTrain(drive, driver1); 
  private final DefenseGear defenseGear = new DefenseGear(drive); 
  private final LowGear lowGear = new LowGear(drive); 
  private final HighGear highGear = new HighGear(drive); 
  private final ConditionalCommand speedShift = new ConditionalCommand(lowGear, highGear, drive::isHighGear);

  // Shooting, Intake, and Ball Track
  private final Shoot shoot = new Shoot(shooter, .48);
  private final SetIntakeSpeed setIntakeSpeed = new SetIntakeSpeed(intake, 0.6);
  private final RunBallTrack runBallTrackInwards = new RunBallTrack(ballTrack, 1);
  private final RunBallTrack runBallTrackOutwards = new RunBallTrack(ballTrack, -1);

  private final Climb climb = new Climb(climber, 1.0); //Climbing

  private final CoolDriveBase driveCooler = new CoolDriveBase(falconCool);
  private final StopCoolDriveBase stopDriveCooler = new StopCoolDriveBase(falconCool);
  private final ConditionalCommand toggleDriveCooling = new ConditionalCommand(stopDriveCooler, driveCooler, falconCool::isDriveCooling);
  private final CoolShooter shooterCooler = new CoolShooter(falconCool);
  private final StopCoolShooter stopShooterCooler = new StopCoolShooter(falconCool);
  private final ConditionalCommand toggleShooterCooling = new ConditionalCommand(stopShooterCooler, shooterCooler, falconCool::isShooterCooling);

  //private final AutoCommand ac = new AutoCommand(drive); //Autonomous  

  public RobotContainer() {
    configureButtonBindings();
    drive.setDefaultCommand(driveTrain);
    compressor.stop();
  }

  private void configureButtonBindings() {
    speedShiftButton.whenPressed(speedShift);
    defenseShiftButton.whenPressed(defenseGear);

    shootButton.whileHeld(shoot);
    //intakeButton.whileHeld(i); //We have to sort out the intake button :/
    ballTrackOutButton.whileHeld(runBallTrackOutwards);
    ballTrackInButton.whileHeld(runBallTrackInwards);

    //climbButton.whileHeld(climb);

    coolFalconButton.whenPressed(toggleDriveCooling.andThen(toggleShooterCooling));
  }

  public Command getAutonomousCommand() {
    return driveTrain;
  }
}