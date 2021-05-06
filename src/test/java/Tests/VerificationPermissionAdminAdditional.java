package Tests;

import PageObject.*;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerificationPermissionAdminAdditional extends TestBase{


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
//        user.selectRole("AB_option");
//        user.clickAddRoleButton();
        Dialog dialog = new Dialog(driver);
//        dialog.clickOnAcceptPopupButton();
//
//        user.assertionAddRoleForUser("Admin Bierny");
//
//        loginPage.clickOnLogoutButton();
//////////////////////////////////////////////////////////////////////////


        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("RomanM2");
        loginPage.typeIntoPasswordField("pass1");
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
        userList.validationLoginInListUser("user1",2);
        userList.validationLoginInListUser("RomanM2",2);


        userList.clickIntoUserListLink();
        userList.selectAllColumns();
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
        configuration.checkGlobalParameter();





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

        UserAndPermissions user=new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.assertUser("user1");
        user.assertUser("RomanM2");

RecordingPage recordingPage=new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();



        user.clickOnUserAndPermissionButton();
      GroupPage group = new GroupPage(driver);
        group.clickOnGroupButton();
        group.clickOnAddGroupButton();
        String grupa="test1235567";
        group.typeIntoAddNameField(grupa);
        group.typeIntoAddDescriptionField("test opisu grupy");
        group.clickOnSaveNewGroupButton();
        dialog.clickOnAcceptPopupButton();
        dialog.confirmPopup();

        group.clickOnGroupButton();
        group.validateAddNewGroup(grupa);


        user.clickOnUserAndPermissionButton();
        group.clickOnGroupButton();
        group.chooseGroupWithList("test1235567");
        group.addUserToGroup("user1");
        dialog.clickOnAcceptPopupButton();
        group.chooseGroupWithList("test1235567");
        group.verifyAddUserToGroup("user1");



        configuration.clickConfigurationLink();


        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.switchOnRecordingDirectlyIncomingCallsOnUser();
        configuration.clickSaveButton();
        dialog.confirmPopup();
        userList.clickIntoUserListLink();
        userList.validationValueWtzChange();
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.verifySwitchOnRecIn();


        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.switchOnRecordingOutgoingCallsOnUser();
        configuration.clickSaveButton();
        dialog.confirmPopup();
        userList.clickIntoUserListLink();
        userList.validationValueWtzChange();
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.verifySwitchOnRecOut();

    }
}
