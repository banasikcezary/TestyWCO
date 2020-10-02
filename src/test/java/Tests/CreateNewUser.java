package Tests;

import PageObject.Configuration;
import PageObject.LoginPage;
import PageObject.ShopPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class CreateNewUser extends TestBase {


    @Test(priority = 1,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewUser() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.upValueUser();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.selectNewUser();
        configuration.clickInCheckboxShowInGui();
        configuration.typeIntoLoginField("KarolN");
        configuration.typeIntoFirstNameField("Karol");
        configuration.typeIntoLastNameInputField("Nowak");
        configuration.typeIntoNumberInputField("444555980");
        configuration.typeIntoEmailInputField("nowakkk@o2.pl");
        configuration.clickSaveButton();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.typeIntoSearchUserField("KarolN");
        user.clickOnSearchButton();

        user.assertUser("KarolN");


    }


}
