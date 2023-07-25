package frc.robot.sub;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.data.PortMap;

public class Drive extends SubSystems
{
    private final MotorController motorFrontLeft;
    private final MotorController motorRearLeft;
    private final MotorController motorFrontRight;
    private final MotorController motorRearRight;
    
   public void start() 
   {
    motorFrontLeft = new PWMVictorSPX(PortMap.FRONTLEFT.portNumber);
    motorRearLeft = new PWMVictorSPX(PortMap.REARLEFT.portNumber);
    motorFrontRight = new PWMVictorSPX(PortMap.FRONTRIGHT.portNumber);
    motorRearRight = new PWMVictorSPX(PortMap.REARRIGHT.portNumber);
   } 

   public void drive(double left, double right, double speed)// determins drriving type
   {
        
   }

   public void drive(double forward, double turn)
   {

   }

   private class DriveSave
   {
        public string drivemode;
        public double left;
        public double right;
        public double forward;
        public double turn;
        public double speed;

   }

   public void update()
   {
    
   }

}
