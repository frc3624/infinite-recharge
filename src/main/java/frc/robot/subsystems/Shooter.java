package frc.robot.subsystems;

import static frc.robot.Constants.SHOOTER_MOTOR_ID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

  private final static double SHOOTER_WHEEL_RADIUS = 2.0 / 12.0;
  private final static int MAXRPM = 5200;

  private final WPI_TalonFX shooterMotor = new WPI_TalonFX(SHOOTER_MOTOR_ID);
  private final double kP = .135;
  private final double kI = kP * .001;
  private final double kD = kP * 20;

  public Shooter() {
    shooterMotor.config_kP(0, kP);
    shooterMotor.config_kI(0, kI);
    shooterMotor.config_kD(0, kD);
  }

  @Override
  public void periodic() {
  }

  public void displayOnShuffleboard() {
    SmartDashboard.putNumber("Velocity", shooterMotor.getSelectedSensorVelocity());
  }

  public void setLinearSpeed(double linearVelocity) {
    double rotationalVelocity = linearVelocity / SHOOTER_WHEEL_RADIUS;
    shooterMotor.set(ControlMode.Velocity, rotationalVelocity);
  }

  public void setShootMotorSpeed(double percent) {
    shooterMotor.set(ControlMode.PercentOutput, percent);
  }
  
}
