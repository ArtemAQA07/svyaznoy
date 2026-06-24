package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Properties {

    public String getEmail() {
        java.util.Properties prop = new java.util.Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
            return prop.getProperty("email");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("java/config/Properties -> getEmail() -> FileInputStream не смог найти файл config.properties");
            return null;
        }
    }

    public String getPhoneNumber() {
        java.util.Properties prop = new java.util.Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
            return prop.getProperty("phoneNumber");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("java/config/Properties -> getPhoneNumber() -> FileInputStream не смог найти файл config.properties");
            return null;
        }
    }
}