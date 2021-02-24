package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.net.idn.StringPrep;

import java.awt.*;
import java.util.List;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertTrue;


public class Configuration {

    @FindBy(id = "configuration_component_link")
    WebElement lnkConfiguration;
    @FindBy(xpath = "//*[contains(@id,'mat-expansion-panel-header-')][1]")
    WebElement lnkUserList;
    @FindBy(xpath = "//*[contains(@id,'_list_element')][last()]")
    WebElement lastUserButton;
    @FindBy(id = "enable_gui_application_access_checkbox")
    WebElement chkShowInGui;
    @FindBy(id = "save_button")
    WebElement btnSave;

    @FindBy(id = "login_input")
    WebElement loginInput;
    @FindBy(id = "firstName_input")
    WebElement firstNameInput;
    @FindBy(id = "lastName_input")
    WebElement lastNameInput;
    @FindBy(id = "number_input")
    WebElement numberInput;
    @FindBy(id = "email_input")
    WebElement emailInput;
    @FindBy(xpath = "(//mat-dialog-container[contains(@id,\"mat-dialog\")])")
    WebElement confirmText;

    @FindBy(id = "filter_value_input")
    WebElement userSearchField;
    @FindBy(id = "delete_button")
    WebElement deleteButton;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "(//*[contains(@id,'mat-expansion-panel-header-')])[2]")
    WebElement lnkFunctionalitySettings;
    @FindBy(id = "Komunikat spersonalizowany_list_config_element")
    WebElement lnkPersonalizedMessage;

    @FindBy(id = "Czarna lista_list_config_element")
    WebElement lnkBlackList;
    @FindBy(xpath = "(//*[contains(@class,'mat-list-item mat-list-option blacklist-not-selected mat-accent ng-star-inserted')])[last()]")
    WebElement lnkBlackListLast;
    @FindBy(id = "(//*[contains(@class,'mat-list-item mat-list-option blacklist-not-selected mat-accent ng-star-inserted')])[last()]")
    private List<WebElement> elementList;
    @FindBy(id = "name_input")
    WebElement inputNameBlackList;
    @FindBy(id = "description_textarea")
    WebElement inputDescBlackList;
    @FindBy(xpath = "(//*[contains(@class,\"mat-checkbox-layout\")])[last()]")
    WebElement checkboxGlobalBlackList;
    @FindBy(xpath = "(//*[contains(@id,\"mat-expansion-panel-header-\")])[4]")
    WebElement lnkNumberBlackList;
    @FindBy(id = "add_number_input")
    WebElement inputAddNumberBlackList;
    @FindBy(id = "add_button")
    WebElement btnAddNumberBlackList;
    @FindBy(id = "save_button")
    WebElement btnSaveBlackList;
    @FindBy(id = "remove_blacklist_button")
    WebElement btnDeleteBlackList;
    @FindBy(xpath = "(//*[contains(@id,\"mat-expansion-panel-header-\")])[3]")
    WebElement lnkActivationBlackList;
    @FindBy(xpath = "(//*[contains(@class,\"mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin\")])[last()]")
    WebElement checkboxActivateLastBlackList;
    @FindBy(xpath = "(//*[contains(@class,\"mat-checkbox mat-accent mat-checkbox-checked\")])[last()]")
    WebElement validateActivationBlackListChecked;
    @FindBy(css = "#keygeneration_type>mat-radio-button:nth-of-type(1)")
    WebElement validatechooseInterlanKeyWck;
    @FindBy(css = "#keygeneration_type>mat-radio-button:nth-of-type(2)")
    WebElement validatechoosePublicKey;
    @FindBy(css = "div.col-md-9>mat-radio-button[class*=mat-radio-checked]")
    WebElement validationRecAll;
    @FindBy(css = "div.col-md-12>mat-radio-button:nth-of-type(1)")
    WebElement validationRecRandom;
    @FindBy(xpath = "(//*[contains(@class,\"mat-checkbox mat-accent ng-valid mat-checkbox-checked ng-dirty ng-touched\")])[last()]")
    WebElement validateGlobalBlackList;
    @FindBy(xpath = "(//*[contains(@class,\"mat-checkbox mat-accent ng-valid mat-checkbox-checked ng-dirty ng-touched\")])[last()]")
    WebElement validateGlobalWhiteList;


    @FindBy(id = "Biała lista_list_config_element")
    WebElement lnkWhiteList;
    @FindBy(xpath = "(//*[contains(@class,'mat-list-item mat-list-option whitelist-not-selected mat-accent ng-star-inserted')])[last()]")
    WebElement lnkWhiteListLast;
    @FindBy(id = "name_input")
    WebElement inputNameWhiteList;
    @FindBy(id = "description_textarea")
    WebElement inputDescWhiteList;
    @FindBy(xpath = "(//*[contains(@class,\"mat-checkbox-layout\")])[last()]")
    WebElement checkboxGlobalWhiteList;
    @FindBy(xpath = "(//*[contains(@id,\"mat-expansion-panel-header-\")])[4]")
    WebElement lnkNumberWhiteList;
    @FindBy(id = "add_number_input")
    WebElement inputAddNumberBlackWhiteList;
    @FindBy(id = "add_button")
    WebElement btnAddNumberWhiteList;
    @FindBy(id = "save_button")
    WebElement btnSaveWhiteList;
    @FindBy(id = "remove_whitelist_button")
    WebElement btnDeleteWhiteList;
    @FindBy(xpath = "(//*[contains(@id,\"mat-expansion-panel-header-\")])[3]")
    WebElement lnkActivationWhiteList;
    @FindBy(xpath = "(//*[contains(@class,\"mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin\")])[last()]")
    WebElement checkboxActivateLastWhiteList;
    @FindBy(id = "search_button")
    WebElement btnSearch;


