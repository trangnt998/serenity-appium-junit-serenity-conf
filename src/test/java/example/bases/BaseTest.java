package example.bases;
import example.ultils.AppiumDriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;




public class BaseTest {
    protected static AppiumDriverManager appiumDriverManager = new AppiumDriverManager();

    @BeforeAll()
    public static void testSetup(){
        appiumDriverManager.createAppiumDriver();
    }

    @AfterAll
    public static void tearDown(){
        if (appiumDriverManager != null){
            appiumDriverManager.quitDriver();
        }
    }
}