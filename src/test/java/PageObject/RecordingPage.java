package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecordingPage {

    @FindBy(id = "recording_list_link")
    WebElement recordingTab;
    @FindBy(id = "headingOne")
    WebElement filterCriteria;
    @FindBy(id = "numberHeader")
    WebElement filterNumber;
    @FindBy(id = "mainNumber")
    WebElement filterNumberField;
    @FindBy(id = "filter_button")
    WebElement filter;
    @FindBy(xpath= "(//*[contains(@id,'_edit_tags')])[1]")
    WebElement editTags;
    @FindBy(id = "new_tag_input")
    WebElement tagsField;
    @FindBy(id = "save_button")
    WebElement saveEditTagsButton;
    @FindBy(id = "add_new_tag")
    WebElement addTag;
/////////////////
    @FindBy(xpath = "(//mat-checkbox[contains(@id,\"mat-checkbox-\")])[1]")
    WebElement chooseRec;
    @FindBy(xpath = "(//button[text()=\"Pobierz nagranie\"])")
    WebElement btnDownloadRec;
    @FindBy(xpath = "(//button[text()=\"Usuń nagranie\"])")
    WebElement btnDeleteRec;
    @FindBy(xpath = "(//button[text()=\"Zablokuj nagranie\"])")
    WebElement btnLockRec;
    @FindBy(xpath = "(//button[text()=\"Odblokuj nagranie\"])")
    WebElement btnUnlockRec;
    @FindBy(id = "filterValueRecordings_placeholder")
    WebElement searchField;
    @FindBy(xpath = "(//button[text()=\" Wyszukaj\"])")
    WebElement btnSearch;
    @FindBy(xpath = "(//input[contains(@id, \"mat-input-\")])")
    WebElement passwordField;
    @FindBy(id="password-recordings-download")
    WebElement btnSubmitPassword;
    @FindBy(id = "password-recordings-cancel")
    WebElement btnCancelPassword;

    @FindBy(id = "mat-select-19")
    WebElement selectRecType;
    @FindBy(xpath = "(//span[text()=\" Przychodzące użytkownik \"])")
    WebElement chooseIncomingType;

    @FindBy(id = "mat-select-22")
    WebElement selectInternalConnection;
    @FindBy(xpath = "(//span[text()=\"Tak\"])")
    WebElement chooseInternalConnectionAsTrue;

    @FindBy(id = "filter_button")
    WebElement btnFilter;

    private WebDriver driver;
    public RecordingPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnRecordingTab")

    public void clickOnRecordingTab(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(recordingTab));
        recordingTab.click();
    }

//    public void clickOnButtonfilterCriteria(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filterCriteria));
//        filterCriteria.click();
//    }

//    public void clickOnButtonFilterNumber(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filterNumber));
//        filterNumber.click();
//    }
//    public void typeIntoFilterNumberField(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filterNumberField));
//        filterNumberField.sendKeys("48222903841");
//    }
//    public void clickOnFilterButton(){
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(filter));
//        filter.click();
//    }

    @Step("clickOnEditTagsButton")

    public void clickOnEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editTags));

        Actions action = new Actions(driver);
        action.moveToElement(editTags).click().perform();
    }



    @Step("typeIntoEditTagsField")

    public void typeIntoEditTagsField(String editTags){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(tagsField));


        tagsField.clear();
        tagsField.sendKeys(editTags);
        addTag.click();



    }
    @Step("clickOnSaveEditTagsButton")

    public void clickOnSaveEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveEditTagsButton));
        saveEditTagsButton.click();
    }


    public void chooseRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseRec));
        chooseRec.click();
    }
    public void downloadRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDownloadRec));
        btnDownloadRec.click();
    }
    public void deleteRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnDeleteRec));
        btnDeleteRec.click();
    }
    public void lockRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnLockRec));
        btnLockRec.click();
    }
    public void unlockRecordingWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnUnlockRec));
        btnUnlockRec.click();
    }
    public void searchRecordingWithList(String recId){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(recId);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        btnSearch.click();
    }


    public void operationAutorization(String pass){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(passwordField));
        passwordField.sendKeys(pass);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(btnSubmitPassword));
        btnSubmitPassword.click();


    }

    public void filterRecordingWithListByType(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectRecType));
        selectRecType.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseIncomingType));
        chooseIncomingType.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnFilter));
        btnFilter.click();
    }
    public void filterRecordingWithListByInternalConnection(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectInternalConnection));
        selectInternalConnection.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseInternalConnectionAsTrue));
        chooseInternalConnectionAsTrue.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnFilter));
        btnFilter.click();
    }

}


