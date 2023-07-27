package frc.robot.Teleop;

import frc.robot.sub.Drive;
import frc.robot.data.ButtonMap;
import frc.robot.sub.Controllers;

public class Control extends Teleopsubsystem {
    private final Drive drive;
    private final Controllers controllers;

    public Control()
    {
        drive = new Drive();
        controllers = new Controllers();
    }

    public void tank(){
        double xboxLeftStickYInput = controllers.getStick(ButtonMap.XboxLEFTSTICKY);
        double xboxRightStickXInput = controllers.getStick(ButtonMap.XboxRIGHTSTICKX);
        drive.drive(xboxLeftStickYInput, xboxRightStickXInput);
    }

}
