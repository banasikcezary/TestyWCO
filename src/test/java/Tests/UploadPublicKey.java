package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;

public class UploadPublicKey extends TestBase{

    @Test(priority = 4,
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
        configuration.choosePublicKey();
        configuration.chooseTypeKey();
        configuration.chooseTypeAesKey();
        configuration.clickOnCheckboxPublicKey();
        configuration.typePublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy74NWTH+irNxCQSXTHVqEf8A/41EJg5ilrOYfCwEeaU5TFO/36iQiAuYifYGPDjsRAEaGSpXnFkSLqVxsufMeorC3z/mgcHSv5+tMldTA1u2df5zYa9LEKfTnHctKMtsXvvNOl8wDL6aML0OX+Z4OnX1k/PXVHGjlkHYKoDh+ephoKvqjQ3tzD5l8RXrlXzNQf3CAB063Xaom48M9Z0uAVrEQONLdcXNHcsWqjacNK8tgYMc1mtrw8ChrVcmPfoM4x8ytjZ2Otref0xhdu9QnZ2oNI+Jskk8NsgkjCJj46hbGKn7p65v8hpHCDFkjxB35sNULlX9awic3GXH5dISlQIDAQAB");
        configuration.clickSaveButton();
        PageObject.Dialog dialog=new Dialog(driver);
        dialog.clickOnContinueGenerateKey();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnSettingsRec();
        configuration.verifyGeneratePubliccKey();


    }
    }