//    @FindBy(id = "IVR/VIP lista (Nagrywarka)_list_config_element")
//    WebElement lnkVipList;
//    @FindBy(id = "Nagrywanie połączeń (Nagrywarka)_list_config_element")
//    WebElement lnkCallRec;
//    @FindBy(id = "Archiwizacja połączeń_list_config_element")
//    WebElement lnkCallArchiving;
    ///////////////////////////////////////////////
    //Kliucz wewnetrzny

    @FindBy(css = "#keygeneration_type>mat-radio-button:nth-of-type(1)>label")
    WebElement rbtInternalKey;
    @FindBy(css = "#encryptionKeyTypeId_type>mat-radio-button:nth-of-type(2)>label")
    WebElement rbtTypeKey;
    @FindBy(css = "#aesModeEnum_type>mat-radio-button:nth-of-type(2)>label")
    WebElement rbtAesType;
    @FindBy(css = "#regenerate_key_checkbox>label")
    WebElement cbxRegenerateKey;
    @FindBy(css = "[type='password']")
    WebElement txtPasswordKey;

    ////// Klucz publiczny//////////////
    @FindBy(css = "#keygeneration_type>mat-radio-button:nth-of-type(2)>label")
    WebElement rbtPublicKey;
    @FindBy(css = "#import_public_key_checkbox>label")
    WebElement cbxUploadPublicKey;
    @FindBy(css = "[formcontrolname='publicKey']")
    WebElement txtPublicKey;
    @FindBy(css = "div.list-expansion-panel>mat-action-list>button:nth-of-type(3)")
    WebElement btnSettingsRec;
    ///////////////////////////Nagrywaj wszystko//////////////////
    @FindBy(css = "div.col-md-9>mat-radio-button>label")
    WebElement rbtRecAll;
    //////////////////////////////////Nagrywaj Losowo/////////////
    @FindBy(css = "div.col-md-12>mat-radio-button:nth-of-type(1)>label")
    WebElement rbtRecRandom;
    @FindBy(id = "probability_input")
    WebElement txtProbability;
    /////////////////////////////Cyklicznie///////////////////////
    @FindBy(css = "div.col-md-12>mat-radio-group[formcontrolname=\"algorithmTypeId\"]>div:nth-of-type(5)>div>mat-radio-button>label")
    WebElement rbtRecCyclic;
    @FindBy(id = "step_input")
    WebElement txtCyclicValue;
    @FindBy(css = "div.col-md-12>mat-radio-group[formcontrolname=\"algorithmTypeId\"]>div:nth-of-type(5)>div>mat-radio-button")
    WebElement validationRecCyclic;
    //////////////////////////////////////Godzinowo
    @FindBy(css = "div.col-md-12>mat-radio-group[formcontrolname=\"algorithmTypeId\"]>div:nth-of-type(7)>div>mat-radio-button>label")
    WebElement rbtRecHour;
    @FindBy(id = "timeFrom")
    WebElement txtFromHour;
    @FindBy(id = "timeTo")
    WebElement txtToHour;
    @FindBy(css = "div.col-md-12>mat-radio-group[formcontrolname=\"algorithmTypeId\"]>div:nth-of-type(7)>div>mat-radio-button")
    WebElement validationRecHour;
    @FindBy(css = "[formcontrolname=\"algorithmTypeId\"]>mat-radio-button>label")
    WebElement rbtRecNothing;
    @FindBy(css = "[formcontrolname=\"algorithmTypeId\"]>mat-radio-button")
    WebElement validationRecNothing;
    ///////////////////////////////////Wyczerpany Pakiet
    @FindBy(css = "[formcontrolname=\"eraseArchivizationPackageTypeId\"]>mat-radio-button:nth-of-type(1)>label")
    WebElement lockRecAndCalls;
    @FindBy(css = "[formcontrolname=\"eraseArchivizationPackageTypeId\"]>mat-radio-button:nth-of-type(1)>label")
    WebElement validationRecAndCalls;
    @FindBy(css = "[formcontrolname=\"eraseArchivizationPackageTypeId\"]>mat-radio-button:nth-of-type(2)>label")
    WebElement deletingRecordingsWithoutBlockingCalls;
    @FindBy(css = "[formcontrolname=\"eraseArchivizationPackageTypeId\"]>mat-radio-button:nth-of-type(2)>label")
    WebElement validationDeletingRecordingsWithoutBlockingCalls;
    @FindBy(css = "[formcontrolname=\"eraseArchivizationPackageTypeId\"]>mat-radio-button:nth-of-type(3)>label")
    WebElement stopRecordingButAndPossibilityMakeCalls;
    @FindBy(css = "[formcontrolname=\"eraseArchivizationPackageTypeId\"]>mat-radio-button:nth-of-type(3)>label")
    WebElement validationStopRecordingButAndPossibilityMakeCalls;

    ///////////////////////////// wybierz plik mp3 i Wav /////////////////////
    @FindBy(id = "format_dropDown")
    WebElement dpdSelectFormat;
    @FindBy(css = "div[class*='mat-select-panel mat-primary']>mat-option:nth-of-type(1)")
    WebElement lnkFormatWav;
    @FindBy(css = "div[class*='mat-select-panel mat-primary']>mat-option:nth-of-type(2)")
    WebElement lnkFormatMp3;
    /////////////////////////// Vip Lista /////////////////////////////
    @FindBy(css = "div.list-expansion-panel>mat-action-list>button:nth-of-type(4)")
    WebElement settingVipList;
    @FindBy(id = "add_number_input")
    WebElement txtNumberVipList;
    @FindBy(id = "add_button")
    WebElement btnAddNumberVipList;
    @FindBy(css = "mat-selection-list#vip_ivr_selection_list>mat-list-option:last-of-type")
    WebElement selectLastNumber;
    @FindBy(css = "mat-checkbox[formcontrolname=\"doRecord\"]")
    WebElement btnDoRecord;
    @FindBy(css = "mat-checkbox[formcontrolname=\"doAnnouncement\"]")
    WebElement btnDoAnnouncement;
    @FindBy(css = "mat-checkbox[formcontrolname=\"doInternalAnnouncement\"]")
    WebElement btnAnnoucementIvr;
    @FindBy(css = "[class='container edit-field-style']>mat-accordion>mat-expansion-panel>mat-expansion-panel-header")
    WebElement lnkAnnouncement;
    @FindBy(css = "mat-radio-button[value=\"TTS\"]")
    WebElement chooseTtsOption;
    @FindBy(id = "announcementTextPolish")
    WebElement txtAnnouncementPolish;
    ////////////////////////////Archiwizacja////////////////
    @FindBy(css = "div.list-expansion-panel>mat-action-list>button:nth-of-type(6)")
    WebElement lnkCallArchiving;
    @FindBy(css = "#config_sftp_connection_checkbox")
    WebElement cbxSftpOption;
    @FindBy(id = "hostAddress_input")
    WebElement txtHostAddress;
    @FindBy(id = "hostPort_input")
    WebElement txtHostPort;
    @FindBy(id = "username_input")
    WebElement txtUser;
    @FindBy(id = "sftpInputNewPassword_checkbox")
    WebElement cbxSelectNewPassword;
    @FindBy(id = "password_input")
    WebElement txtPassword;
    @FindBy(id = "propagationTimeFrom")
    WebElement txtPropagationTimeFrom;
    @FindBy(id = "propagationTimeTo")
    WebElement txtPropagationTimeTo;
    @FindBy(id = "hostPublicKey_textarea")
    WebElement txtHostPublicKey;
    /////////////////////////////////Api rest/soap ///////////////////////////////
    @FindBy(css = "label[for=config_api_connection_checkbox-input]")
    WebElement cbxApiConnection;
    @FindBy(xpath = "(//*[contains(@id,\"mat-radio-\")])[1]")
    WebElement rbtApiSoap;
    @FindBy(id = "username_input_soap_api")
    WebElement txtUserSoap;
    @FindBy(css = "[for=\"apiInputNewPassword_checkbox-input\"]")
    WebElement cbxSoapPassword;
    @FindBy(id = "password_api_input")
    WebElement txtPasswordApi;
    @FindBy(id = "hostPublicKey_API_textarea")
    WebElement txtHostPublicKeyApi;

    @FindBy(xpath = "(//*[contains(@id,\"mat-radio-\")])[3]")
    WebElement rbtApiRest;
    @FindBy(id = "username_input_rest_api")
    WebElement txtUserRest;
    @FindBy(css = "[for=\"recPackagingApiform_checkbox-input\"]")
    WebElement cbxRestPassword;
    @FindBy(id = "password_recPackagingApiform_input")
    WebElement txtPasswordRest;

    //////////////////////////////////////// tagi
    @FindBy(css = "div.list-expansion-panel>mat-action-list>button:nth-of-type(7)")
    WebElement lnkTag;
    @FindBy(id = "add_tag_input")
    WebElement txtTag;
    @FindBy(id = "add_tag_button")
    WebElement btnAddTag;
    @FindBy(css = "#tag_dictionary_list>mat-list-option:last-of-type")
    WebElement lastValueTag;
    @FindBy(id = "save_tags_button")
    WebElement btnSaveTag;
    @FindBy(id = "delete_tags_button")
    WebElement btnDeleteTag;

    ///////////////////////// Ustawienia globalne


    @FindBy(id = "enable_rodo_checkbox")
    WebElement cbxRodo;
    @FindBy(id = "enable_single_recording_checkbox")
    WebElement cbxSingleRec;
    @FindBy(id = "reportAutoDeleteDisable")
    WebElement cbxAutoDeleteReport;
    @FindBy(id = "enable__checkbox")
    WebElement cbxLoggWithCert;
    /////////////////////////////////////checkboxy usera //////////////////////////////
    @FindBy(id = "directly_incoming_checkbox")
    WebElement cbxOppb;
    @FindBy(css = "[formcontrolname=\"canTransfer\"]")
    WebElement cbxCanTransfer;
    @FindBy(css = "[formcontrolname=\"recordingDirectlyIncomingCalls\"]")
    WebElement cbxRecordingDirectlyIncomingCalls;
    @FindBy(css = "[formcontrolname=\"recordingOutgoingCalls\"]")
    WebElement cbxRecordingOutgoingCalls;
    @FindBy(css = "[formcontrolname=\"personalizedAnnouncementEnabled\"]")
    WebElement cbxPersonalizedAnnouncement;
    @FindBy(css = "[formcontrolname=\"apiAccess\"]")
    WebElement cbxApiAccess;
    @FindBy(id = "enable_gui_application_access_checkbox")
    WebElement cbxGuiAccess;
    @FindBy(id = "can_tag_enabled")
    WebElement cbxTagEnabled;

    @FindBy(xpath = "(//*[contains(@id,\"mat-expansion-panel-header\")])[3]")
    WebElement lnkOneTimeOffRecording;
    @FindBy(id = "enable_can_switch_off_recording_outgoing_calls")
    WebElement cbxOneTimeOffRecording;
    @FindBy(id = "save_user_can_switch_off_recording_outgoing_calls_button")
    WebElement btnSaveOneTimeOffRecording;

    @FindBy(xpath = "(//*[contains(@id,\"mat-expansion-panel-header\")])[4]")
    WebElement lnkPasswordKeyForUser;
    @FindBy(id = "passwordForUserPrivateKey")
    WebElement txtPasswordKeyForUser;
    @FindBy(id = "save_user_password_button")
    WebElement btnSavePasswordKeyForUser;

    @FindBy(xpath = "(//*[contains(@id,\"mat-expansion-panel-header\")])[5]")
    WebElement lnkBlackListUser;
    @FindBy(id = "select_blacklist")
    WebElement selectBlackListUser;
    @FindBy(css = "mat-option:last-of-type")
    WebElement chooseLastBlackList;
    @FindBy(id = "add_blacklist_button")
    WebElement btnAddUserBlackList;
    @FindBy(id = "delete_blacklist_button")
    WebElement btnDeleteUserBlackList;
    @FindBy(css = "mat-list-option:last-of-type")
    private List<WebElement> chooseLastBlackListUserWithList;

    @FindBy(xpath = "(//*[contains(@id,\"mat-expansion-panel-header\")])[6]")
    WebElement lnkWhiteListUser;
    @FindBy(id = "select_whitelist")
    WebElement selectWhiteListUser;
    @FindBy(css = "mat-option:last-of-type")
    WebElement chooseLastWhiteList;
    @FindBy(id = "add_whitelist_button")
    WebElement btnAddUserWhiteList;
    @FindBy(id = "delete_whitelist_button")
    WebElement btnDeleteUserWhiteList;
    @FindBy(css = "mat-list-option:last-of-type")
    private List<WebElement> chooseLastWhiteListUserWithList;











    private WebDriver driver;

    public Configuration(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickConfigurationLink")
    public void clickConfigurationLink() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkConfiguration));
        Actions actions = new Actions(driver);
        actions.moveToElement(lnkConfiguration).click().perform();
    }

    @Step("clickLinkUserList")
    public void clickLinkUserList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkUserList));
        lnkUserList.click();
    }

    @Step("typeIntoTxtLoginField")
    public void selectNewUser() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lastUserButton));
        lastUserButton.click();

    }

    @Step("clickInCheckboxShowInGui")
    public void clickInCheckboxShowInGui() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chkShowInGui));
        chkShowInGui.click();
    }

