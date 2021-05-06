package Tests;

import PageObject.*;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerificationPermissionCompanyRepresentative extends TestBase{


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

        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickResetPassword();
        dialog.clickOnAcceptPopupButton();

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




        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.switchOnBlockAutoDeleteReport();



        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.switchOnBlockRedirectFromPhone();
        dialog.confirmPopup();
        configuration.verifyBlockRedirectFromPhone("user1");




       configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.switchOnOppbOnUser();
        configuration.clickSaveButton();
        dialog.confirmPopup();
        userList.clickIntoUserListLink();
        userList.validationValueWtzChange();
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.verifySwitchOppbOnUser();


        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnSettingsRec();
        configuration.clickOnInternalKey();
        configuration.chooseTypeKey();
        configuration.chooseTypeAesKey();
        configuration.clickOnCheckboxRegenerateKey();
        configuration.typePasswordKey("123456");
        configuration.clickSaveButton();
        dialog.clickOnContinueGenerateKey();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnSettingsRec();
        configuration.verifyGenerateInterlanKey();


        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewBlackListFunctionalities();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();

        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnBlackListFunctionality();
        configuration.clickOnLastBlackList("Czarna");
        configuration.completeNameAndDescription("BlackListaTest","DescBlackList");
        configuration.addNumberForBlackList("48333444333");
        configuration.clickOnButtonSaveBlackList();
        configuration.clickOnFunctionalitySettings();
        configuration.verifySaveBlackList("BlackListaTest");
        configuration.clickOnLinkActivationBlackList();
        configuration.clickOnActivationLastBlackList();
        configuration.verifyActivateBlacklist();


        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.addBlackListOnUser("user1","BlackListaTest");
        configuration.clickSaveButton();
        dialog.confirmPopup();



        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.chooseSettingsArchivingCalls();
        configuration.setApiRest("adminRest","123123");
        configuration.clickSaveButton();
        dialog.confirmPopup();



        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.assertUser("user1");
        user.assertUser("RomanM2");
        user.assertUser("user2");
        user.assertUser("RomanM");
        user.assertUser("user3");




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


        user.clickOnUserAndPermissionButton();
        group.clickOnGroupButton();
        group.clickOnChooseGroup();
        group.selectChooseRole("AG_option");
        group.clickAddRoleButton();
        group.validateAddRoleForGroup("Admin Główny");


        user.clickOnUserAndPermissionButton();
        user.clickOnLinkPrivilleges();
        user.clickOnSmsVerifyDeleteReport();
        user.clickOnUserAndPermissionButton();
        user.clickOnLinkPrivilleges();
        user.turnOffSmsVerifyDeleteReport();




    }
}
