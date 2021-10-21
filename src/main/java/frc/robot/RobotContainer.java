package frc.robot;

import static frc.robot.Constants.XBOX_1_ID;
 import static frc.robot.Constants.BUTTON_B;
 import static frc.robot.Constants.BUTTON_RB;
 import static frc.robot.Constants.BUTTON_LB;
 import static frc.robot.Constants.BUTTON_X;
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
 import frc.robot.commands.intake.RunBallTrack;
 import frc.robot.commands.intake.SetIntake;
 import frc.robot.commands.speedshift.DefenseGear;
 import frc.robot.commands.speedshift.HighGear;
 import frc.robot.commands.speedshift.LowGear;
 import frc.robot.subsystems.BallTrack;
 import frc.robot.subsystems.Drive;
 import frc.robot.subsystems.Intake;
 import frc.robot.subsystems.Shooter;

public class RobotContainer {
	// Controllers
	 private static XboxController driver1 = new XboxController(XBOX_1_ID);

	// Shooting Buttons
	 private final JoystickButton shootButton = new JoystickButton(driver1, BUTTON_X);
	 private final JoystickButton intakeButton = new JoystickButton(driver1, BUTTON_B);
	 private final DPadButton ballTrackOutButton = new DPadButton(driver1, DPadDirection.DOWN);
	 private final DPadButton ballTrackInButton = new DPadButton(driver1, DPadDirection.UP);

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
	 //private final Shoot shoot = new Shoot(shooter, .48);
	 private final SetIntake setIntake = new SetIntake(intake, 0.6);
	 private final RunBallTrack runBallTrackInwards = new RunBallTrack(ballTrack, 1);
	 private final RunBallTrack runBallTrackOutwards = new RunBallTrack(ballTrack, -1);

	// Our bs auto command just so we get points
	private final DriveStraight driveStraight = new DriveStraight(drive, .5, 3); 

	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		speedShiftButton.whenPressed(speedShift);
		defenseShiftButton.whenPressed(defenseGear);
		lowGearButton.whenPressed(lowGear);

		//shootButton.whileHeld(shoot);
		intakeButton.whileHeld(setIntake);
		ballTrackOutButton.whileHeld(runBallTrackOutwards);
		ballTrackInButton.whileHeld(runBallTrackInwards);
	}

	public Command getAutonomousCommand() {
		return driveStraight;
	}
}