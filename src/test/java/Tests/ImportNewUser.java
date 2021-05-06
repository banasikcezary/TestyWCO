package Tests;

import PageObject.*;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class ImportNewUser extends TestBase {


    @Test(priority = 2,
            description = "as User Try Import Csv File",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryImportCsvFile() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.buyNewUserFunctionalities();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.clickOnButtonImportNewUserCsv();
        userList.clickOnButtonChooseFile("src/test/java/resources/importNewUser.csv");
        userList.clickOnButtonSendFileToApp();
        Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();

        userList.validationValueWtzChange();

        userList.validationLoginInListUser("dsf",1);


        String deleteUser="user3";

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.typeIntoUserSearchField(deleteUser);
        configuration.selectNewUser();
        configuration.clickOnDeleteButton();
        dialog.clickOnConfirmButton();
        dialog.clickOnAcceptPopupButton();
UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.typeIntoSearchUserField(deleteUser);
        user.clickOnSearchButton();

        user.assertDeleteUser(deleteUser);



    }
}
