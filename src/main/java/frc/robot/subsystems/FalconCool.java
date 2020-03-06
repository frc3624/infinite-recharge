/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// The falcons are hotter than Kyle Bobert Diaz and need to be cooled
public class FalconCool extends SubsystemBase {
  Solenoid s = new Solenoid(0, 0);
  public FalconCool() {
    s.set(true);
  }

  @Override
  public void periodic() {
  }

  public void changePiston() { //just change the piston state
    boolean v = s.get();
    if(v)
      s.set(false);
    if(!v)
      s.set(true);
  }
}
