package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserList {
    @FindBy(id = "user_list_link")
    WebElement userListLink;
    @FindBy(id = "filterValue_placeholder")
    WebElement searchField;
    @FindBy(xpath = "//*[@id=\"users_list_mat_table\"]/mat-row")
    WebElement checkList;
    @FindBy(id = "mat-checkbox-24")
    WebElement checkbox;
    @FindBy(id = "export_csv_button")
    WebElement exportCsvButton;
    @FindBy(id = "import_csv_button")
    WebElement importCsv;
    @FindBy(id = "file")
    WebElement chooseFileButton;
    @FindBy(id = "send_button")
    WebElement sendFileButton;


    private WebDriver driver;
    public UserList(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickIntoUserListLink(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(userListLink));
        userListLink.click();}
    public void typeIntoSearchfield(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys("USR");
    searchField.sendKeys(Keys.ENTER);}
    public void checkIfTheUserYouAreLookingForExists(){
//
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
//        webDriverWait.until(ExpectedConditions.visibilityOf(checkList));



        FluentWait<WebDriver> fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(30));
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(checkList));
        searchField.isDisplayed();
        checkList.isDisplayed();
        assertTrue(checkList.getText().contains("USR"));
        System.out.println(checkList.getText());}
        public void clickOnUser(){
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            Actions action = new Actions(driver);
            action.moveToElement(checkList).click().build().perform();
    }
    public void clickOnCheckboxUSR(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();
    }
    public void clickOnButtonExportToCsv(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(exportCsvButton));
        exportCsvButton.click();
    }
    public void clickOnButtonImportCsv(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(importCsv));
        importCsv.click();
    }
    public void clickOnButtonChooseFile(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(chooseFileButton));
        chooseFileButton.sendKeys("C:\\Users\\DELL\\Downloads\\fileName.csv");
    }
    public void clickOnButtonSendFileToApp(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(sendFileButton));
        sendFileButton.click();
    }

}
