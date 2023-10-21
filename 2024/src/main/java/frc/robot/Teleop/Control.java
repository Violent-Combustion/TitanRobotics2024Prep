package frc.robot.Teleop;

import frc.robot.sub.TankDrive;
import frc.robot.data.ButtonMap;
import frc.robot.sub.Controllers;

public class Control extends Teleopsubsystem {
    private TankDrive mTankDrive = null;
    //private SwerveDrive mSwerveDrive = null;
    private final Controllers controllers;

    public Control()
    {
        mTankDrive = TankDrive.getInstance();
        controllers = new Controllers();
    }

    /**Performs all updates needed to be executed durning Telop */
    public void telopUpdate()
    {
        this.tank();
        mTankDrive.update();
    } 

    /**
     * Tank is when the the left joystick controls the left side of the robot
     * and the right joystick controls the right side of the robot. 
     */
    public void tank(){
        double xboxLeftStickYInput = controllers.getStickXbox(ButtonMap.XboxLEFTSTICKY);
        double xboxRightStickXInput = controllers.getStickXbox(ButtonMap.XboxRIGHTSTICKX);
        mTankDrive.tankDrive(xboxLeftStickYInput, xboxRightStickXInput);
    }

}
