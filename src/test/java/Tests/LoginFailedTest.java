package Tests;

import PageObject.LoginPage;
import org.testng.annotations.Test;

public class LoginFailedTest extends TestBase{

    @Test
    public void asUserTryLogintoAccountFail(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordFieldFailed();
        loginPage.clickIntoLogInButton();
    }
}
