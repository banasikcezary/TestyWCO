package Tests;

import PageObject.LoginPage;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test(priority = 1)
public void asUserTryPositiveLogintoAccount(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
    }
}
