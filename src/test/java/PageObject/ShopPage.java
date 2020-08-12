package PageObject;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {

   @FindBy(id ="shop_component_link")
    WebElement shopTab;
   @FindBy(id = "Faks_input")
    WebElement faxField;
   @FindBy(id = "save_changes")
    WebElement saveChangeButton;
   @FindBy(id = "buy_package")
    WebElement buyPackage;
   @FindBy(xpath = "//*[@id=\"navbarNav\"]/ul/li[3]/a")
   WebElement additionalFundsAvailableTab;
   @FindBy(id = "choose_package")
    WebElement valuePackage;

    private WebDriver driver;
    public ShopPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnShopTab(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(shopTab));
        webDriverWait.ignoring(TimeoutException.class);

        shopTab.click();
    }
    public void buyNewFaxFunctionalitiesWithExceedingTheAmount (){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(faxField));
        webDriverWait.ignoring(TimeoutException.class);

        faxField.clear();
        faxField.sendKeys("20000");
    }
    public void buyNewFaxFunctionalities(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(faxField));
        faxField.clear();
        faxField.sendKeys("7");
    }
    public void sellFaxFunctionalities(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(faxField));
        faxField.clear();
        faxField.sendKeys("0");
    }
    public void clickOnSaveChangeButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveChangeButton));
        saveChangeButton.click();
    }
    public void clickOnBuyPackageButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buyPackage));
        buyPackage.click();
    }
    public void clickOnAdditionalFundsAvailableTab(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(additionalFundsAvailableTab));
        additionalFundsAvailableTab.click();
    }

    public void selectValuePackageWithList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(valuePackage));
        Select listValuePackage = new Select(valuePackage);
        listValuePackage.selectByIndex(1);
    }
}
