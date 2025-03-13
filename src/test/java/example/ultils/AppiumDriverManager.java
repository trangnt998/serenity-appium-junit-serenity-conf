package example.ultils;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import java.time.Duration;



public class AppiumDriverManager {
    private static AppiumDriver appiumDriver;


    public AppiumDriverManager createAppiumDriver() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
            desiredCapabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));


            desiredCapabilities.setCapability("autoGrantPermissions", true);  // Cấp quyền tự động

            URL appiumServer = new URL("http://localhost:4723");
            appiumDriver = new AppiumDriver(appiumServer, desiredCapabilities);
            setupDriverTimeouts();
        }catch (Exception e){
            e.printStackTrace();
        }
        return this;
    }


    public AppiumDriver getDriver(){
        return appiumDriver;
    }

    public void quitDriver(){
        appiumDriver.quit();
    }

    public void setupDriverTimeouts(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


}
