/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.cooling;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FalconCool;

public class StopCoolShooter extends CommandBase {
  private final FalconCool falconCool;
  public StopCoolShooter(FalconCool falconCool) {
    this.falconCool = falconCool;
    addRequirements(falconCool);
  }

  @Override
  public void initialize() {
    falconCool.stopCoolingDriveBase();
  }
}