//    @Step("clickInCheckboxShowInGui")
//    public void clickSaveButton() throws AWTException {
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSave));
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSave);
//
//        //  btnSave.click();
//
//        webDriverWait.until(ExpectedConditions.visibilityOf(confirmText));
//        confirmText.isDisplayed();
//
//        driver.findElement(By.xpath("//html")).click();
//        driver.findElement(By.xpath("//html")).click();
//
//
//        //   assertEquals(confirmText.getText(), "Konfiguracja zostala zaaktualizowana");
//    }

    @Step("typeIntoLoginField")
    public void typeIntoLoginField(String login) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    @Step("typeIntoFirstNameField")
    public void typeIntoFirstNameField(String firstName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    @Step("typeIntoLastNameInputField")
    public void typeIntoLastNameInputField(String lastName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    @Step("typeIntoLastNameInputField")
    public void typeIntoNumberInputField(String number) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        numberInput.sendKeys(number);
    }

    @Step("typeIntoEmailInputField")
    public void typeIntoEmailInputField(String email) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void typeIntoUserSearchField(String userName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(userSearchField));
        userSearchField.sendKeys(userName);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userSearchField));
        btnSearch.click();
    }

    public void clickOnDeleteButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }


    public void clickOnFunctionalitySettings() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkFunctionalitySettings));
        lnkFunctionalitySettings.click();
    }

    ////////////////////////////////////// BLACK LIST /////////////////////

    public void clickOnBlackListFunctionality() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkBlackList));
        lnkBlackList.click();
    }

    public void clickOnLastBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkBlackListLast));
        lnkBlackListLast.click();
    }

    public void completeNameAndDescription(String nameBlackList, String descBlackList) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputNameBlackList));
        inputNameBlackList.clear();
        inputNameBlackList.sendKeys(nameBlackList);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputDescBlackList));
        inputDescBlackList.clear();
        inputDescBlackList.sendKeys(descBlackList);
    }

    public void verifyDeleteBlackList() {


        driver.findElement(By.xpath("//html")).click();

        driver.navigate().refresh();
        clickConfigurationLink();
        clickOnFunctionalitySettings();
        clickOnBlackListFunctionality();

        if (!elementList.isEmpty()) {
            assertNotEquals(lnkBlackListLast.getText(), "BlackListaTest");
        }
    }

    public void verifyDeleteWhiteList() {

        driver.findElement(By.xpath("//html")).click();

        driver.navigate().refresh();
        clickConfigurationLink();
        clickOnFunctionalitySettings();
        clickOnWhiteListFunctionality();

        if (!elementList.isEmpty()) {
            assertNotEquals(lnkBlackListLast.getText(), "WhiteListaTest");
        }

    }


    public void clickOnGlobalBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxGlobalBlackList));
        checkboxGlobalBlackList.click();
    }

    public void addNumberForBlackList(String number) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkNumberBlackList));
        lnkNumberBlackList.click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputAddNumberBlackList));
        inputAddNumberBlackList.clear();
        inputAddNumberBlackList.sendKeys(number);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddNumberBlackList));
        btnAddNumberBlackList.click();
    }

    public void clickOnButtonSaveBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSaveBlackList));
        btnSaveBlackList.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(confirmText));
        confirmText.isDisplayed();
        driver.findElement(By.xpath("//html")).click();
    }

    public void verifySaveBlackList() {
        driver.navigate().refresh();
        clickConfigurationLink();
        clickOnFunctionalitySettings();
        clickOnBlackListFunctionality();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkBlackListLast));

        assertEquals(lnkBlackListLast.getText(), "BlackListaTest");

    }

    public void verifySaveWhiteList() {

        driver.navigate().refresh();
        clickConfigurationLink();
        clickOnFunctionalitySettings();
        clickOnWhiteListFunctionality();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkWhiteListLast));
        assertEquals(lnkWhiteListLast.getText(), "WhiteListaTest");

    }

    public void verifyActivateGlobalBlacklist() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validateGlobalBlackList));
        String classAtr = validateGlobalBlackList.getAttribute("class");
        assertTrue(classAtr.contains("mat-checkbox-checked"));

    }

    public void clickOnButtonDeleteBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteBlackList));
        btnDeleteBlackList.click();


    }

    public void clickOnLinkActivationBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkActivationBlackList));
        Actions actions = new Actions(driver);
        actions.moveToElement(lnkActivationBlackList).click().build().perform();
    }

    public void clickOnActivationLastBlackList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxActivateLastBlackList));
        checkboxActivateLastBlackList.click();
    }

    public void verifyActivateBlacklist() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validateActivationBlackListChecked));
        String classAtr = validateActivationBlackListChecked.getAttribute("class");

        assertTrue(classAtr.contains("mat-checkbox-checked"));


    }

    public void verifyActivateWhitelist() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validateActivationBlackListChecked));
        String classAtr = validateActivationBlackListChecked.getAttribute("class");

        assertTrue(classAtr.contains("mat-checkbox-checked"));
    }


