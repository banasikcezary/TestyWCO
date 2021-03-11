package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class SearchUserOnListTest extends TestBase {


    @Test(priority = 2,
            description = "as User Try Search User On The List",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTrySearchUserOnTheList() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48690408932");
        loginPage.typeIntoUsernameField("CRM2J2DF6ZZ");
        loginPage.typeIntoPasswordField("Orange123456!");
        loginPage.clickIntoLogInButton();
        loginPage.checkPositiveLoginToApp();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        String user="KarolN";
        userList.selectAllColumns();
        userList.typeIntoSearchfield(user);
        userList.checkIfTheUserYouAreLookingForExists(user);
    }
}
