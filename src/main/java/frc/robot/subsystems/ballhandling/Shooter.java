package frc.robot.subsystems.ballhandling;

import static frc.robot.Constants.SHOOTER_MOTOR_ID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.kTimeoutMs;

public class Shooter extends SubsystemBase {
	// PID Shooter, still WIP

	/**
	 * Some explanation to this PID System. PID is a control system which is utilized 
	 * to control a certain variable in a feedback loop. In this scenario, the velocity
	 * of the shooter is being controlled. For those of you who have taken/known Calculus,
	 * recall the time derivatives of position. We are dealing with the first time derivative,
	 * otherwise known as velocity, with this system. Knowing this, when we differentiate we 
	 * get the second time derivative, aka acceleration, and integration yields displacement.
	 * 
	 * This is important because these metrics yield us a lot of important information. 
	 * In the scenario of PID, a set of heuristic constants are experimentally
	 * determined as multiplicative coefficients of the standard equation. 
	 * 
	 * For those interested in the formula, you can search it online, since we all know how bad
	 * inline math looks, especially in code.
	 * 
	 * In terms of actually computing the velocity, we're computing a linear velocity for the 
	 * shooter mechanism. If you've taken a physics course, recall the relationship between
	 * linear speed and angular speed. In case you forgot (or haven't taken physics, in which case L),
	 * the relationship is described by v=rω. v is our linear speed, r is our radius, and ω is our 
	 * angular speed. Angular speed in the formula has the units of radians/second, but typically
	 * we know the rpm of the motors, but not the radians/second typically. We can easily convert
	 * between the two measures and apply the necessary formula in order to calculate our linear speed.
	*/

	private final static double SHOOTER_WHEEL_RADIUS = 2.0 / 12.0;
	//private final static int MAXRPM = 5200;

	private final WPI_TalonFX shooterMotor = new WPI_TalonFX(SHOOTER_MOTOR_ID);
	private final double kP = .135;
	private final double kI = kP * .001;
	private final double kD = kP * 20;

	public Shooter() {
		shooterMotor.config_kP(0, kP);
		shooterMotor.config_kI(0, kI);
		shooterMotor.config_kD(0, kD);

		// Sets the minimum percent output
		shooterMotor.configNominalOutputForward(0, kTimeoutMs);
		shooterMotor.configNominalOutputReverse(0, kTimeoutMs);
		// Sets the maximum percent output
		shooterMotor.configPeakOutputForward(1, kTimeoutMs);
		shooterMotor.configPeakOutputReverse(-1, kTimeoutMs);
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
