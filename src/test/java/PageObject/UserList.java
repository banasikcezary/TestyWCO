package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserList {
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a")
    WebElement userListLink;
    @FindBy(id = "mat-input-0")
    WebElement searchField;
    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-users-list/div/mat-table/mat-row")
    WebElement checkList;
    @FindBy(xpath = "//*[@id=\"mat-checkbox-12\"]/label/div")
    WebElement checkbox;
    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-users-list/div/div/div[1]/button")
    WebElement exportCsvButton;
    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-users-list/div/div/div[2]/button")
    WebElement importCsv;
    @FindBy(id = "file")
    WebElement chooseFileButton;
    @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-file-upload-dialog/div[2]/div[1]/button")
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

        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
        assertTrue(checkList.getText().contains("USR"));
        System.out.println(checkList.getText());}
        public void clickOnUser(){
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOf(checkList));
            Actions action = new Actions(driver);
            action.moveToElement(checkList).click().build().perform();
    }
    public void clickOnCheckboxUSR(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
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
