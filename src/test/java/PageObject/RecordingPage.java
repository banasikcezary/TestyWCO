package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecordingPage {

    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")
    WebElement recordingTab;
    @FindBy(xpath = "//*[@id=\"headingOne\"]/h5/span")
    WebElement filterCriteria;
    @FindBy(xpath = "//*[@id=\"numberHeader\"]/span")
    WebElement filterNumber;
    @FindBy(id = "mainNumber")
    WebElement filterNumberField;
    @FindBy(xpath = "//*[@id=\"filterSegmentAccordion\"]/button")
    WebElement filter;
    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-recording-list/div/div[2]/div[1]/mat-table/mat-row[1]/mat-cell[11]/div/div[2]/button")
    WebElement editTags;
    @FindBy(xpath = "//*[@id=\"mat-input-12\"]")
    WebElement tagsField;
    @FindBy(xpath = "//*[@id=\"mat-dialog-1\"]/app-tag-column-edit/div/div[2]/div[1]/button")
    WebElement saveEditTagsButton;



    private WebDriver driver;
    public RecordingPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void clickOnRecordingTab(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(recordingTab));
        recordingTab.click();
    }

    public void clickOnButtonfilterCriteria(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(filterCriteria));
        filterCriteria.click();
    }

    public void clickOnButtonFilterNumber(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(filterNumber));
        filterNumber.click();
    }
    public void typeIntoFilterNumberField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(filterNumberField));
        filterNumberField.sendKeys("48517583076");
    }
    public void clickOnFilterButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(filter));
        filter.click();
    }
    public void clickOnEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOf(editTags));
        Actions action = new Actions(driver);
        action.moveToElement(editTags).click().perform();
    }
    public void typeIntoEditTagsField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(tagsField));

        Actions action = new Actions(driver);
        action.moveToElement(tagsField).sendKeys("testEdycjiTagu").build().perform();

    }
    public void clickOnSaveEditTagsButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(saveEditTagsButton));
        saveEditTagsButton.click();
    }

}


