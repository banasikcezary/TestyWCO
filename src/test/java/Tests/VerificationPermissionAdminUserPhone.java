package Tests;

import PageObject.*;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerificationPermissionAdminUserPhone extends TestBase{


    @Test(priority = 2,
            description = "as Admin Try Create New User",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asAdminTryCreateNewBlackList()  {
        LoginPage loginPage = new LoginPage(driver);
//        loginPage.typeIntoPhoneNumberField("+48690408932");
//        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
//        loginPage.typeIntoPasswordField("Centralka123456!");
//        loginPage.clickIntoLogInButton();
//        loginPage.checkPositiveLoginToApp();
//
//        UserAndPermissions user = new UserAndPermissions(driver);
//        user.clickOnUserAndPermissionButton();
//        user.clickOnUserButton();
//        user.clickOnClearButton();
//        user.typeIntoSearchUserField("RomanM");
//        user.clickOnSearchButton();
//        user.clickOnShowRoleButton();
//        user.clickOnAddAssignmentButton();
//        user.selectRole("AUT_option");
//        user.clickAddRoleButton();
        Dialog dialog = new Dialog(driver);
//        dialog.clickOnAcceptPopupButton();
//
//        user.assertionAddRoleForUser("Admin Użytkowników Telefonicznych");
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

        System.out.println(" //resetuj hasło");
       //resetuj hasło
        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickResetPassword();
        dialog.clickOnAcceptPopupButton();

        System.out.println("//widzi liste userów");
        //widzi liste userów
        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.validationLoginInListUser("user1",2);
        userList.validationLoginInListUser("RomanM",2);

        System.out.println("//Może tworzyć BlacListe i WL");
        //Może tworzyć BlacListe i WL
        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.clickOnBlackListFunctionality();
        configuration.clickOnLastBlackList("z");
        configuration.completeNameAndDescription("BlackListaTest","DescBlackList");
        configuration.addNumberForBlackList("48333444333");
        configuration.clickOnButtonSaveBlackList();
        configuration.clickOnFunctionalitySettings();
        configuration.verifySaveBlackList("BlackListaTest");

        configuration.clickOnLinkActivationBlackList();
        configuration.clickOnActivationLastBlackList();

        configuration.verifyActivateBlacklist();

//        // MOże przypisać WL/BL do usera
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField("user1");
        configuration.selectNewUser();
        configuration.addBlackListOnUser("user1","BlackListaTest");
        configuration.clickSaveButton();
        dialog.confirmPopup();
        //widzi userów w użytkownicy i uprawnienia

        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.clickOnClearButton();
//        user.typeIntoSearchUserField("user1");
//        user.clickOnSearchButton();
        user.assertUser("user1");
//        user.typeIntoSearchUserField("RomanM");
//        user.clickOnSearchButton();
        user.assertUser("RomanM");


    }
}