////////////////////////////////////////// WHITE LIST /////////////////////////////////


    public void clickOnWhiteListFunctionality() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkWhiteList));
        lnkWhiteList.click();
    }

    public void clickOnLastWhiteList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkWhiteListLast));
        lnkWhiteListLast.click();
    }

    public void completeNameAndDescriptionWhiteList(String nameBlackList, String descBlackList) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputNameWhiteList));
        inputNameWhiteList.clear();
        inputNameWhiteList.sendKeys(nameBlackList);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputDescWhiteList));
        inputDescWhiteList.clear();
        inputDescWhiteList.sendKeys(descBlackList);
    }

    public void clickOnGlobalWhiteList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxGlobalWhiteList));
        checkboxGlobalWhiteList.click();
    }

    public void addNumberForWhiteList(String number) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkNumberWhiteList));
        lnkNumberWhiteList.click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputAddNumberBlackWhiteList));
        inputAddNumberBlackWhiteList.clear();

        inputAddNumberBlackWhiteList.sendKeys(number);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddNumberWhiteList));
        btnAddNumberWhiteList.click();
    }

    public void clickOnButtonSaveWhiteList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSaveWhiteList));
        btnSaveWhiteList.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(confirmText));
        confirmText.isDisplayed();
        driver.findElement(By.xpath("//html")).click();
    }

    public void verifyActivateGlobalWhitelist() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validateGlobalWhiteList));
        String classAtr = validateGlobalWhiteList.getAttribute("class");
        assertTrue(classAtr.contains("mat-checkbox-checked"));
    }

    public void clickOnButtonDeleteWhiteList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteWhiteList));
        btnDeleteWhiteList.click();
    }

    public void clickOnLinkActivationWhiteList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkActivationWhiteList));
        lnkActivationWhiteList.click();
    }

    public void clickOnActivationLastWhiteList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxActivateLastWhiteList));
        checkboxActivateLastWhiteList.click();
    }

    public void clickOnInternalKey() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtInternalKey));
        rbtInternalKey.click();
        rbtInternalKey.click();
    }

    public void chooseTypeKey() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtTypeKey));
        rbtTypeKey.click();
    }

    public void chooseTypeAesKey() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtAesType));
        rbtAesType.click();
    }

    public void clickOnCheckboxRegenerateKey() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxRegenerateKey));
        cbxRegenerateKey.click();
    }

    public void typePasswordKey(String password) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtPasswordKey));
        txtPasswordKey.clear();
        txtPasswordKey.sendKeys(password);
    }

    public void verifyGenerateInterlanKey() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validatechooseInterlanKeyWck));
        String classAtr = validatechooseInterlanKeyWck.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void verifyRecAllOption() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationRecAll));
        String classAtr = validationRecAll.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void verifyRecRandomOption() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationRecRandom));
        String classAtr = validationRecRandom.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void verifyRecNothingOption() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationRecNothing));
        String classAtr = validationRecNothing.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void verifyRecCyclicOption() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationRecCyclic));
        String classAtr = validationRecCyclic.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void verifyRecHourOption() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationRecHour));
        String classAtr = validationRecHour.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void verifyGeneratePubliccKey() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validatechoosePublicKey));
        String classAtr = validatechoosePublicKey.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void choosePublicKey() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtPublicKey));
        rbtPublicKey.click();
        rbtPublicKey.click();
    }

    public void clickOnCheckboxPublicKey() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxUploadPublicKey));
        cbxUploadPublicKey.click();
    }

    public void typePublicKey(String key) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtPublicKey));
        txtPublicKey.clear();
        txtPublicKey.sendKeys(key);
    }

    public void clickOnSettingsRec() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSettingsRec));
        btnSettingsRec.click();
    }

    public void clickSaveButton() throws AWTException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSave));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSave);

    }

    public void clickOnRecAllButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtRecAll));
        rbtRecAll.click();
    }

    public void setSettingsRecRandom(String value) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtRecRandom));
        rbtRecRandom.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(txtProbability));
        txtProbability.clear();
        txtProbability.sendKeys(value);
    }

    public void setSettingsRecCyclic(String value) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtRecCyclic));
        rbtRecCyclic.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(txtCyclicValue));
        txtCyclicValue.clear();
        txtCyclicValue.sendKeys(value);
    }

    public void setSettingsRecperHour(String value1, String value2) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtRecHour));
        rbtRecHour.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(txtFromHour));
        txtFromHour.clear();
        txtFromHour.sendKeys(value1);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtToHour));
        txtToHour.clear();
        txtToHour.sendKeys(value2);
    }

    public void clickOnRecNothingButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtRecNothing));
        rbtRecNothing.click();
    }


    public void clickOnLockRecAndCallsButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lockRecAndCalls));
        lockRecAndCalls.click();
    }

    public void verifyLockRecAndCallsOption() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationRecAndCalls));
        String classAtr = validationRecAndCalls.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void clickOnDeletingRecordingsWithoutBlockingCallsButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deletingRecordingsWithoutBlockingCalls));
        deletingRecordingsWithoutBlockingCalls.click();
    }

    public void verifyDeletingRecordingsWithoutBlockingCallsOption() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationDeletingRecordingsWithoutBlockingCalls));
        String classAtr = validationDeletingRecordingsWithoutBlockingCalls.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void clickOnStopRecordingWithPossibilityMakeCallsButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(stopRecordingButAndPossibilityMakeCalls));
        stopRecordingButAndPossibilityMakeCalls.click();
    }

    public void verifyStopRecordingWithPossibilityMakeCallsOption() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(validationStopRecordingButAndPossibilityMakeCalls));
        String classAtr = validationStopRecordingButAndPossibilityMakeCalls.getAttribute("class");

        assertTrue(classAtr.contains("mat-radio-checked"));
    }

    public void verifyChooseMp3Option() {
       clickOnFunctionalitySettings();
       clickOnSettingsRec();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(dpdSelectFormat));
        dpdSelectFormat.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(lnkFormatMp3));
        String classAtr = lnkFormatMp3.getAttribute("class");

        assertTrue(classAtr.contains("mat-active"));
    }

    public void verifyChooseWavOption() {
        clickOnFunctionalitySettings();
        clickOnSettingsRec();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(dpdSelectFormat));
        dpdSelectFormat.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(lnkFormatWav));
        String classAtr = lnkFormatWav.getAttribute("class");

        assertTrue(classAtr.contains("mat-active"));
    }

    public void selectMp3Option() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(dpdSelectFormat));
        dpdSelectFormat.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkFormatMp3));
        lnkFormatMp3.click();
    }

    public void selectWavOption() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(dpdSelectFormat));
        dpdSelectFormat.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkFormatWav));
        lnkFormatWav.click();
    }

    public void chooseSettingsVipList() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(settingVipList));
        settingVipList.click();
    }

    public void addNumberToVipList(String number) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtNumberVipList));
        txtNumberVipList.sendKeys(number);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddNumberVipList));
        btnAddNumberVipList.click();
    }


    public void setOnlyRecording() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectLastNumber));
        Actions actions = new Actions(driver);
        actions.moveToElement(selectLastNumber).click().build().perform();

        webDriverWait.until(ExpectedConditions.visibilityOf(btnDoAnnouncement));
        btnDoAnnouncement.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(btnDoRecord));
        String classAtr1 = btnDoRecord.getAttribute("class");
        assertTrue(classAtr1.contains("mat-checkbox-checked"));
        webDriverWait.until(ExpectedConditions.visibilityOf(btnDoAnnouncement));
        String classAtr = btnDoAnnouncement.getAttribute("class");
        assertFalse(classAtr.contains("mat-checkbox-checked"));

    }

    public void setRecordingAndAnnouncement() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectLastNumber));
        Actions actions = new Actions(driver);
        actions.moveToElement(selectLastNumber).click().build().perform();


        webDriverWait.until(ExpectedConditions.visibilityOf(btnDoRecord));
        String classAtr1 = btnDoRecord.getAttribute("class");
        assertTrue(classAtr1.contains("mat-checkbox-checked"));
        webDriverWait.until(ExpectedConditions.visibilityOf(btnDoAnnouncement));
        String classAtr = btnDoAnnouncement.getAttribute("class");
        assertTrue(classAtr.contains("mat-checkbox-checked"));
    }

    public void setRecordingAndAnnouncementIvr() {
        driver.navigate().refresh();
        clickConfigurationLink();
        clickOnFunctionalitySettings();
        clickOnSettingsRec();
        chooseSettingsVipList();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectLastNumber));
        Actions actions = new Actions(driver);
        actions.moveToElement(selectLastNumber).click().build().perform();


        webDriverWait.until(ExpectedConditions.visibilityOf(btnAnnoucementIvr));
        btnAnnoucementIvr.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(btnDoRecord));
        String classAtr1 = btnDoRecord.getAttribute("class");
        assertTrue(classAtr1.contains("mat-checkbox-checked"));
        webDriverWait.until(ExpectedConditions.visibilityOf(btnDoAnnouncement));
        String classAtr = btnDoAnnouncement.getAttribute("class");
        assertTrue(classAtr.contains("mat-checkbox-checked"));

        webDriverWait.until(ExpectedConditions.visibilityOf(btnAnnoucementIvr));
        String classAtr2 = btnAnnoucementIvr.getAttribute("class");
        assertTrue(classAtr2.contains("mat-checkbox-checked"));

        webDriverWait.until(ExpectedConditions.visibilityOf(lnkAnnouncement));
        lnkAnnouncement.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(chooseTtsOption));
        chooseTtsOption.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(txtAnnouncementPolish));
        txtAnnouncementPolish.clear();
        txtAnnouncementPolish.sendKeys("Testowy Tekst");

    }

    public void chooseSettingsArchivingCalls() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkCallArchiving));
        Actions actions = new Actions(driver);
        actions.moveToElement(lnkCallArchiving).click().build().perform();


    }

    public void addSettingsSftp(String hostAddres, String hostPort, String user, String pass, String propagationTimeFrom, String propagationTimeTo, String publicKey) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxSftpOption));
        Actions actions = new Actions(driver);
        actions.moveToElement(cbxSftpOption).click().build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(txtHostAddress));
        txtHostAddress.clear();
        txtHostAddress.sendKeys(hostAddres);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtHostPort));
        txtHostPort.clear();
        txtHostPort.sendKeys(hostPort);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtUser));
        txtUser.clear();
        txtUser.sendKeys(user);

        webDriverWait.until(ExpectedConditions.visibilityOf(cbxSelectNewPassword));
        cbxSelectNewPassword.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.clear();
        txtPassword.sendKeys(pass);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtPropagationTimeFrom));
        txtPropagationTimeFrom.clear();
        txtPropagationTimeFrom.sendKeys(propagationTimeFrom);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtPropagationTimeTo));
        txtPropagationTimeTo.clear();
        txtPropagationTimeTo.sendKeys(propagationTimeTo);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtHostPublicKey));
        txtHostPublicKey.clear();
        txtHostPublicKey.sendKeys(publicKey);

    }

    public void verifySettingsSftp(String hostAddres, String hostPort, String user, String propagationTimeFrom, String propagationTimeTo, String publicKey) {
        driver.navigate().refresh();
        clickOnFunctionalitySettings();
        chooseSettingsArchivingCalls();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtHostAddress));
        String txt1 = txtHostAddress.getAttribute("value");
        assertEquals(txt1, hostAddres);


        webDriverWait.until(ExpectedConditions.visibilityOf(txtHostPort));
        String txt2 = txtHostPort.getAttribute("value");
        assertEquals(txt2, hostPort);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtUser));
        String txt3 = txtUser.getAttribute("value");
        assertEquals(txt3, user);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtPropagationTimeFrom));
        String txt4 = txtPropagationTimeFrom.getAttribute("value");
        assertEquals(txt4, propagationTimeFrom);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtPropagationTimeTo));
        String txt5 = txtPropagationTimeTo.getAttribute("value");
        assertEquals(txt5, propagationTimeTo);

        webDriverWait.until(ExpectedConditions.visibilityOf(txtHostPublicKey));
        String txt6 = txtHostPublicKey.getAttribute("value");
        assertEquals(txt6, publicKey);

    }
    public void setApiSoap(String user, String pass,String hostKey) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxApiConnection));
        Actions actions = new Actions(driver);
        actions.moveToElement(cbxApiConnection).click().build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtApiSoap));
        actions.moveToElement(rbtApiSoap).click().build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(txtUserSoap));
        txtUserSoap.clear();
        txtUserSoap.sendKeys(user);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxSoapPassword));
        cbxSoapPassword.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(txtPasswordApi));
        txtPasswordApi.clear();
        txtPasswordApi.sendKeys(pass);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtHostPublicKeyApi));
        txtHostPublicKeyApi.clear();
        txtHostPublicKeyApi.sendKeys(hostKey);
    }

    public void setApiRest(String user, String pass) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxApiConnection));
        Actions actions = new Actions(driver);
        actions.moveToElement(cbxApiConnection).click().build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rbtApiRest));
        rbtApiRest.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(txtUserRest));
        txtUserRest.clear();
        txtUserRest.sendKeys(user);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxRestPassword));
        cbxRestPassword.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(txtPasswordRest));
        txtPasswordRest.clear();
        txtPasswordRest.sendKeys(pass);
    }

