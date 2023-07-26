package frc.robot.sub;

import frc.robot.data.PortMap;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class Drive extends SubSystems
{
    private final MotorController motorFrontLeft;
    private final MotorController motorRearLeft;
    private final MotorController motorFrontRight;
    private final MotorController motorRearRight;
    
   public Drive() 
   {
          motorFrontLeft = new PWMVictorSPX(PortMap.FRONTLEFT.portNumber);
          motorRearLeft = new PWMVictorSPX(PortMap.REARLEFT.portNumber);
          motorFrontRight = new PWMVictorSPX(PortMap.FRONTRIGHT.portNumber);
          motorRearRight = new PWMVictorSPX(PortMap.REARRIGHT.portNumber); 
   }

/**  Control Type: Left Stick controls Left side of Robot; Right Stick Control Right side of Robot */
   public void drive(double left, double right, double speed)// determins drriving type
   { 
     this.driveSave.frontleft = left;
     this.driveSave.backleft = left;
     this.driveSave.frontright = right;
     this.driveSave.backright = right; 
   }
/**  Control Type: Left Stick controls speed; Right Stick controls direction */
   public void drive(double forward, double turn)
   { 
     this.driveSave.frontleft = (-forward + (0.35 * turn));// + teleopDriftCorrect);  //subtract 0.02 here from leftY for Menoetius
     this.driveSave.backleft = (-forward + (0.35 * turn));// + teleopDriftCorrect); //add 0.02 here to leftY for Menoetius
     this.driveSave.frontright = (forward + (0.35 * turn));// + teleopDriftCorrect); //add 0.015 here to rightY for And-You
     this.driveSave.backright = (forward + (0.35 * turn));// + teleopDriftCorrect); //add 0.015 here to rightY forAnd-You
   }

   private class DriveSave
   {
     public double frontleft;
     public double frontright;
     public double backleft;
     public double backright;
   }
   DriveSave driveSave = new DriveSave();

   public void update()
   {
    motorFrontLeft.set(this.driveSave.frontleft);
    motorRearRight.set(this.driveSave.backright);
    motorRearLeft.set(this.driveSave.backleft);
    motorFrontRight.set(this.driveSave.frontright);
   }

    void tank()
   {

   }

}
