package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
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
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewUserFunctionalities();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.selectNewUser();
        //configuration.clickInCheckboxShowInGui();
        configuration.typeIntoLoginField("KarolN");

        configuration.typeIntoFirstNameField("Karol");
        configuration.typeIntoLastNameInputField("N");
      //configuration.typeIntoNumberInputField("48690408930");

        configuration.typeIntoEmailInputField("now@o2.pl");
        configuration.clickSaveButton();
        configuration.clickSaveButton();
        PageObject.Dialog dialog = new Dialog(driver);
        dialog.confirmPopup();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.clickOnClearButton();
        user.typeIntoSearchUserField("KarolN");
        user.clickOnSearchButton();

        user.assertUser("KarolN");


    }


}
