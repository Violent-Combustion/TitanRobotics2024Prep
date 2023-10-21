package frc.robot.sub;

import java.lang.Math;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.PIDCommand;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import frc.robot.data.PortMap;
import frc.robot.sub.Controllers;

public class SwerveDrive extends ControlSubSystems
{
    public final double Length = 1; //change to actual measurement of distance between axles on each side of robot
    public final double Width = 1; //change to actual measurement of distance between axles on each side of robot

    private CANSparkMax angleMotor; //change if different motors are used
    private CANSparkMax speedMotor;
    public RelativeEncoder angleMotorEncoder;
    public PIDController pidController;
    DriveSave driveSave;

    private static SwerveDrive mSwerveInstance = null;

    public static SwerveDrive getInstance() {
      if (mSwerveInstance == null) {
          mSwerveInstance = new SwerveDrive();
      }
      return mSwerveInstance;
  }


    public SwerveDrive()
    {
        pidController = new PIDController(1, 0, 0);
        angleMotor = new CANSparkMax(PortMap.clawCANID.portNumber, MotorType.kBrushless); //change if different motors are used
        speedMotor = new CANSparkMax(PortMap.clawCANID.portNumber, MotorType.kBrushless); //change if different motors are used
        angleMotorEncoder = angleMotor.getEncoder();
    }

    public void SwerveDriveMath (double flightAxisX, double flightAxisY, double flightAxisZ) //X axis on the flight controller controls sideways component of strafing, Y axis on the flight controller controls forward/back component of strafing, Z axis controls rotation
    {
        double r = Math.sqrt ((Length * Length) + (Width * Width)); //Distance from corner wheel to opposite corner wheel of bot (ex. frontLeft to backRight); Uses Pythagorean Theorem
        flightAxisY *= -1; //flips sign (- to +, or + to -)

        double a = flightAxisX - flightAxisZ * (Length / r); //Left/Right part of the desired vector for back side motors
        double b = flightAxisX + flightAxisZ * (Length / r); //Left/Right part of the desired vector for front side motors
        double c = flightAxisY - flightAxisZ * (Width / r); //Forward/Backward part of the desired vector for left side motors
        double d = flightAxisY + flightAxisZ * (Width / r); //Forward/Backward part of the desired vector for right side motors


        double backRightSpeed = Math.sqrt((a * a) + (d * d)); //Vector for total speed of back right motor found using Pythagorean Theorem (a^2 + d^2 = speed^2)
        double backLeftSpeed = Math.sqrt((a * a) + (c * c)); //Vector for total speed of back left motor found using Pythagorean Theorem (a^2 + c^2 = speed^2)
        double frontRightSpeed = Math.sqrt((b * b) + (d * d)); //Vector for total speed of front right motor found using Pythagorean Theorem (b^2 + d^2 = speed^2)
        double frontLeftSpeed = Math.sqrt((b * b) + (c * c)); //Vector for total speed of front left motor found using Pythagorean Theorem (b^2 + c^2 = speed^2)

        double backRightAngle = Math.atan2(a, d) / Math.PI; //Angle for the back right wheel found from the arctan of the left/right part and the forward/backward part of the desired vector for the motor, divided by pi to convert it to a value between -1 and 1 for the direction motor
        double backLeftAngle = Math.atan2(a, c) / Math.PI; //Angle for the back left wheel found from the arctan of the left/right part and the forward/backward part of the desired vector for the motor, divided by pi to convert it to a value between -1 and 1 for the direction motor
        double frontRightAngle = Math.atan2(b, d) / Math.PI; //Angle for the front right wheel found from the arctan of the left/right part and the forward/backward part of the desired vector for the motor, divided by pi to convert it to a value between -1 and 1 for the direction motor
        double frontLeftAngle = Math.atan2(b, c) / Math.PI; //Angle for the front left wheel found from the arctan of the left/right part and the forward/backward part of the desired vector for the motor, divided by pi to convert it to a value between -1 and 1 for the direction motor
    }

    public void SwerveDriveMathToWheels (double swerveSpeed, double swerveAngle)
    {
        speedMotor.set (swerveSpeed);
        
    }
    
    /*Saves the current state the motors should be in */
    private class DriveSave
    {
        public double swerveFrontLeft;
        public double swerveFrontRight;
        public double swerveBackLeft;
        public double swerveBackRight;

    }

    @Override
    /*Updates the state the motors are in */
    public void update()
    {
      SwerveDriveMath(Length, Width, Length);
      SwerveDriveMathToWheels();
    }

    void swerve() 
    {

    }
}
