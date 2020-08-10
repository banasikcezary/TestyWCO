package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;

public class ImportCsv extends TestBase {


    @Test
    public void asUserTryImportCsvFile() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickOnButtonImportCsv();
        userList.clickOnButtonChooseFile();
        userList.clickOnButtonSendFileToApp();



    }

}
