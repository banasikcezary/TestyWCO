package Tests;

import PageObject.ConnectionsSettingsPage;
import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;

public class EditConnectionsSettingsTest extends TestBase{

    @Test(priority = 2)
    public void asUserTryEditUserSettings(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField( "u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.typeIntoSearchfield();
        userList.checkIfTheUserYouAreLookingForExists();

        userList.clickOnUser();



        ConnectionsSettingsPage connectionsSettingsPage = new ConnectionsSettingsPage(driver);
        connectionsSettingsPage.clickIntoEditButton();
        connectionsSettingsPage.clickIntoToAgreeRecordingVPABXConnections();
        connectionsSettingsPage.clickIntoToAgreeRecordingConnections();
        connectionsSettingsPage.clickIntoToAgreeDisableOutgoingCalls();
        connectionsSettingsPage.clickIntoToAgreeRecordingOutgoingCalls();
        connectionsSettingsPage.clickIntoSaveSettingsButton();

    }

}
