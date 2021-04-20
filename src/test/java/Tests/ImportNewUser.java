package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserList;
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
        loginPage.typeIntoPasswordField("Centradslka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.clickOnButtonImportNewUserCsv();
        userList.clickOnButtonChooseFile("src/test/java/resources/importNewUser.csv");
        userList.clickOnButtonSendFileToApp();
        Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();

        userList.validationValueFromNotActiveToActiveMassChange();
        userList.validationLoginAfterImportNewUserCsv();



    }
}
