/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  private Servo servo = new Servo(9);
  private static final double UP_ANGLE = 225;
  private static final double DOWN_ANGLE = 45;
  private static final double FOWARD_ANGLE = 180;
  public Limelight() {

  }

  public void lookFoward(){
    servo.setAngle(FOWARD_ANGLE);
  }

  public void lookUp(){
    servo.setAngle(UP_ANGLE);
  }

  public void lookDown(){
    servo.setAngle(DOWN_ANGLE);
  }
  /**
   * @return whether or not the limelight has any valid targets
   */
  public static double findValidTargets(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);

  }

  /**
   * @return The horizontal displacement from the limelight to the target
   */
  public static double findHorizontalDistance() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
  }

  /**
   * @return the vertical displacement from the limelight to the target
   */
  public static double findVerticalDistance(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);

  }

  /**
   * @return the rotation from the limelight to the target
   */
  public static double findAngle() {
    return -NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
  }
  
  /**
   * @return the target area (0% to 100% of the image)
   */
  public static double findTargetArea() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
  }


  @Override
  public void periodic() {
  }
}
