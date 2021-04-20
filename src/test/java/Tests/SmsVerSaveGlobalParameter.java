package Tests;

import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;
import java.text.SimpleDateFormat;

public class SmsVerSaveGlobalParameter extends TestBase {

    @Test(priority = 2,
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


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnLinkPrivilleges();
        user.clickOnSmsVerifySaveGlobalParameter();

        loginPage.clickOnLogoutButton();
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("KarolN");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        String lastDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis() + 600000L);

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnGlobalParameter();


        configuration.switchOnRodoSms();
        PageObject.Dialog dialog=new Dialog(driver);


        String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis() + 660000L);
        System.out.println(nowDate);
        DatabaseTestingDemo databaseTestingDemo = new DatabaseTestingDemo();
        String smsKey = databaseTestingDemo.test(lastDate, nowDate);
        System.out.println(smsKey);
        dialog.confirmSms(smsKey);

configuration.verifyRodoSms();


        user.clickOnUserAndPermissionButton();
        user.clickOnLinkPrivilleges();
user.turnOffSmsVerifySaveGlobalParameter();

    }
}
