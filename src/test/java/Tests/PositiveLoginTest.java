package Tests;

import PageObject.LoginPage;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
public void asUserTryPositiveLogintoAccount(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();
    }
}
