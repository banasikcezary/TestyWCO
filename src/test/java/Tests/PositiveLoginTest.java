package Tests;

import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;


public class PositiveLoginTest extends TestBase {

    @Test(priority = 1,
            description = "as User Try Positive Log into Account",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryPositiveLogintoAccount() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
    }
}
