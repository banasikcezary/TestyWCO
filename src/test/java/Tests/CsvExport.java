package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class CsvExport extends TestBase {


    @Test(priority = 2,
            retryAnalyzer = RetryAnalyzer.class)
    public void asUserTryExportCsvFile() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.typeIntoSearchfield("adod2232");
        userList.clickOnCheckboxUSR();
        userList.clickOnButtonExportToCsv();


    }
}
