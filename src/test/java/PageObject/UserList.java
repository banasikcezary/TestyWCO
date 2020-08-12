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
    @FindBy(xpath = "//*[@id=\"users_list_mat_table\"]/mat-row[1]")
    WebElement checkList;
    @FindBy(id = "mat-checkbox-27")
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
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userListLink));
        userListLink.click();}
    public void typeIntoSearchfield(String searchUser){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(searchUser);
    searchField.sendKeys(Keys.ENTER);}
    public void checkIfTheUserYouAreLookingForExists(String user){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            assertTrue(checkList.getText().contains(user));
            System.out.println(checkList.getText());
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            assertTrue(checkList.getText().contains(user));
            System.out.println(checkList.getText());
        }

        }
        public void clickOnUser(){
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(checkList));
            Actions action = new Actions(driver);
            action.moveToElement(checkList).click().build().perform();
    }
    public void clickOnCheckboxUSR(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkbox));
        checkbox.click();
    }
    public void clickOnButtonExportToCsv(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(exportCsvButton));
        exportCsvButton.click();
    }
    public void clickOnButtonImportCsv(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(importCsv));
        importCsv.click();
    }
    public void clickOnButtonChooseFile(){

        chooseFileButton.sendKeys("C:\\Users\\User\\Downloads\\1.csv");
    }
    public void clickOnButtonSendFileToApp(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendFileButton));
        sendFileButton.click();
    }

}
