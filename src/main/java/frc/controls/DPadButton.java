
package frc.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class DPadButton extends Button {
    private XboxController controller;
    private Direction direction;
    public enum Direction {
        DPAD_UP(0),
        DPAD_DOWN(180);
        private int angle;
        Direction(int angle) {
            this.angle = angle;
        }
        public int getAngle() {
            return angle;
        }
    }
    
    public DPadButton(XboxController controller, Direction direction) {
        this.controller = controller;
        this.direction = direction;
    }
    @Override
    public boolean get() {
        return controller.getPOV() == direction.getAngle();
    }











}