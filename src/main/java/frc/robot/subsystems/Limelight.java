package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {

	private final Servo servo = new Servo(9);

	private static final double UP_ANGLE = 225;
	private static final double DOWN_ANGLE = 45;
	private static final double FORWARD_ANGLE = 180;

	public Limelight() {

	}

	public void lookForward() {
		servo.setAngle(FORWARD_ANGLE);
	}
	public void lookUp() {
		servo.setAngle(UP_ANGLE);
	}
	public void lookDown() {
		servo.setAngle(DOWN_ANGLE);
	}

	/*
	* The following methods could definitely be static since they are just referencing some other
	* static methods.
	* Even without the servo, I would have made them static just so Limelight could be similar to the
	* other subsystems.
	* With the servo, these values will change depending on where the limelight is currently facing,
	* so these should only bee called once whatever command that is using this has reserved this
	* subsystem and made it face wherever it needs to.
	*/

	/**
	 * @return Whether or not the Limelight has any valid targets
	 */
	public double hasValidTarget() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
	}

	/**
	 * @return The horizontal displacement from where the Limelight is aimed to the target
	 */
	public double getHorizontalDistance() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
	}

	/**
	 * @return The vertical displacement from where the Limelight is aimed to the target
	 */
	public double getVerticalDistance() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
	}

	/**
	 * @return The rotation of the target relative to the face of the Limelight
	 */
	public double getTargetAngle() {
		return -NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
	}

	/**
	 * @return The area of the Limelight's FOV the target takes up (0.0 to 100.0 of the image)
	 */
	public double getTargetArea() {
		return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
	}

	@Override
	public void periodic() {
	}

}