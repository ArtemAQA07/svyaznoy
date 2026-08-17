package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TestConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream stream = TestConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (stream != null) {
                properties.load(stream);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties from classpath", e);
        }

        try (InputStream stream = new FileInputStream("config.properties")) {
            properties.load(stream);
        } catch (IOException ignored) {
        }
    }

    private TestConfig() {
    }

    public static String get(String key, String defaultValue) {
        String systemProperty = System.getProperty(key);
        if (systemProperty != null && !systemProperty.isBlank()) {
            return systemProperty;
        }

        String envKey = key.replace('.', '_').toUpperCase();
        String envValue = System.getenv(envKey);
        if (envValue != null && !envValue.isBlank()) {
            return envValue;
        }

        return properties.getProperty(key, defaultValue);
    }

    public static String baseUrl() {
        return get("baseUrl", "https://svyaznoy.instavktok.ru/");//выносим основной сайт, а в тестах уже оставляем только конкретный путь к сайту
    }

    public static String remoteUrl() {
        return get("remoteUrl", "");
    }

    public static String browser() {
        return get("browser", "chrome");
    }

    public static String browserSize() {
        return get("browserSize", "1920x1080");
    }

    public static long timeout() {
        return Long.parseLong(get("timeout", "10000"));
    }

    public static String selenoidVideoUrl() {
        return get("selenoidVideoUrl", "https://selenoid.autotests.cloud/video/");
    }

    public static boolean isRemoteRun() {
        String remoteUrl = remoteUrl();
        return remoteUrl != null && !remoteUrl.isBlank();
    }
}
