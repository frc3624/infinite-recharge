package frc.robot.subsystems;

import static frc.robot.Constants.DRIVE_LEFT_MASTER_ID;
 import static frc.robot.Constants.DRIVE_LEFT_SLAVE_ID;
 import static frc.robot.Constants.DRIVE_RIGHT_MASTER_ID;
 import static frc.robot.Constants.DRIVE_RIGHT_SLAVE_ID;
 import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
 import edu.wpi.first.wpilibj.drive.DifferentialDrive;
 import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
 import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * This year's Drive was interesting in a few ways. We used a West Coast drive system, which was functionally the same
 * in regards to code. The interesting part though, is in regards to our motors. Let me put this bluntly. The Falcons
 * are f*cking FAST. WAY to fast for our drivers to accurately handle for the majority of our operation. We utilized
 * software speed shifting as opposed to traditional gear based shifting for this year. You can look at how we
 * implemented it below in the code through the use of enums.
 */
public class Drive extends SubsystemBase {

	public enum GearState {
		HighGear(.8), LowGear(.5), DefenseGear(1);
		private double multiplier;

		private GearState(double multiplier){
			this.multiplier = multiplier; 
		}

		private double getGearSpeedMultipier() {
			return multiplier;
		}
	}

	private final WPI_TalonFX leftMaster = new WPI_TalonFX(DRIVE_LEFT_MASTER_ID);
	private final WPI_TalonFX leftSlave = new WPI_TalonFX(DRIVE_LEFT_SLAVE_ID);
	private final WPI_TalonFX rightMaster = new WPI_TalonFX(DRIVE_RIGHT_MASTER_ID);
	private final WPI_TalonFX rightSlave = new WPI_TalonFX(DRIVE_RIGHT_SLAVE_ID);

	private final DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster);

	private GearState currentGear = GearState.HighGear;

	public Drive() {
		leftSlave.follow(leftMaster);
		rightSlave.follow(rightMaster);
	}

	public void displayOnShuffleboard() {
		SmartDashboard.putString("Current Gear", currentGear.toString());
	}

	public static double speedMultiplier = 0.8; 

	public void highGear() {
		currentGear = GearState.HighGear;
		speedMultiplier = currentGear.getGearSpeedMultipier();
	}

	public void lowGear() {
		currentGear = GearState.LowGear;
		speedMultiplier = currentGear.getGearSpeedMultipier();
	}

	public void defenseGear() {
		currentGear = GearState.DefenseGear;
		speedMultiplier = currentGear.getGearSpeedMultipier();
	}

	public boolean isHighGear() {
		return speedMultiplier == 0.8;
	}

	public boolean isLowGear() {
		return speedMultiplier == 0.5;
	}

	public boolean isDefenseGear() {
		return speedMultiplier == 1;
	}

	public GearState getCurrentGear() {
		return currentGear;
	}

	/**
	 * Sets speed for the drive motors utilizing inputs from the joysticks.
	 * @param xSpeed Forward/Backward direction from the joysticks
	 * @param zRotation Left/Right direction from the joysticks
	 */
	public void arcadeDrive(double xSpeed, double zRotation) {
		diffDrive.arcadeDrive(speedMultiplier * xSpeed, speedMultiplier * .9 * zRotation); // .9 requested by drive team, serves no real purpose
	}
}
