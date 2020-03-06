/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
//import frc.robot.commands.Autonomous.*;
import frc.robot.commands.SpeedShift.*;
import frc.robot.commands.Intake_and_Shooting.*;
import frc.robot.commands.Climbing.*;
import frc.robot.subsystems.*;
import static frc.robot.Constants.*;


public class RobotContainer {
  // Our GAMER Subsystems
  private final Drive drive = new Drive();
  private final Shooter shooter = new Shooter();
  private final Climb climb = new Climb();
  private final Intake intake = new Intake();
  private final BallTrack ballTrack = new BallTrack();
  private final FalconCool falconCool = new FalconCool();


  //Our EPIC Commands
  private final DriveTrain dt = new DriveTrain(drive, driver1); //Driving and shifting
  private final DefenseShift ds = new DefenseShift(drive);
  private final LowShift ls = new LowShift(drive);
  private final HighShift hs = new HighShift(drive);
  private final ConditionalCommand ss = new ConditionalCommand(ls, hs, drive::isHighGear);

  private final RunShooterMotor rsm = new RunShooterMotor(shooter, driver1); // Shooting, Intake, and Ball Track
  private final Intaker i = new Intaker(intake, 0.6);
  private final RunBallTrack rbtIn = new RunBallTrack(ballTrack, 1);
  private final RunBallTrack rbtOut = new RunBallTrack(ballTrack, -1);

  private final Climber c = new Climber(climb, 1.0); //Climbing

  private final FalconCooler fc = new FalconCooler(falconCool);

  //private final AutoCommand ac = new AutoCommand(drive); //Autonomous


  //The Buttons and Controllers
  public static XboxController driver1 = new XboxController(XBOX_1_ID);
  public static XboxController driver2 = new XboxController(XBOX_2_ID);
  private final JoystickButton speedShift = new JoystickButton(driver1, SPEED_SHIFT_BUTTON_ID);
  private final JoystickButton defenseShift = new JoystickButton(driver1, DEFENSE_SHIFT_ID);
  private final JoystickButton shootButton = new JoystickButton(driver1, SHOOT_BUTTON_ID);
  private final JoystickButton climbButton = new JoystickButton(driver1, CLIMB_BUTTON_ID);
  private final JoystickButton intakeButton = new JoystickButton(driver1, INTAKE_BUTTON_ID);
  private final JoystickButton ballTrackIn = new JoystickButton(driver1, BALL_TRACK_IN_ID);
  private final JoystickButton ballTrackOut = new JoystickButton(driver1, BALL_TRACK_OUT_ID);
  private final JoystickButton coolFalcon = new JoystickButton(driver2, 5);

  public RobotContainer() {
    configureButtonBindings();
    drive.setDefaultCommand(dt);
  }

  private void configureButtonBindings() {
    speedShift.whenPressed(ss);
    defenseShift.whenPressed(ds);

    shootButton.whileHeld(rsm);
    //intakeButton.whileHeld(i); //We have to sort out the intake button :/
    ballTrackOut.whileHeld(rbtOut);
    ballTrackIn.whileHeld(rbtIn);

    climbButton.whileHeld(c);

    coolFalcon.whenPressed(fc);
  }

  public Command getAutonomousCommand() {
    return dt;
  }
}