package frc.robot;

import static frc.robot.Constants.BUTTON_A;
 import static frc.robot.Constants.BUTTON_B;
 import static frc.robot.Constants.BUTTON_LB;
 import static frc.robot.Constants.BUTTON_RB;
 import static frc.robot.Constants.BUTTON_X;
 import static frc.robot.Constants.BUTTON_Y;
 import static frc.robot.Constants.XBOX_1_ID;
 import edu.wpi.first.wpilibj.XboxController;
 import edu.wpi.first.wpilibj2.command.Command;
 import edu.wpi.first.wpilibj2.command.ConditionalCommand;
 import edu.wpi.first.wpilibj2.command.button.JoystickButton;
 import frc.controls.DPadButton;
 import frc.controls.DPadButton.DPadDirection;
 import frc.controls.TriggerButton;
 import frc.controls.TriggerButton.Trigger;
 import frc.robot.commands.auto.DriveStraight;
 import frc.robot.commands.drive.DriveTrain;
 import frc.robot.commands.intake.IntakeDown;
 import frc.robot.commands.intake.IntakeUp;
 import frc.robot.commands.intake.RunBallTrack;
 import frc.robot.commands.intake.RunIntake;
 import frc.robot.commands.shooting.Shoot;
 import frc.robot.commands.speedshift.DefenseGear;
 import frc.robot.commands.speedshift.HighGear;
 import frc.robot.commands.speedshift.LowGear;
 import frc.robot.subsystems.Drive;
 import frc.robot.subsystems.Limelight;
 import frc.robot.subsystems.ballhandling.BallTrack;
 import frc.robot.subsystems.ballhandling.Intake;
 import frc.robot.subsystems.ballhandling.Shooter; 
 //  import frc.robot.commands.shooting.RunShootingSystem;


public class RobotContainer {
	// Limelight
	 private final Limelight limelight = new Limelight();

	// Controllers
	 private static final XboxController driver1 = new XboxController(XBOX_1_ID);

	// Shooting Buttons
	 private final JoystickButton shootButton = new JoystickButton(driver1, BUTTON_X);
	 private final JoystickButton intakeButton = new JoystickButton(driver1, BUTTON_B);
	 private final DPadButton ballTrackOutButton = new DPadButton(driver1, DPadDirection.DOWN);
	 private final DPadButton ballTrackInButton = new DPadButton(driver1, DPadDirection.UP);

	 private final JoystickButton intakeUpButton = new JoystickButton(driver1, BUTTON_Y);
	 private final JoystickButton intakeDownButton = new JoystickButton(driver1, BUTTON_A);

	// Speed Shift Buttons
	 private final TriggerButton lowGearButton = new TriggerButton(driver1, Trigger.RIGHT_TRIGGER, .9);
	 private final JoystickButton speedShiftButton = new JoystickButton(driver1, BUTTON_RB);
	 private final JoystickButton defenseShiftButton = new JoystickButton(driver1, BUTTON_LB);
		
	// Subsystems
	 private final Drive drive = new Drive();
	 private final BallTrack ballTrack = new BallTrack();
	 private final Intake intake = new Intake();
	 private final Shooter shooter = new Shooter();
	
	// Drive Commands
	 private final DriveTrain driveTrain = new DriveTrain(drive, driver1); 
	 private final DefenseGear defenseGear = new DefenseGear(drive); 
	 private final LowGear lowGear = new LowGear(drive); 
	 private final HighGear highGear = new HighGear(drive); 
	 private final ConditionalCommand speedShift = new ConditionalCommand(lowGear, highGear, drive::isHighGear);
	
	
	// Shooting, Intake, and Ball Track Commands
	 // These commands were supposed to function in ParallelCommandGroups but the robot was broken
	 private final Shoot shoot = new Shoot(shooter, limelight);
	 private final RunBallTrack runBallTrackInwards = new RunBallTrack(ballTrack, 1);
	 private final RunBallTrack runBallTrackOutwards = new RunBallTrack(ballTrack, -1);
	 private final IntakeUp intakeUp = new IntakeUp(intake);
	 private final IntakeDown intakeDown = new IntakeDown(intake);
	 private final RunIntake intakeSystem = new RunIntake(intake);

	// Our bs auto command just so we get points
	 private final DriveStraight driveStraight = new DriveStraight(drive, .5, 2); 

	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		speedShiftButton.whenPressed(speedShift);
		defenseShiftButton.whenPressed(defenseGear);
		lowGearButton.whenPressed(lowGear);

		shootButton.toggleWhenPressed(shoot);
		intakeButton.toggleWhenPressed(intakeSystem);
		ballTrackOutButton.whileHeld(runBallTrackOutwards);
		ballTrackInButton.whileHeld(runBallTrackInwards);
		intakeUpButton.whenPressed(intakeUp);
		intakeDownButton.whenPressed(intakeDown);
	}

	public Command getAutonomousCommand() {
		return driveStraight;
	}
}