package rccms.server.util;

import java.util.HashMap;
import java.util.Map;
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
                Map<String, String> overrides = new HashMap<>();
                overrides.put("javax.persistence.jdbc.url", DbConfig.url());
                overrides.put("javax.persistence.jdbc.user", DbConfig.user());
                overrides.put("javax.persistence.jdbc.password", DbConfig.password());
                factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, overrides);
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
