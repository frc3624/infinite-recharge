/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.SpeedShift.*;
import frc.robot.subsystems.*;
import static frc.robot.Constants.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static XboxController driver1 = new XboxController(JOYSTICK_ID);
  private final JoystickButton speedShift = new JoystickButton(driver1, SPEED_SHIFT_BUTTON_ID);
  private final JoystickButton defenseShift = new JoystickButton(driver1, DEFENSE_SHIFT_ID);
  private final JoystickButton shootButton = new JoystickButton(driver1, SHOOT_BUTTON_ID);
  private final JoystickButton climbButton = new JoystickButton(driver1, CLIMB_BUTTON_ID);

  private final Drive drive = new Drive();
  private final Shooter shooter = new Shooter();
  private final Climb climb = new Climb();

  private final DriveTrain dt = new DriveTrain(drive, driver1);
  private final DefenseShift ds = new DefenseShift(drive);
  private final LowShift ls = new LowShift(drive);
  private final HighShift hs = new HighShift(drive);
  private final RunShooterMotor rsm = new RunShooterMotor(shooter, driver1);
  private final Climber c = new Climber(climb, 1.0);
  private final ConditionalCommand ss = new ConditionalCommand(ls, hs , drive::isHighGear);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    drive.setDefaultCommand(dt);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    speedShift.whenPressed(ss);
    shootButton.whileHeld(rsm);
    defenseShift.whenPressed(ds);
    climbButton.whileHeld(c);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return dt;
  }
}