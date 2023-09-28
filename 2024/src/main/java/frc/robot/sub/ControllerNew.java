package frc.robot.sub;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.data.ButtonMap;
import frc.robot.data.PortMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Map;
import edu.wpi.first.wpilibj.Timer;

/*

On Update:
    detect controller state
    update variables respectively

On Getbutton:
    return respective variable

*/

public class ControllerNew {
    private XboxController xboxController;
    private Map<ButtonMap, Boolean> Buttons;

    private void init() {
        Buttons.put(ButtonMap.XboxA, false);
    }

    private void update() {
        for (Map.Entry<ButtonMap, Boolean> e : Buttons.entrySet()) {
        }
    }
}
