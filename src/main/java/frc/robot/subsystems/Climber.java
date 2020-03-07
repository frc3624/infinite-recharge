/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Climber extends SubsystemBase {
  private final CANSparkMax climbLeft = new CANSparkMax(LEFT_CLIMB_MOTOR_ID, MotorType.kBrushless);
  private final CANSparkMax climbRight = new CANSparkMax(RIGHT_CLIMB_MOTOR_ID, MotorType.kBrushless);
  public Climber() {

  }
  public void move(double speed) {
    climbLeft.set(speed);
    climbRight.set(-speed);
    
  }
  @Override
  public void periodic() {
  }
}
