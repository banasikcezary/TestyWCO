package Tests;

import PageObject.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
public void asUserTryLogintoAccount(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();
    }
}
