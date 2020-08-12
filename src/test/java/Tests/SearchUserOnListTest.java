package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class SearchUserOnListTest extends TestBase {


    @Test(priority = 2,
            retryAnalyzer = RetryAnalyzer.class)
    public void asUserTrySearchUserOnTheList() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.typeIntoSearchfield("adod2232");

        userList.checkIfTheUserYouAreLookingForExists("adod2232");
    }
}
