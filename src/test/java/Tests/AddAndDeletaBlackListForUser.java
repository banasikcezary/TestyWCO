package Tests;

import PageObject.*;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class AddAndDeletaBlackListForUser extends TestBase{

    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("Pio");
        loginPage.typeIntoPasswordField("Centralka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();

        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("Pio");
        configuration.selectNewUser();
        configuration.addBlackListOnUser("Pio","BlackListaTest");

        driver.navigate().refresh();

        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("Pio");
        configuration.selectNewUser();
        configuration.deleteBlackListOnUser("Pio","BlackListaTest");

    }
}
