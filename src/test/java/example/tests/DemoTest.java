package example.tests;

import example.bases.BaseTest;
import example.ultils.AppiumDriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;

@ExtendWith(SerenityJUnit5Extension.class)
public class DemoTest extends BaseTest {

    @Test
    @Title("Test nef")
    public void main() throws InterruptedException {
        AppiumDriver appiumDriver = new AppiumDriverManager().getDriver();

        WebElement startButton = appiumDriver.findElement(new AppiumBy.ByAccessibilityId("Đăng nhập"));
        startButton.click();
//        MobileElement textboxUsername = appiumDriver.findElementByXPath("//android.widget.EditText[@text=\"Nhập tên đăng nhập hoặc email\"]");
//        textboxUsername.sendKeys("trangnt229");
//
//        MobileElement textboxPassword = appiumDriver.findElementByXPath("//android.widget.EditText[@text=\"Nhập mật khẩu\"]");
//        textboxPassword.sendKeys("Beauty@123");
//
//        MobileElement buttonLogin = appiumDriver.findElementByXPath("(//android.widget.TextView[@text=\"Đăng nhập\"])[2]");
//        buttonLogin.click();
        Thread.sleep(10000);

        appiumDriver.quit();
    }
}