package frc.robot.sub.NewController;

import edu.wpi.first.wpilibj.XboxController;

public class Button {
    private boolean buttonRequestPressed; // work on better name, is true if button is pressed and buttonPressed() has already been called. turns of with button.
    private int myButton;
    private XboxController xboxController;

    public Button(int buttonIndex, XboxController controller)
    {
        myButton = buttonIndex;
        xboxController = controller;
    }

    public boolean buttonPressed()
    {
        if (xboxController.getRawButton(myButton)) // if da button be pressed tho
        {
            if (buttonRequestPressed) {
                return false;
            }
            return true;
        } else {
            this.buttonRequestPressed = false;
            return false;
        }
    }

    public boolean buttonHeld()
    {
        return xboxController.getRawButton(myButton);
    }
}