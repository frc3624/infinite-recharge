package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

/**
 * Ok this really isn't a proper auto command, but I sure as hell am not wasting time on PID
 * tuning for the position when we have this little time. This'll get us the basic points
 * during sandstorm and that's about it. We'll learn proper autonomous PID controlled movement
 * when the time comes for it
 */

public class DriveStraight extends CommandBase {

    private final Drive drive;
    private final double speed;
    private final Timer timer;
    private final double duration;

    public DriveStraight(Drive drive, double speed, double duration) {
        this.drive = drive;
        this.speed = speed;
        this.timer = new Timer();
        timer.start();
        this.duration = Math.max(0, duration); // making sure time isn't negative aka permanently driving forward
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.arcadeDrive(speed, 0);
    }

    @Override
    public void end(final boolean interrupted) {
        drive.arcadeDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return timer.get() > duration;
    }
    
}