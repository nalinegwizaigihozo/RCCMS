package rccms.client.util;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rccms.common.service.ChurchService;
import rccms.common.service.InspectionService;
import rccms.common.service.InspectionStandardService;
import rccms.common.service.InspectorService;
import rccms.common.service.UserService;

/**
 *
 * @author IT MODERN LTD
 */
public class RMIClientUtil {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 3000;

    private static UserService userService;
    private static ChurchService churchService;
    private static InspectorService inspectorService;
    private static InspectionService inspectionService;
    private static InspectionStandardService standardService;

    public static UserService getUserService() {
        if (userService == null) {
            try {
                Registry registry = LocateRegistry.getRegistry(SERVER_HOST, SERVER_PORT);
                userService = (UserService) registry.lookup("UserService");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return userService;
    }

    public static ChurchService getChurchService() {
        if (churchService == null) {
            try {
                Registry registry = LocateRegistry.getRegistry(SERVER_HOST, SERVER_PORT);
                churchService = (ChurchService) registry.lookup("ChurchService");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return churchService;
    }

    public static InspectorService getInspectorService() {
        if (inspectorService == null) {
            try {
                Registry registry = LocateRegistry.getRegistry(SERVER_HOST, SERVER_PORT);
                inspectorService = (InspectorService) registry.lookup("InspectorService");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return inspectorService;
    }

    public static InspectionService getInspectionService() {
        if (inspectionService == null) {
            try {
                Registry registry = LocateRegistry.getRegistry(SERVER_HOST, SERVER_PORT);
                inspectionService = (InspectionService) registry.lookup("InspectionService");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return inspectionService;
    }

    public static InspectionStandardService getInspectionStandardService() {
        if (standardService == null) {
            try {
                Registry registry = LocateRegistry.getRegistry(SERVER_HOST, SERVER_PORT);
                standardService = (InspectionStandardService) registry.lookup("InspectionStandardService");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return standardService;
    }
}
