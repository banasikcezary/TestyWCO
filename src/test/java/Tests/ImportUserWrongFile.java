package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class ImportUserWrongFile extends TestBase {


    @Test(priority = 2,
            description = "as User Try Import Csv File",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryImportCsvFile() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408934");
        loginPage.typeIntoUsernameField("CRMOG8WX6VV");
        loginPage.typeIntoPasswordField("Wcopassword1!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.clickOnButtonImportCsv();
        userList.clickOnButtonChooseFile("src/test/java/resources/errorImport.csv");
        userList.clickOnButtonSendFileToApp();
        Dialog dialog=new Dialog(driver);
        dialog.confirmPopupWrongInfo("Aktualizacja zakończyła się niepowodzeniem wystąpił problem z odczytaniem pliku, niepoprawna struktura pliku");




    }
}
