package example.ultils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigReader {
    public static String getMobileName() {
        return System.getProperty("devices", "default");
    }

    public static String getProperty(String propertyName) {
        Config config = ConfigFactory.load("serenity.conf");
        String mobileName = getMobileName();
        return config.getString("appium.devices." + mobileName + "." + propertyName);
    }

}