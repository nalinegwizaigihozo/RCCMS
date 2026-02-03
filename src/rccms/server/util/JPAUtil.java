package rccms.server.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author IT MODERN LTD
 */
public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "RCCMS_PU";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            try {
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            } catch (Exception e) {
                System.err.println("Initial EntityManagerFactory creation failed: " + e);
                throw new ExceptionInInitializerError(e);
            }
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
