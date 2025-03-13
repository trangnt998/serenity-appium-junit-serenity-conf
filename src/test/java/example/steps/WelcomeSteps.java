package example.steps;

import example.pages.WelcomePage;
import net.serenitybdd.annotations.Step;

public class WelcomeSteps {
    WelcomePage welcomePage;

    @Step
    public void clickButtonLogin(){
        welcomePage.clickButtonLogin();
    }
}
