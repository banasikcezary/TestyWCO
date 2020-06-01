package Tests;

import PageObject.ConnectionsSettingsPage;
import PageObject.LoginPage;
import PageObject.UserList;
import org.testng.annotations.Test;

public class EditConnectionsSettingsTest extends TestBase{

    @Test
    public void asUserTryEditUserSettings(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField();
        loginPage.typeIntoUsernameField();
        loginPage.typeIntoPasswordField();
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.typeIntoSearchfield();
        userList.checkIfTheUserYouAreLookingForExists();
        userList.clickOnUser();


        try{

                Thread.sleep(7000);
            }

        catch(InterruptedException e){
        }

        ConnectionsSettingsPage connectionsSettingsPage = new ConnectionsSettingsPage(driver);
        connectionsSettingsPage.clickIntoEditButton();
        connectionsSettingsPage.clickIntoToAgreeRecordingVPABXConnections();
        connectionsSettingsPage.clickIntoToAgreeRecordingConnections();
        connectionsSettingsPage.clickIntoToAgreeDisableOutgoingCalls();
        connectionsSettingsPage.clickIntoToAgreeRecordingOutgoingCalls();
        connectionsSettingsPage.clickIntoSaveSettingsButton();

    }

}
