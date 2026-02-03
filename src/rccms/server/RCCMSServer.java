package rccms.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rccms.server.service.impl.ChurchServiceImpl;
import rccms.server.service.impl.InspectionServiceImpl;
import rccms.server.service.impl.InspectionStandardServiceImpl;
import rccms.server.service.impl.InspectorServiceImpl;
import rccms.server.service.impl.UserServiceImpl;

/**
 *
 * @author IT MODERN LTD
 */
public class RCCMSServer {

    private static final int PORT = 3000;

    public static void main(String[] args) {
        try {
            System.out.println("Starting RCCMS Server...");

            // Create implementation instances
            UserServiceImpl userService = new UserServiceImpl();
            ChurchServiceImpl churchService = new ChurchServiceImpl();
            InspectorServiceImpl inspectorService = new InspectorServiceImpl();
            InspectionServiceImpl inspectionService = new InspectionServiceImpl();
            InspectionStandardServiceImpl standardService = new InspectionStandardServiceImpl();

            // Create registry
            Registry registry = LocateRegistry.createRegistry(PORT);

            // Bind services
            registry.rebind("UserService", userService);
            registry.rebind("ChurchService", churchService);
            registry.rebind("InspectorService", inspectorService);
            registry.rebind("InspectionService", inspectionService);
            registry.rebind("InspectionStandardService", standardService);

            System.out.println("RCCMS Server is running on port " + PORT);
            System.out.println("Services registered: UserService, ChurchService, InspectorService, InspectionService, InspectionStandardService");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
