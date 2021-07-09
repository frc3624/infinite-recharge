package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*
 * When climbing, we need to keep the robot level, and the only way to do
 * that is with a gyroscope.
 * We are planning on putting a NavX, which is a gyroscope and accelerometer in one,
 * on the robot.
 * https://pdocs.kauailabs.com/navx-mxp/
 * This subsystem will just simply be an interface for the NavX, kind of like how
 * the Limelight class is.
 * Just like the Limelight class, the methods in this should have easily understandable names
 * and *if necessary*, java docs to further elaborate on what is being returned.
 */
public class MotionSensor extends SubsystemBase {

	public MotionSensor() {

	}

	@Override
	public void periodic() {
	
	}
}
