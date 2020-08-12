package Tests;

import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class LoginFailedTest extends TestBase {

    @Test(priority = 1,
            retryAnalyzer = RetryAnalyzer.class)
    public void asUserTryLogintoAccountFail() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordFieldFailed("bad");
        loginPage.clickIntoLogInButton();

        loginPage.checkNegativeLoginToApp();

    }
}
