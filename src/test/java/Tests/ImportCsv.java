package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class ImportCsv extends TestBase {


    @Test(priority = 2,
            description = "as User Try Import Csv File",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryImportCsvFile() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickOnButtonImportCsv();
        userList.clickOnButtonChooseFile("src/test/java/resources/1.csv");
        userList.clickOnButtonSendFileToApp();


    }

}
