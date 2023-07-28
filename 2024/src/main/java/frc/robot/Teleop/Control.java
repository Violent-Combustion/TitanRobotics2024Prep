package frc.robot.Teleop;

import frc.robot.sub.Drive;
import frc.robot.data.ButtonMap;
import frc.robot.sub.Controllers;

public class Control extends Teleopsubsystem {
    private Drive mDrive = null;
    private final Controllers controllers;

    public Control()
    {
        mDrive = Drive.getInstance();
        controllers = new Controllers();
    }
    public void telopUpdate()
    {
        this.tank();
        mDrive.update();
    } 

    public void tank(){
        double xboxLeftStickYInput = controllers.getStick(ButtonMap.XboxLEFTSTICKY);
        double xboxRightStickXInput = controllers.getStick(ButtonMap.XboxRIGHTSTICKX);
        mDrive.drive(xboxLeftStickYInput, xboxRightStickXInput);
    }

}
