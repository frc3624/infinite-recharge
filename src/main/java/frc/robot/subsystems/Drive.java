package frc.robot.subsystems;

import static frc.robot.Constants.DRIVE_LEFT_MASTER_ID;
import static frc.robot.Constants.DRIVE_LEFT_SLAVE_ID;
import static frc.robot.Constants.DRIVE_RIGHT_MASTER_ID;
import static frc.robot.Constants.DRIVE_RIGHT_SLAVE_ID;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

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
    if(speedMultiplier == 0.8)
      return true;
    else
      return false;
  }

  public boolean isLowGear() {
    if(speedMultiplier == 0.5)
      return true;
    else
      return false;
  }

  public boolean isDefenseGear() {
    if(speedMultiplier == 1) 
      return true;
    else
      return false;
  }
  
  public GearState getCurrentGear() {
    return currentGear;
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    diffDrive.arcadeDrive(speedMultiplier * xSpeed, speedMultiplier * .9 * zRotation);
  }
  
  @Override
  public void periodic() {
    }
}
