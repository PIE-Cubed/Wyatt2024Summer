
package frc.robot;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;


public class Controller {

    private int                     driverPort;
    private int                     manipulatorPort;
    private int                     UNKNOWNPORT = -1;
    private static final String     DRIVERTYPE = "Controller (Xbox One For Windows)";
    private static final String     MANIPULATORTYPE = "Logitech Dual Action";
    private XboxController          driverController;
    private XboxController          manipulatorController;

    public Controller() {
        
        driverPort = getDriverPort();
        manipulatorPort = getmanipulatorPort();

        if (driverPort != UNKNOWNPORT) {
            driverController = new XboxController(driverPort);
        }

        if (manipulatorPort != UNKNOWNPORT) {
            manipulatorController = new XboxController(driverPort);
        }
    }

    public int getDriverPort() {
        int portNum;
        GenericHID genericController;

        for (portNum = 0; portNum < 6; portNum++) {
            genericController = new GenericHID(portNum);
        
            if (genericController.getName().equals(DRIVERTYPE) == true) {
                System.out.println("Driver Controller Connected");
                return portNum;
            }
        }

        System.out.println("Could not find Driver Controller");
        return UNKNOWNPORT;
    }

    public int getmanipulatorPort() {
        int portNum;
        GenericHID genericController;

        for (portNum = 0; portNum < 6; portNum++) {
            genericController = new GenericHID(portNum);
        
            if (genericController.getName().equals(MANIPULATORTYPE) == true) {
                System.out.println("Manipulator Controller Connected");
                return portNum;
            }
        }

        System.out.println("Could not find Manipulator Controller");
        return UNKNOWNPORT;
    }

    public void updatePort() {
        int updateDriverPort;
        int updateManipulatorPort;

        updateDriverPort        = getDriverPort();
        updateManipulatorPort   = getmanipulatorPort();
        

        if (updateDriverPort != driverPort && updateDriverPort != UNKNOWNPORT) {
            driverController = new XboxController(updateDriverPort);
            driverPort = updateDriverPort;
            System.out.println("Driver Controller Updated");
        }

        if (updateManipulatorPort != driverPort && updateManipulatorPort != UNKNOWNPORT) {
            manipulatorController = new XboxController(updateManipulatorPort);
            manipulatorPort = updateManipulatorPort;
            System.out.println("Manipulator Controller Updated");
        }

    }

    // Driver Controls
    
    public boolean driverA() {
        return driverController.getAButtonPressed();
    }

    public boolean driverB() {
        return driverController.getBButtonPressed();
    }

    public boolean driverX() {
        return driverController.getXButtonPressed();
    }

    public boolean driverY() {
        return driverController.getYButtonPressed();
    }

    public boolean driverLB() {
        return driverController.getLeftBumperPressed();
    }

    public boolean driverRB() {
        return driverController.getRightBumperPressed();
    }

    public boolean driverLT() {
        return driverController.getLeftTriggerAxis() > 0.5;
    }

    public boolean driverRT() {
        return driverController.getRightTriggerAxis() > 0.5;
    }

    public boolean driverLSButton() {
        return driverController.getLeftStickButton();
    }

    public boolean driverRSButton() {
        return driverController.getRightStickButton();
    }

    public boolean driverStart() {
        return driverController.getStartButtonPressed();
    }

    public boolean driverBack() {
        return driverController.getBackButtonPressed();
    }
    

    // Manipulator Controls

    public boolean manipulatorA() {
        return manipulatorController.getAButtonPressed();
    }

    public boolean manipulatorB() {
        return manipulatorController.getBButtonPressed();
    }

    public boolean manipulatorX() {
        return manipulatorController.getXButtonPressed();
    }

    public boolean manipulatorY() {
        return manipulatorController.getYButtonPressed();
    }

    public boolean manipulatorLB() {
        return manipulatorController.getLeftBumperPressed();
    }

    public boolean manipulatorRB() {
        return manipulatorController.getRightBumperPressed();
    }

    public boolean manipulatorLT() {
        return manipulatorController.getLeftTriggerAxis() > 0.5;
    }

    public boolean manipulatorRT() {
        return manipulatorController.getRightTriggerAxis() > 0.5;
    }

    public boolean manipulatorLSButton() {
        return manipulatorController.getLeftStickButton();
    }

    public boolean manipulatorRSButton() {
        return manipulatorController.getRightStickButton();
    }

    public boolean manipulatorStart() {
        return manipulatorController.getStartButtonPressed();
    }

    public boolean manipulatorBack() {
        return manipulatorController.getBackButtonPressed();
    }

    
}
