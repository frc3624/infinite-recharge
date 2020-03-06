/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake_and_shooting;

import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class Shoot extends CommandBase {
  private final Shooter shooter;
  private final XboxController controller;

  public Shoot(Shooter shooter, XboxController controller) {
    this.shooter = shooter;
    this.controller = controller;
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    shooter.setShootMotorSpeed(0.48);
  }

  @Override
  public void end(boolean interrupted) {
    shooter.setShootMotorSpeed(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
