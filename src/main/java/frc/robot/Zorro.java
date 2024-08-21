
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

/*  Comments from Mr. McMahon...
 *  This looks a lot like the XboxController class.  That is a good thing!
 *  What you have here all looks great!  I should have mentioned this earlier, but most of my comments
 *  have to do with making this class just like the XboxController.  Nothing wrong with what you did.  Just taking it 
 *  to next level and you even get to use inheritance.  Once you look over the XboxController code you'll
 *  probably see that this is a bigger task than you thought.  Once you make a solid Class here we'll be using it
 *  reusing it here for years to come!
 *  You may even want to call this the ZorroController to emphasize that its like the XboxController
 *  You can also click on the XboxController to see how they did things.
 *  https://github.wpilib.org/allwpilib/docs/release/java/src-html/edu/wpi/first/wpilibj/XboxController.html#line.117
 *  For instance you could have the ZorroController inherit GenericHID.  Use extend for inheritence.  See xboxController code.
 *  You can then add m_port as a class variable and save the port there.
 *
 *  You may want to pass in (int port) in your constructor and move the getZorroPort to our Controller class.
 *  Your function names could change to get getAButton() instead of zorroA().
 *  you may want to have getAButton() use getRawButton()
                         getAButtonPressed() use getRawButtonPressed()
                         getAButtonReleased() use getRawButtonReleased()
 */
public class Zorro {

    private int zorroPort;
    private int UNKNOWNPORT = -1;
    private static final String ZORROTEST = "Zorro";

    private Joystick zorroController;

    public Zorro() {

        zorroPort = getZorroPort();

        if (zorroPort != UNKNOWNPORT) {
            zorroController = new Joystick(zorroPort);
        }
    }

    public int getZorroPort() {
        int portNum;
        GenericHID genericController;

        for (portNum = 0; portNum < 6; portNum++) {
            genericController = new GenericHID(portNum);

            if (genericController.getName().equals(ZORROTEST) == true) {
                System.out.println("Zorro Controller Connected");
                return portNum;
            }
        }

        System.out.println("Could not find Zorro Controller");
        return UNKNOWNPORT;
    }

    // Zorro joystick axis
    public static int ZorroLeftXAxis = 0;
    public static int ZorroLeftYAxis = 1;

    public static int ZorroLeftDial = 2;
    public static int ZorroRightDial = 3;

    public static int ZorroRightXAxis = 4;
    public static int ZorroRightYAxis = 5;

    // Zorro buttons
    public static int ZorroA = 6;
    public static int ZorroD = 13;
    public static int ZorroG = 7;
    public static int ZorroH = 14;

    public static int ZorroEUp = 5;
    public static int ZorroEDown = 4;

    public static int ZorroFUp = 12;
    public static int ZorroFDown = 11;

    public static int ZorroBUp = 3;
    public static int ZorroBMid = 2;
    public static int ZorroBDown = 1;

    public static int ZorroCUp = 10;
    public static int ZorroCMid = 9;
    public static int ZorroCDown = 8;

    // Zorro Controls

    public boolean zorroA() {
        return zorroController.getRawButtonPressed(ZorroA);
    }

    public boolean zorroD() {
        return zorroController.getRawButtonPressed(ZorroD);
    }

    public boolean zorroG() {
        return zorroController.getRawButtonPressed(ZorroG);
    }

    public boolean zorroH() {
        return zorroController.getRawButtonPressed(ZorroH);
    }

    public boolean zorroE() {
        return zorroController.getRawButtonPressed(ZorroEDown);
    }

    public boolean zorroF() {
        return zorroController.getRawButtonPressed(ZorroFDown);
    }

    public int zorroB() {

        if (zorroController.getRawButtonPressed(ZorroBUp) == true) {

            return 1;

        } else if (zorroController.getRawButtonPressed(ZorroBDown) == true) {

            return -1;
        }
        
        return 0;
    }

    public int zorroC() {

        if (zorroController.getRawButtonPressed(ZorroCUp) == true) {

            return 1;

        } else if (zorroController.getRawButtonPressed(ZorroCDown) == true) {

            return -1;
        }
        
        return 0;
    }
}
