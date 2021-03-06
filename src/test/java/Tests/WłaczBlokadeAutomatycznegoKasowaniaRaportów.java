package Tests;

import PageObject.Configuration;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class WłaczBlokadeAutomatycznegoKasowaniaRaportów extends TestBase {
    @Test(priority = 3,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.switchOnBlockAutoDeleteReport();
    }
}
