package frc.robot;

import static frc.robot.Constants.BUTTON_A;
import static frc.robot.Constants.BUTTON_B;
import static frc.robot.Constants.BUTTON_LB;
import static frc.robot.Constants.BUTTON_RB;
import static frc.robot.Constants.BUTTON_X;
import static frc.robot.Constants.BUTTON_Y;
import static frc.robot.Constants.XBOX_1_ID;
import static frc.robot.Constants.XBOX_2_ID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.controls.DPadButton;
import frc.controls.DPadButton.DPadDirection;
import frc.controls.TriggerButton;
import frc.controls.TriggerButton.Trigger;
import frc.robot.commands.climbing.Climb;
import frc.robot.commands.intake_process.intake.RunBallTrack;
import frc.robot.commands.intake_process.intake.SetIntakeSpeed;
import frc.robot.commands.intake_process.shoot_balls.Shoot;
import frc.robot.commands.cooling.StartCooling;
import frc.robot.commands.cooling.StopCooling;
import frc.robot.commands.drive.JoystickDrive;
//import frc.robot.commands.Autonomous.*;
import frc.robot.commands.speedshift.DefenseGear;
import frc.robot.commands.speedshift.HighGear;
import frc.robot.commands.speedshift.LowGear;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.FalconCool;
import frc.robot.subsystems.Intake; 
import frc.robot.subsystems.Shooter;

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
  private final Conveyor conveyor = new Conveyor();
  private final FalconCool falconCool = new FalconCool();

  // Commands
  private final JoystickDrive driveTrain = new JoystickDrive(drive, driver1); 
  private final DefenseGear defenseGear = new DefenseGear(drive); 
  private final LowGear lowGear = new LowGear(drive); 
  private final HighGear highGear = new HighGear(drive); 
  private final ConditionalCommand speedShift = new ConditionalCommand(lowGear, highGear, drive::isHighGear);

  // Shooting, Intake, and Ball Track
  private final Shoot shoot = new Shoot(shooter, .48);
  private final SetIntakeSpeed setIntakeSpeed = new SetIntakeSpeed(intake, 0.6);
  private final RunBallTrack runBallTrackInwards = new RunBallTrack(conveyor, 1);
  private final RunBallTrack runBallTrackOutwards = new RunBallTrack(conveyor, -1);

  private final Climb climb = new Climb(climber, 1.0); //Climbing

  private final StartCooling startCooler = new StartCooling(falconCool);
  private final StopCooling stopCooler = new StopCooling(falconCool);
  private final ConditionalCommand toggleDriveCooling = new ConditionalCommand(stopCooler, startCooler, falconCool::isDriveCooling);

  public RobotContainer() {
    configureButtonBindings();
    drive.setDefaultCommand(driveTrain);
  }

  private void configureButtonBindings() {
    speedShiftButton.whenPressed(speedShift);
    defenseShiftButton.whenPressed(defenseGear);

    shootButton.whileHeld(shoot);
    //intakeButton.whileHeld(setIntakeSpeed); //We have to sort out the intake button :/
    ballTrackOutButton.whileHeld(runBallTrackOutwards);
    ballTrackInButton.whileHeld(runBallTrackInwards);

    //climbButton.whileHeld(climb);

    coolFalconButton.whenPressed(toggleDriveCooling);
  }

  public Command getAutonomousCommand() {
    return driveTrain;
  }
}