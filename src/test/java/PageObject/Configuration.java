package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.testng.Assert.*;

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
    @FindBy(id = "name_input")
    WebElement inputNameBlackList;
    @FindBy(id = "description_textarea")
    WebElement inputDescBlackList;
    @FindBy(xpath = "(//*[contains(@id,\"mat-checkbox-\")])[last()]")
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




    @FindBy(id = "Biała lista (Nagrywarka)_list_config_element")
    WebElement lnkWhiteList;
    @FindBy(xpath = "(//*[contains(@class,'mat-list-item mat-list-option whitelist-not-selected mat-accent ng-star-inserted')])[last()]")
    WebElement lnkWhiteListLast;
    @FindBy(id = "name_input")
    WebElement inputNameWhiteList;
    @FindBy(id = "description_textarea")
    WebElement inputDescWhiteList;
    @FindBy(xpath = "(//*[contains(@id,\"mat-checkbox-\")])[last()]")
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






    @FindBy(id = "IVR/VIP lista (Nagrywarka)_list_config_element")
    WebElement lnkVipList;
    @FindBy(id = "Nagrywanie połączeń (Nagrywarka)_list_config_element")
    WebElement lnkCallRec;
    @FindBy(id = "Archiwizacja połączeń_list_config_element")
    WebElement lnkCallArchiving;


    private WebDriver driver;
    public Configuration(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickConfigurationLink")
    public void clickConfigurationLink(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkConfiguration));
        Actions actions=new Actions(driver);
        actions.moveToElement(lnkConfiguration).click().perform();
//        lnkConfiguration.click();
    }
    @Step("clickLinkUserList")
    public void clickLinkUserList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkUserList));
        lnkUserList.click();
    }
    @Step("typeIntoTxtLoginField")
    public void selectNewUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lastUserButton));
        lastUserButton.click();
    }

    @Step("clickInCheckboxShowInGui")
    public void clickInCheckboxShowInGui(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chkShowInGui));
        chkShowInGui.click();
    }

    @Step("clickInCheckboxShowInGui")
    public void clickSaveButton() throws AWTException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSave));

         ((JavascriptExecutor)driver).executeScript("arguments[0].click();", btnSave);

      //  btnSave.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(confirmText));
               confirmText.isDisplayed();

        driver.findElement(By.xpath("//html")).click();
        driver.findElement(By.xpath("//html")).click();


     //   assertEquals(confirmText.getText(), "Konfiguracja zostala zaaktualizowana");
    }

    @Step("typeIntoLoginField")
    public void typeIntoLoginField(String login){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    @Step("typeIntoFirstNameField")
    public void typeIntoFirstNameField(String firstName){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        firstNameInput.sendKeys(firstName);
    }

    @Step("typeIntoLastNameInputField")
    public void typeIntoLastNameInputField(String lastName){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        lastNameInput.sendKeys(lastName);
    }

    @Step("typeIntoLastNameInputField")
    public void typeIntoNumberInputField(String number){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        numberInput.sendKeys(number);
    }

    @Step("typeIntoEmailInputField")
    public void typeIntoEmailInputField(String email){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginInput));
        emailInput.sendKeys(email);
    }

    public void typeIntoUserSearchField(String userName){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(userSearchField));
        userSearchField.sendKeys(userName);
    }

    public void clickOnDeleteButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }


    public void clickOnFunctionalitySettings(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkFunctionalitySettings));
        lnkFunctionalitySettings.click();
    }

    ////////////////////////////////////// BLACK LIST /////////////////////

    public void clickOnBlackListFunctionality(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkBlackList));
        lnkBlackList.click();
    }

    public void clickOnLastBlackList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkBlackListLast));
        lnkBlackListLast.click();
    }
    public void completeNameAndDescription(String nameBlackList,String descBlackList){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputNameBlackList));
        inputNameBlackList.clear();
        inputNameBlackList.sendKeys(nameBlackList);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputDescBlackList));
        inputDescBlackList.sendKeys(descBlackList);
    }
    public void verifyDeleteBlackList(){
        clickOnLastBlackList();
        assertNotEquals(inputNameBlackList.getText(),"BlackListaTest" );
    }
    public void verifyDeleteWhiteList(){
        clickOnLastWhiteList();
        assertNotEquals(inputNameWhiteList.getText(),"WhiteListaTest" );
    }



    public void clickOnGlobalBlackList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxGlobalBlackList));
        checkboxGlobalBlackList.click();
    }

    public void addNumberForBlackList(String number){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkNumberBlackList));
        lnkNumberBlackList.click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputAddNumberBlackList));
        inputAddNumberBlackList.sendKeys(number);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddNumberBlackList));
        btnAddNumberBlackList.click();
    }

    public void clickOnButtonSaveBlackList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSaveBlackList));
        btnSaveBlackList.click();
    }
    public void verifySaveBlackList(){
        clickOnLastBlackList();
        assertEquals(inputNameBlackList.getText(), "BlackListaTest");

    }
    public void verifySaveWhiteList(){
        clickOnLastBlackList();
        assertEquals(inputNameWhiteList.getText(), "WhiteListaTest");

    }
    public void verifyActivateGlobalBlacklist(){
        boolean isSelected = checkboxGlobalBlackList.isSelected();
        assertTrue(isSelected);
    }

    public void clickOnButtonDeleteBlackList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteBlackList));
        btnDeleteBlackList.click();
    }
    public void clickOnLinkActivationBlackList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkActivationBlackList));
        lnkActivationBlackList.click();
    }

    public void clickOnActivationLastBlackList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxActivateLastBlackList));
        checkboxActivateLastBlackList.click();
    }

    public void verifyActivateBlacklist(){
        clickOnLinkActivationBlackList();
        clickOnActivationLastBlackList();
        boolean isSelected = checkboxActivateLastBlackList.isSelected();
        assertTrue(isSelected);
    }

    public void verifyActivateWhitelist(){
        clickOnLinkActivationWhiteList();
        clickOnActivationLastWhiteList();
        boolean isSelected = checkboxActivateLastWhiteList.isSelected();
        assertTrue(isSelected);
    }


