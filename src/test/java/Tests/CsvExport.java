package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;

public class CsvExport extends TestBase {
    @Test
    public void asUserTryExportCsvFile() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.typeIntoSearchfield();
        userList.clickOnCheckboxUSR();
        userList.clickOnButtonExportToCsv();


    }
}
