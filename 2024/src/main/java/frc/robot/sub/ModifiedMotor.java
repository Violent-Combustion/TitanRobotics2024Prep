package frc.robot.sub;

import frc.robot.data.PortMap;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ModifiedMotor extends ControlSubSystems
{
    private int portNumber;
    private final MotorController motor;
    
    public ModifiedMotor (int portNumber) 
    {
        MotorController motorTemporarily;
        try 
        {
            motorTemporarily = new PWMVictorSPX(portNumber);
    }
        catch (Exception motorNotIdenitfied) 
        {
            motorTemporarily = null;
    }
        motor = motorTemporarily;
    }
    public void set(double speed) {
        if (this.motor != null) {
            this.motor.set(speed);
        } else {
            SmartDashboard.putNumber("Error: Port Not Identified", this.portNumber);
        }
    }

}