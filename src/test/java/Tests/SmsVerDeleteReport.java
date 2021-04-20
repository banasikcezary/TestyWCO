package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.ReportPage;
import PageObject.UserAndPermissions;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;
import java.text.SimpleDateFormat;

public class SmsVerDeleteReport extends TestBase {

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
        user.clickOnSmsVerifyDeleteReport();

        loginPage.clickOnLogoutButton();
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("KarolN");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnRecordedCallsReport();
        report.typeInStartReportDateForRecordedCallsField();
        report.typeInEndReportDateForRecordedCallsField();

        report.clickInSelectionMainNumber10();
        report.clickInSelectNumber10();

        report.clickInGenerateRecordedCalls();


        report.checkGenerateNewReport("Nagrane połączenia");
        report.checkStatusNewReport();


        String lastDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis() + 600000L);
        System.out.println(lastDate);
        report.clickOnReportTab();
        String quantity =report.validateQuantityReportBefore();
        report.deleteLastReport();
        PageObject.Dialog dialog=new Dialog(driver);
        dialog.clickOnConfirmButton();


        String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis() + 660000L);
        System.out.println(nowDate);
        DatabaseTestingDemo databaseTestingDemo = new DatabaseTestingDemo();
        String smsKey = databaseTestingDemo.test(lastDate, nowDate);
        System.out.println(smsKey);
        dialog.confirmSms(smsKey);

        dialog.confirmPopup();

        report.validateQuantityReportAfter(quantity);



        user.clickOnUserAndPermissionButton();
        user.clickOnLinkPrivilleges();
        user.turnOffSmsVerifyDeleteReport();


    }
}
