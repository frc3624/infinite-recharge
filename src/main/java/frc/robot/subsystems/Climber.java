/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.Constants.LEFT_CLIMB_MOTOR_ID;
import static frc.robot.Constants.LEFT_CLIMB_SOLENOID_PCM_ID;
import static frc.robot.Constants.PCM_CAN_ID;
import static frc.robot.Constants.RIGHT_CLIMB_MOTOR_ID;
import static frc.robot.Constants.RIGHT_CLIMB_SOLENOID_PCM_ID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  private final CANSparkMax climbLeft = new CANSparkMax(LEFT_CLIMB_MOTOR_ID, MotorType.kBrushless);
  private final CANSparkMax climbRight = new CANSparkMax(RIGHT_CLIMB_MOTOR_ID, MotorType.kBrushless);
  private final DoubleSolenoid leftDoubleSolenoid = new DoubleSolenoid(PCM_CAN_ID, LEFT_CLIMB_SOLENOID_PCM_ID);
  private final DoubleSolenoid rightDoubleSolenoid = new DoubleSolenoid(PCM_CAN_ID, RIGHT_CLIMB_SOLENOID_PCM_ID);

  public Climber() {
    openClimb();
  }

  @Override
  public void periodic() {
  }
  
  public void move(double speed) {
    climbLeft.set(speed);
    climbRight.set(-speed);

  }

  public void openClimb() {
    leftDoubleSolenoid.set(Value.kReverse);
    rightDoubleSolenoid.set(Value.kReverse);
  }

  public void lockClimb() {
    leftDoubleSolenoid.set(Value.kForward);
    rightDoubleSolenoid.set(Value.kForward);
  }
}
