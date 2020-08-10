package Tests;

import PageObject.LoginPage;
import org.testng.annotations.Test;

public class LoginFailedTest extends TestBase{

    @Test
    public void asUserTryLogintoAccountFail(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordFieldFailed("bad");
        loginPage.clickIntoLogInButton();
    }
}
