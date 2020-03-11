package frc.robot.commands.intake_and_shooting;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class SetIntakeSpeed extends CommandBase {
  private final Intake intake;
  private final double speed;
  public SetIntakeSpeed(Intake intake, double speed) {
    this.intake = intake;
    this.speed =speed;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intake.spinIntakeWheels(speed);
  }

  @Override
  public void end(boolean interrupted) {
    intake.spinIntakeWheels(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
