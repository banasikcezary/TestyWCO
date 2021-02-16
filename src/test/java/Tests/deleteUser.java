package Tests;

import PageObject.Configuration;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class deleteUser extends TestBase {

    @Test(priority = 5,
            description = "as Admin Try Delete User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryDeleteUser() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        String deleteUser="KarolN";

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField(deleteUser);
        configuration.selectNewUser();
        configuration.clickOnDeleteButton();

        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.typeIntoSearchUserField(deleteUser);
        user.clickOnSearchButton();

        user.assertDeleteUser(deleteUser);


    }
}
