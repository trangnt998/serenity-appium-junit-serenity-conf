package example.bases;

import example.ultils.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class BaseSetup extends PageObject {

    public static void setup(WebDriver driver){
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
            desiredCapabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));


            desiredCapabilities.setCapability("autoGrantPermissions", true);  // Cấp quyền tự động

            URL appiumServer = new URL("http://localhost:4723");
            driver = new AppiumDriver(appiumServer, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