public void addTagToTagDictionary(String tag){
    WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
    webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkTag));
    Actions actions = new Actions(driver);
    actions.moveToElement(lnkTag).click().build().perform();
    webDriverWait.until(ExpectedConditions.elementToBeClickable(txtTag));
    txtTag.clear();
    txtTag.sendKeys(tag);

    webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddTag));
    btnAddTag.click();

    webDriverWait.until(ExpectedConditions.elementToBeClickable(lastValueTag));
    String txt=lastValueTag.getText();

    assertEquals(txt, tag);

    webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSaveTag));
    btnSaveTag.click();

}

public void deleteTagFromDictionary(){
    WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
    webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkTag));
    Actions actions = new Actions(driver);
    actions.moveToElement(lnkTag).click().build().perform();

    webDriverWait.until(ExpectedConditions.elementToBeClickable(lastValueTag));
    String txt=lastValueTag.getText();
    lastValueTag.click();

    webDriverWait.until(ExpectedConditions.elementToBeClickable(lastValueTag));
    btnDeleteTag.click();

    webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSaveTag));
    btnSaveTag.click();

    String txt2=lastValueTag.getText();
assertNotEquals(txt,txt2);
}

public void switchOnRodo(){
    WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
    webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxRodo));
    cbxRodo.click();
    webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#enable_rodo_checkbox[class*='mat-checkbox-checked']")));

}
    public void switchOnSingleRecForInsideCalls(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxSingleRec));
        cbxSingleRec.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#enable_single_recording_checkbox[class*='mat-checkbox-checked']")));

    }
    public void switchOnBlockAutoDeleteReport(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxAutoDeleteReport));
        cbxAutoDeleteReport.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#reportAutoDeleteDisable[class*='mat-checkbox-checked']")));


    }
    public void switchOnLoginWithCertificate(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxLoggWithCert));
        cbxLoggWithCert.click();
        Dialog dialog=new Dialog(driver);
        dialog.clickOnConfirmButton();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#enable__checkbox[class*='mat-checkbox-checked']")));

    }
    public void switchOnOppbOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxOppb));
        cbxOppb.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#directly_incoming_checkbox[class*='mat-checkbox-checked']")));
    }
    public void switchOnTransferOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxCanTransfer));
        cbxCanTransfer.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname=\"canTransfer\"][class*='mat-checkbox-checked']")));
    }
    public void switchOnRecordingDirectlyIncomingCallsOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxRecordingDirectlyIncomingCalls));
        cbxRecordingDirectlyIncomingCalls.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname=\"recordingDirectlyIncomingCalls\"][class*='mat-checkbox-checked']")));
    }
    public void switchOnRecordingOutgoingCallsOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxRecordingOutgoingCalls));
        cbxRecordingOutgoingCalls.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname=\"recordingOutgoingCalls\"][class*='mat-checkbox-checked']")));
    }
    public void switchOnPersonalizedAnnouncementOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxPersonalizedAnnouncement));
        cbxPersonalizedAnnouncement.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname=\"personalizedAnnouncementEnabled\"][class*='mat-checkbox-checked']")));
    }
    public void switchOnApiAccessOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxApiAccess));
        cbxApiAccess.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[formcontrolname=\"apiAccess\"][class*='mat-checkbox-checked']")));
    }
    public void switchOnGuiAccessOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxGuiAccess));
        cbxGuiAccess.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#enable_gui_application_access_checkbox[class*='mat-checkbox-checked']")));
    }
    public void switchOnTagEnabledOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxTagEnabled));
        cbxTagEnabled.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#can_tag_enabled[class*='mat-checkbox-checked']")));
    }

    public void switchOnOneTimeOffRecordingOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkOneTimeOffRecording));
        lnkOneTimeOffRecording.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cbxOneTimeOffRecording));
        cbxOneTimeOffRecording.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#enable_can_switch_off_recording_outgoing_calls[class*='mat-checkbox-checked']")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSaveOneTimeOffRecording));
        btnSaveOneTimeOffRecording.click();
    }
    public void setPasswordForKeyOnUser(String pass){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkPasswordKeyForUser));
        lnkPasswordKeyForUser.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(txtPasswordKeyForUser));
        txtPasswordKeyForUser.sendKeys(pass);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSavePasswordKeyForUser));
        btnSavePasswordKeyForUser.click();
    }
    public void addBlackListOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkBlackListUser));
        lnkBlackListUser.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectBlackListUser));
        selectBlackListUser.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseLastBlackList));
        chooseLastBlackList.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddUserBlackList));
        btnAddUserBlackList.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseLastBlackListUserWithList.get(0)));
        String lastBlackList=chooseLastBlackListUserWithList.get(0).getText();
        System.out.println(lastBlackList);
    }
    public void deleteBlackListOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkBlackListUser));
        lnkBlackListUser.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseLastBlackListUserWithList.get(0)));
        chooseLastBlackListUserWithList.get(0).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteUserBlackList));
        btnDeleteUserBlackList.click();
        assertTrue(chooseLastBlackListUserWithList.isEmpty());

    }

    public void addWhiteListOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkWhiteListUser));
        lnkWhiteListUser.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectWhiteListUser));
        selectWhiteListUser.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseLastWhiteList));
        chooseLastWhiteList.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddUserWhiteList));
        btnAddUserWhiteList.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseLastWhiteListUserWithList.get(0)));
        String lastBlackList=chooseLastWhiteListUserWithList.get(0).getText();
        System.out.println(lastBlackList);
    }
    public void deleteWhiteListOnUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkWhiteListUser));
        lnkWhiteListUser.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseLastWhiteListUserWithList.get(0)));
        chooseLastWhiteListUserWithList.get(0).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteUserWhiteList));
        btnDeleteUserWhiteList.click();
        assertTrue(chooseLastWhiteListUserWithList.isEmpty());

    }

}
