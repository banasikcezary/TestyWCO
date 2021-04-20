package Tests;

import PageObject.Dialog;
import PageObject.GroupPage;
import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;
import java.text.SimpleDateFormat;

public class SmsVerAddAndDeleteRoleWithGroup extends TestBase {

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
        user.clickOnSmsVerifyAddAndDeleteRoleWithGroup();
        loginPage.clickOnLogoutButton();
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("KarolN");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();
        String lastDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis() + 600000L);
        System.out.println(lastDate);
        user.clickOnUserAndPermissionButton();
        GroupPage group = new GroupPage(driver);
        group.clickOnGroupButton();
        group.clickOnChooseGroup();
        group.selectChooseRole();
        group.clickAddRoleButton();
        String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis() + 660000L);
        System.out.println(nowDate);
        DatabaseTestingDemo databaseTestingDemo = new DatabaseTestingDemo();
        String smsKey = databaseTestingDemo.test(lastDate, nowDate);
        System.out.println(smsKey);
        PageObject.Dialog dialog = new Dialog(driver);
        dialog.confirmSms(smsKey);
        group.validateAddRoleForGroup();
        dialog.confirmPopup();
        group.clickOnGroupButton();
        String lastDate2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis() + 600000L);
        group.clickOnChooseGroup();
        group.clickDeleteRoleButton();
        dialog.clickOnConfirmButton();
        String nowDate2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis() + 660000L);
        String smsKey2 = databaseTestingDemo.test(lastDate2, nowDate2);
        System.out.println(smsKey2);
        dialog.confirmSms(smsKey2);
        dialog.clickOnAcceptPopupButton();
        group.validateDeleteRoleForGroup();

     user.clickOnUserAndPermissionButton();
     user.clickOnLinkPrivilleges();
     user.turnOffSmsVerifyAddAndDeleteRoleWithGroup();

    }
}
