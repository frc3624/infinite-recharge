package frc.robot;

import static frc.robot.Constants.BUTTON_A;
 import static frc.robot.Constants.BUTTON_B;
 import static frc.robot.Constants.BUTTON_LB;
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
 import frc.robot.commands.drive.JoystickDrive;
 import frc.robot.commands.speedshift.DefenseGear;
 import frc.robot.commands.speedshift.HighGear;
 import frc.robot.commands.speedshift.LowGear;
 import frc.robot.subsystems.Conveyor;
 import frc.robot.subsystems.Drive;
 import frc.robot.subsystems.Intake; 
 import frc.robot.subsystems.Shooter;
 import static frc.robot.Constants.BUTTON_RB;

public class RobotContainer {
	// The Buttons and Controllers
	private static XboxController driver1 = new XboxController(XBOX_1_ID);
	private static XboxController driver2 = new XboxController(XBOX_2_ID);

	private final TriggerButton shiftLowGearTrigger = new TriggerButton(driver1, Trigger.RIGHT_TRIGGER, .9);
	private final JoystickButton speedShiftButton = new JoystickButton(driver1, BUTTON_RB);
	private final JoystickButton defenseShiftButton = new JoystickButton(driver1, BUTTON_LB);
	private final JoystickButton intakeButton = new JoystickButton(driver1, BUTTON_B);

	private final JoystickButton shootButton = new JoystickButton(driver2, BUTTON_X);
	private final DPadButton ballTrackInButton = new DPadButton(driver2, DPadDirection.UP);
	private final DPadButton ballTrackOutButton = new DPadButton(driver2, DPadDirection.DOWN);
		
	// Subsystems
	private final Drive drive = new Drive();
	private final Shooter shooter = new Shooter();
	private final Intake intake = new Intake();
	private final Conveyor conveyor = new Conveyor();

	// Commands
	private final JoystickDrive driveTrain = new JoystickDrive(drive, driver1); 
	private final DefenseGear defenseGear = new DefenseGear(drive); 
	private final LowGear lowGear = new LowGear(drive); 
	private final HighGear highGear = new HighGear(drive); 
	private final ConditionalCommand speedShift = new ConditionalCommand(lowGear, highGear, drive::isHighGear);

	// Shooting, Intake, and Ball Track
	// private final Shoot shoot = new Shoot(shooter, .48);
	// private final SetIntakeSpeed setIntakeSpeed = new SetIntakeSpeed(intake, 0.6);
	// private final RunBallTrack runBallTrackInwards = new RunBallTrack(conveyor, 1);
	// private final RunBallTrack runBallTrackOutwards = new RunBallTrack(conveyor, -1);

	public RobotContainer() {
		configureButtonBindings();
		drive.setDefaultCommand(driveTrain);
	}

	private void configureButtonBindings() {
		speedShiftButton.whenPressed(speedShift);
		defenseShiftButton.whenPressed(defenseGear);

		//shootButton.whileHeld(shoot);
		//intakeButton.whileHeld(setIntakeSpeed); //We have to sort out the intake button :/
		// ballTrackOutButton.whileHeld(runBallTrackOutwards);
		// ballTrackInButton.whileHeld(runBallTrackInwards);
	}

	public Command getAutonomousCommand() {
		return driveTrain;
	}
}