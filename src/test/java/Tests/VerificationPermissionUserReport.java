package Tests;

import PageObject.AuditLogsPage;
import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.ReportPage;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerificationPermissionUserReport extends TestBase{


    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList()  {
        LoginPage loginPage = new LoginPage(driver);
//        loginPage.typeIntoPhoneNumberField("+48690408932");
//        loginPage.typeIntoUsernameField("Pio");
//        loginPage.typeIntoPasswordField("Centralka123456!");
//        loginPage.clickIntoLogInButton();
//        loginPage.checkPositiveLoginToApp();
//
//        UserAndPermissions user = new UserAndPermissions(driver);
//        user.clickOnUserAndPermissionButton();
//        user.clickOnUserButton();
//        user.clickOnClearButton();
//        user.typeIntoSearchUserField("KarolN");
//        user.clickOnSearchButton();
//        user.clickOnShowRoleButton();
//        user.clickOnAddAssignmentButton();
//        user.selectRole("UT_option");
//        user.clickAddRoleButton();
        Dialog dialog = new Dialog(driver);
//        dialog.clickOnAcceptPopupButton();
//
//        user.assertionAddRoleForUser("Użytkownik Telefoniczny");
//
//        loginPage.clickOnLogoutButton();
//////////////////////////////////////////////////////////////////////////


        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("RomanM");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        AuditLogsPage auditLogsPage=new AuditLogsPage(driver);
        auditLogsPage.searchAuditLogsWithDate("26.04.2021","26.04.2021");
        auditLogsPage.verifyViewAuditLogsFromDate("26.04.2021");

        loginPage.changePasswordUser("123!", "31231!", "122222!");
        loginPage.validationChangePasswordWrongNewValue();
        loginPage.changePasswordUser("123!", "Orangutan123!", "Orangutan123!");
        dialog.confirmPopupWrongInfo("Podane hasło jest nieprawidłowe");


       ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnAuditLogsReport();
        report.clickOnAuditLogsReportCyclic();
        report.chooseValueCyclicalReport();
        report.clickInGenerateAuditLogs();
        dialog.confirmPopup();
        report.checkGenerateCyclicReport("Logi Audytowe");

driver.navigate().refresh();
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



        report.clickOnReportTab();
        report.downloadLastReportCSV();
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";
        report.waitForFileDownloaded( "Raport", 50,downloadDir);
        report.verifyDownloadFile(downloadDir);



        report.clickOnReportTab();
        report.downloadLastReportPDF();
        report.waitForFileDownloaded( "Raport", 50,downloadDir);
        report.verifyDownloadFile(downloadDir);



    }
}
