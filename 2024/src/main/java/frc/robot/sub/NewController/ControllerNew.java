package frc.robot.sub.NewController;

import edu.wpi.first.wpilibj.XboxController;
import java.util.ArrayList;

/*

On Update:
    detect controller state
    update variables respectively

On Getbutton:
    return respective variable

*/

public class ControllerNew {
    private XboxController xboxController;
    private ArrayList<Button> Binds;

    private void init()
    {
    }

    private void update()
    {
    }

    public int makeBind(int buttonIndex) {
        Binds.add(new Button(buttonIndex, xboxController));
        return Binds.size(); // will work on later
    }
}