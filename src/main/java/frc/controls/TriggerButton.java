package frc.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class TriggerButton extends Button {
    public enum Trigger{
        LEFT_TRIGGER(2),
        RIGHT_TRIGGER(3);
        private int axisNumber;
        Trigger(int axisNumber){
            this.axisNumber = axisNumber;
        }
        public int getAxisValue() {
            return axisNumber;
        }
    }
    private XboxController controller;
    private Trigger trigger;
    private double threshhold;
    public TriggerButton(XboxController controller, Trigger trigger, double threshhold){
        this.controller = controller;
        this.trigger = trigger;
        this.threshhold = threshhold;
    }
    @Override
    public boolean get(){
        return controller.getRawAxis(trigger.getAxisValue()) >= threshhold;
    } 
}
