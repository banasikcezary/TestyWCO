package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;

public class SearchUserOnListTest extends TestBase{


    @Test
    public void asUserTrySearchUserOnTheList(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.typeIntoSearchfield();
        userList.checkIfTheUserYouAreLookingForExists();
    }
}
