
package frc.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class DPadButton extends Button {
    public enum DPadDirection {
        DPAD_UP(0),
        DPAD_UPRIGHT(45),
        DPAD_RIGHT(90),
        DPAD_DOWNRIGHT(135),
        DPAD_DOWN(180),
        DPAD_DOWNLEFT(225),
        DPAD_LEFT(270),
        DPAD_UPLEFT(315);
        private int angle;
        DPadDirection(int angle) {
            this.angle = angle;
        }
        public int getAngle() {
            return angle;
        }
    }
    private XboxController controller;
    private DPadDirection direction;
    public DPadButton(XboxController controller, DPadDirection direction) {
        this.controller = controller;
        this.direction = direction;
    }
    @Override
    public boolean get() {
        return controller.getPOV() == direction.getAngle();
    }











}