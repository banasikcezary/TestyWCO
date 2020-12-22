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
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
    }
}
