package frc.robot.sub;

import frc.robot.data.PortMap;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class ModifiedMotor extends ControlSubSystems
{
    
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
        }
    }

}