package PageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    @FindBy(id = "13869_edit_tags")
    WebElement editTags;
    @FindBy(id = "mat-input-8")
    WebElement tagsField;
    @FindBy(id = "save_button")
    WebElement saveEditTagsButton;



    private WebDriver driver;
    public RecordingPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void clickOnRecordingTab(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(recordingTab));
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


    public void clickOnEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(editTags));

        Actions action = new Actions(driver);
        action.moveToElement(editTags).click().perform();
    }




    public void typeIntoEditTagsField(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(tagsField));
        webDriverWait.ignoring(TimeoutException.class);


        tagsField.sendKeys("test");



    }
    public void clickOnSaveEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(saveEditTagsButton));
        saveEditTagsButton.click();
    }

}


