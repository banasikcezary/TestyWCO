package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class GenerateInternalKeyWck extends TestBase {

    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList() throws AWTException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48517583010");
        loginPage.typeIntoUsernameField("CRM8DLP5JDR");
        loginPage.typeIntoPasswordField("1234qwert");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnSettingsRec();
        configuration.clickOnInternalKey();
        configuration.chooseTypeKey();
        configuration.chooseTypeAesKey();
        configuration.clickOnCheckboxRegenerateKey();
        configuration.typePasswordKey("password");
        configuration.clickSaveButton();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnContinueGenerateKey();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnSettingsRec();
        configuration.verifyGenerateInterlanKey();





    }
}