package Tests;

import PageObject.*;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerificationPermissionAdminRecording extends TestBase{


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

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.validationLoginInListUser("user1",2);
        userList.validationLoginInListUser("RomanM",2);

        RecordingPage recordingPage = new RecordingPage(driver);
        recordingPage.clickOnRecordingTab();
        recordingPage.clickOnEditTagsButton();
        recordingPage.clickTagsCheckbox();
        recordingPage.clickOnSaveEditTagsButton();
        recordingPage.clickOnRecordingTab();
        recordingPage.clickOnEditTagsButton();
        recordingPage.validationAddTagForRec();

        recordingPage.clickOnRecordingTab();
        recordingPage.clickPlayRecButton();
        recordingPage.operationAutorizationPlayRec("invalidPass");
        recordingPage.verifyWrongPassword();
        recordingPage.clickPlayRecButton();
        recordingPage.operationAutorizationPlayRec("123456");
        recordingPage.verifyPlayRecDialog();

        recordingPage.clickOnRecordingTab();
        recordingPage.chooseRecordingWithList();
        recordingPage.downloadRecordingWithList();
        recordingPage.operationAutorization("wrongPas");
        recordingPage.verifyWrongPassword();
        recordingPage.downloadRecordingWithList();
        recordingPage.operationAutorization("123456");
        String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";
        recordingPage.waitForFileDownloaded( ".zip", 50,downloadDir);
        recordingPage.verifyDownloadFile(downloadDir);



        recordingPage.clickOnRecordingTab();
        recordingPage.chooseLastRecordingWithList();
        String  quentity =recordingPage.validateQuantityReportBefore();
        recordingPage.deleteRecordingWithList();
        dialog.clickOnConfirmButton();
        dialog.confirmPopup();
        recordingPage.validateQuantityReportAfter(quentity);


    }
}
