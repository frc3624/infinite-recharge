package frc.robot.commands.cooling;

import edu.wpi.first.wpilibj2.command.CommandBase;

/*
 * I once brought up the question if we can make the cooling automatic, so I decided
 * to do some research on my own on how to detect temperature (like some roboRio compatible thermistor).
 * I was delighted to find out that the Falcons have built in temperature sensors
 * https://www.vexrobotics.com/vexpro/falcon-500 "Built-in motor temperature sensor"
 * 
 * Use this information as you like, but when making this I better not see you making the TalonFXs public static
 * so you can access them from here... Matt...
 */
public class AutomaticCooling extends CommandBase {

  public AutomaticCooling() throws Exception {
    throw new Exception("YOU HAVE TO MAKE THIS COMMAND YOURSELF");
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }

}
