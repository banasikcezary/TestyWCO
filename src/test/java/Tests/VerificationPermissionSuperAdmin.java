package Tests;

import PageObject.*;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerificationPermissionSuperAdmin extends TestBase{


    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList()  {
        LoginPage loginPage = new LoginPage(driver);

        Dialog dialog = new Dialog(driver);



        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Centralka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();


        AuditLogsPage auditLogsPage=new AuditLogsPage(driver);
        auditLogsPage.searchAuditLogsWithDate("29.04.2021","29.04.2021");

        auditLogsPage.verifyViewAuditLogsFromDate("29.04.2021");

        loginPage.changePasswordUser("123!", "31231!", "122222!");
        loginPage.validationChangePasswordWrongNewValue();
        loginPage.changePasswordUser("123!", "Orangutan123!", "Orangutan123!");
        dialog.confirmPopupWrongInfo("Podane hasło jest nieprawidłowe");



        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.validationLoginInListUser("user1",5);
        userList.validationLoginInListUser("user2",5);
        userList.validationLoginInListUser("user3",5);
        userList.validationLoginInListUser("RomanM",5);
        userList.validationLoginInListUser("RomanM2",5);



        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.selectAllUser();
        userList.clickOnEditStatus();
        userList.setValueFromNotActiveToActiveMassChange();
        userList.clickOnSaveBtn();
        dialog.confirmPopup();
        userList.validationValueFromNotActiveToActiveMassChange();

        userList.clickIntoUserListLink();
        userList.clickOnButtonExportToCsv();
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";
        userList.waitForFileDownloaded( "fileName", 50,downloadDir);
        userList.verifyDownloadFile(downloadDir, "fileName");

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();


        ReportPage report=new ReportPage(driver);
        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnAuditLogsReport();
        report.typeInStartReportDateForAuditLogsField();
        report.typeInEndReportDateForAuditLogsField();
        report.clickInGenerateAuditLogs();
        report.checkGenerateNewReport("Logi Audytowe");
        report.checkStatusNewReport();

        report.clickOnReportTab();
        report.clickOnProperty();
        report.clickOnRecordedCallsReport();
        report.clickOnRecordedCallsReportCyclic();
        report.chooseValueCyclicalReport();
        report.clickInSelectionMainNumber10();
        report.clickInSelectNumber10();
        report.clickInGenerateRecordedCalls();
        dialog.confirmPopup();
        report.checkGenerateCyclicReport("Nagrane połączenia");



        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickLinkGlobalSettings();






        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.chooseSettingsArchivingCalls();
        configuration.setApiRest("adminRest","123123");
        configuration.clickSaveButton();
        dialog.confirmPopup();





        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewBlackListFunctionalities();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();



        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Roles role = new Roles(driver);
        role.clickOnRolesButton();
        role.clickOnAddRoleButton();
        String rola="testRoleName";
        role.typeIntoAddRoleNameField(rola);
        role.typeIntoAddRoleDescriptionField("Rola123");
        role.clickOnSaveNewRole();
        dialog.clickOnAcceptPopupButton();
        dialog.refreshPage();
        role.clickOnRolesButton();
        role.validateAddRole(rola);

        user.clickOnUserAndPermissionButton();
        role.clickOnRolesButton();
        role.clickDeleteRoleButton(rola);
        dialog.clickOnConfirmButton();
        dialog.clickOnAcceptPopupButton();
        role.clickOnRolesButton();


        role.validateDeleteRole(rola);



        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.assertUser("user1");
        user.assertUser("RomanM2");
        user.assertUser("user2");
        user.assertUser("RomanM");
        user.assertUser("user3");









    }
}
