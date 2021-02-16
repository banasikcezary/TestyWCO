package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class MassEditBlackList extends TestBase {
    @Test(priority = 2,
            description = "as User Try Search User On The List",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryMassEditBlackList() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.selectAllColumns();
        userList.clickOnEditBlackList();
        userList.addBlackListMassChange();
        userList.clickOnSaveBtn();





    }
}
