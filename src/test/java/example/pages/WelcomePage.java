package example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class WelcomePage extends PageObject {
    @FindBy(xpath = "//android.widget.TextView[@text='Đăng nhập']")
    private WebElementFacade buttonLogin;

    public void clickButtonLogin(){
        buttonLogin.click();
    }


}
