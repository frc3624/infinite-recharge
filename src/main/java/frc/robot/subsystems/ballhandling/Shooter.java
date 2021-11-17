package frc.robot.subsystems.ballhandling;

import static frc.robot.Constants.SHOOTER_MOTOR_ID;
 import static frc.robot.Constants.kTimeoutMs;
 import com.ctre.phoenix.motorcontrol.ControlMode;
 import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
 import edu.wpi.first.networktables.NetworkTableEntry;
 import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
 import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
 import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * This is Haadi, the software director who finished up this code for the invitational
 * 
 * This is the first time we've built a shooter, and the first time we've programmed one. In the event we do a shooter 
 * again, make sure to look over this PID code.I've linked an entire markdown describing PID in detail, so if you don't 
 * know what it is check there.
 * 
 * Lines 30-37 and the setConstants() method are reusable code elements for on the fly PID turning
 * The most effective method to tune is to tune the F to approach the target, boost P until it reaches
 * the target quickly and oscillates lightly, then boost the D term (in this case I did it quite a bit).
 * After this, drop the F if you want and try to alter the P and D settings. Finally, add an I term if
 * you see it being beneficial through testing.
 * 
 * Once you establish the constants, throw them in the Constants class, but remember that you can't do
 * this until you've finalized their values. We were in a very janky position (I finished the code in 3 days)
 * and I don't want to invest the time to fix this lol.
 * 
 * We should have done the conversion from rotational to linear, it's basic physics stuff so you should do it 
 * in the future.
 * 
 * Final thing to implement would've been to pass in the data from the limelight to get the required velocity
 * This would've taken some kinematics stuff, (preferably factoring in air resistance, although this requires
 * calculus knowledge). If you're the director in the future and are reading this, maybe introduce it algebra
 * based so the majority of kids know how it works, and then use calculus (assuming you know it) in the code
 * itself for increased precision
 */

public class Shooter extends SubsystemBase {
	private final WPI_TalonFX shooterMotor = new WPI_TalonFX(SHOOTER_MOTOR_ID);
	private double kP = .15;
	private double kI = 0.00002;
	private double kD = 2.25;
	private double kF = 0.048;

	// On the fly PID Tuning
	private double rotationalVelocity = 0;
	private final ShuffleboardTab tab = Shuffleboard.getTab("Shooting");
	private final NetworkTableEntry setVelocityEntry = tab.add("Set_Velocity", 0).getEntry();
	private final NetworkTableEntry kPEntry = tab.add("kP", kP).getEntry();
	private final NetworkTableEntry kIEntry = tab.add("kI", kI).getEntry();
	private final NetworkTableEntry kDEntry = tab.add("kD", kD).getEntry();
	private final NetworkTableEntry kFEntry = tab.add("kF", kF).getEntry();


	public Shooter() {
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

	private void setConstants() {
		double kP = kPEntry.getDouble(1.0);
		double kI = kIEntry.getDouble(1.0);
		double kD = kDEntry.getDouble(1.0);
		double kF = kFEntry.getDouble(1.0);
		shooterMotor.config_kP(0, kP);
		shooterMotor.config_kI(0, kI);
		shooterMotor.config_kD(0, kD);
		shooterMotor.config_kF(0, kF);
		rotationalVelocity = setVelocityEntry.getDouble(1.0);
	}


	public void setLinearSpeed() {
		setConstants();
		shooterMotor.set(ControlMode.Velocity, rotationalVelocity);
		// velocityEntry.setDouble(shooterMotor.getSelectedSensorVelocity() * SHOOTER_WHEEL_RADIUS );
	}

	public void setShootMotorSpeed(double percent) {
		shooterMotor.set(ControlMode.PercentOutput, percent);
	}
}
