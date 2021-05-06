package Tests;

import PageObject.*;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class VerificationPermissionAdminInterfaces extends TestBase{


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


        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickOnFunctionalitySettings();
        configuration.chooseSettingsArchivingCalls();
        configuration.setApiRest("adminRest","123123");

        configuration.clickSaveButton();


    }
}
