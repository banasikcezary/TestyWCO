package Tests;

import PageObject.ConnectionsSettingsPage;
import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

public class EditConnectionsSettingsTest extends TestBase {

    @Test(priority = 2,
            description = "as User Try Edit User Settings",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryEditUserSettings() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48617890766");
        loginPage.typeIntoUsernameField("u.user1");
        loginPage.typeIntoPasswordField("pass1");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        String nazwaUzytkownika="fana";
        userList.typeIntoSearchfield(nazwaUzytkownika);
        userList.checkIfTheUserYouAreLookingForExists(nazwaUzytkownika);
        userList.clickOnUser();

        ConnectionsSettingsPage connectionsSettingsPage = new ConnectionsSettingsPage(driver);
        connectionsSettingsPage.clickIntoEditButton();
        connectionsSettingsPage.clickIntoToAgreeRecordingVPABXConnections();
        connectionsSettingsPage.clickIntoToAgreeRecordingConnections();
        connectionsSettingsPage.clickIntoToAgreeDisableOutgoingCalls();
        connectionsSettingsPage.clickIntoToAgreeRecordingOutgoingCalls();

        connectionsSettingsPage.clickIntoSaveSettingsButton();
        connectionsSettingsPage.verifySaveSettings();



    }

}