////////////////////////////////////////// WHITE LIST /////////////////////////////////


    public void clickOnWhiteListFunctionality(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkWhiteList));
        lnkWhiteList.click();
    }

    public void clickOnLastWhiteList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkWhiteListLast));
        lnkWhiteListLast.click();
    }
    public void completeNameAndDescriptionWhiteList(String nameBlackList,String descBlackList){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputNameWhiteList));
        inputNameWhiteList.clear();
        inputNameWhiteList.sendKeys(nameBlackList);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputDescWhiteList));
        inputDescWhiteList.sendKeys(descBlackList);
    }

    public void clickOnGlobalWhiteList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxGlobalWhiteList));
        checkboxGlobalWhiteList.click();
    }

    public void addNumberForWhiteList(String number){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkNumberWhiteList));
        lnkNumberWhiteList.click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(inputAddNumberBlackWhiteList));
        inputAddNumberBlackWhiteList.sendKeys(number);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnAddNumberWhiteList));
        btnAddNumberWhiteList.click();
    }

    public void clickOnButtonSaveWhiteList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSaveWhiteList));
        btnSaveWhiteList.click();
    }
    public void verifyActivateGlobalWhitelist(){
        boolean isSelected = checkboxGlobalWhiteList.isSelected();
        assertTrue(isSelected);
    }

    public void clickOnButtonDeleteWhiteList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteWhiteList));
        btnDeleteWhiteList.click();
    }
    public void clickOnLinkActivationWhiteList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkActivationWhiteList));
        lnkActivationWhiteList.click();
    }

    public void clickOnActivationLastWhiteList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkboxActivateLastWhiteList));
        checkboxActivateLastWhiteList.click();
    }




}
