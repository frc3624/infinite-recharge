package frc.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class TriggerButton extends Button {
    private XboxController controller;
    private int axis;
    private double threshhold;
    public TriggerButton(XboxController controller, int axis, double threshhold){
        this.controller = controller;
        this.axis = axis;
        this.threshhold = threshhold;
    }
    @override
    public boolean get(){
        return controller.getAxis(axis) = threshhold;
    } 

    public enum Trigger{
        AXIS_LEFT(2),
        AXIS_RIGHT(3);
        private int axisNumber;
        Trigger(int axisNumber){
            this.axisNumber = axisNumber;
        }
    }

}
