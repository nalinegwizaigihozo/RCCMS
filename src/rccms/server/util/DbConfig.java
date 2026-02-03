package rccms.server.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads database settings from a local db.properties file (NOT committed),
 * with environment variable fallbacks.
 *
 * Keys:
 * - db.url
 * - db.user
 * - db.password
 *
 * Env fallbacks:
 * - RCCMS_DB_URL
 * - RCCMS_DB_USER
 * - RCCMS_DB_PASSWORD
 */
public final class DbConfig {

    private static final String FILE_NAME = "db.properties";

    private static final String DEFAULT_URL =
            "jdbc:postgresql://localhost:5432/church_compliance_monitoring_system_db";
    private static final String DEFAULT_USER = "postgres";

    private static volatile Properties cached;

    private DbConfig() {
    }

    public static Properties load() {
        Properties p = cached;
        if (p != null) {
            return p;
        }
        synchronized (DbConfig.class) {
            if (cached == null) {
                cached = doLoad();
            }
            return cached;
        }
    }

    public static String url() {
        return get("db.url", "RCCMS_DB_URL", DEFAULT_URL);
    }

    public static String user() {
        return get("db.user", "RCCMS_DB_USER", DEFAULT_USER);
    }

    public static String password() {
        return get("db.password", "RCCMS_DB_PASSWORD", "");
    }

    private static String get(String key, String envKey, String defaultValue) {
        String fromFile = load().getProperty(key);
        if (fromFile != null && !fromFile.trim().isEmpty()) {
            return fromFile.trim();
        }
        String fromEnv = System.getenv(envKey);
        if (fromEnv != null && !fromEnv.trim().isEmpty()) {
            return fromEnv.trim();
        }
        return defaultValue;
    }

    private static Properties doLoad() {
        Properties p = new Properties();

        // 1) Prefer working-directory db.properties (best for NetBeans run)
        File f = new File(FILE_NAME);
        if (f.isFile()) {
            try (InputStream in = new FileInputStream(f)) {
                p.load(in);
                return p;
            } catch (IOException ignored) {
                // fall through to classpath
            }
        }

        // 2) Fallback to classpath db.properties (optional)
        try (InputStream in = DbConfig.class.getClassLoader().getResourceAsStream(FILE_NAME)) {
            if (in != null) {
                p.load(in);
            }
        } catch (IOException ignored) {
            // ignore
        }

        return p;
    }
}



