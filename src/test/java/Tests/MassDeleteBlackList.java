package Tests;

import PageObject.Dialog;
import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class MassDeleteBlackList extends TestBase {
    @Test(priority = 3,
            description = "as User Try Search User On The List",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryMassEditBlackList() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("Pio");
        loginPage.typeIntoPasswordField("Centralka123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.clickOnEditBlackList();
        userList.deleteBlackListMassChange("123123");
        userList.clickOnSaveBtn();

        Dialog dialog=new Dialog(driver);
        dialog.confirmPopup();


        userList.verifyDeleteMassBlackList("123123");


    }
}
