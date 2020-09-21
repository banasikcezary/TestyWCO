package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Configuration {

    @FindBy(id = "configuration_component_link")
    WebElement lnkConfiguration;
    @FindBy(xpath = "//*[contains(@id,'mat-expansion-panel-header-')][1]")
    WebElement lnkUserList;
    @FindBy(id = "login_input")
    WebElement txtLogin;
    @FindBy(xpath = "//*[@id=\"mat-checkbox-12\"]/label/div")
    WebElement chkShowInGui;
    @FindBy(id = "save_button")
    WebElement btnSave;

    private WebDriver driver;
    public Configuration(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("clickConfigurationLink")
    public void clickConfigurationLink(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkConfiguration));
        lnkConfiguration.click();
    }
    @Step("clickLinkUserList")
    public void clickLinkUserList(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lnkUserList));
        lnkUserList.click();
    }
    @Step("typeIntoTxtLoginField")
    public void typeIntoTxtLoginField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(txtLogin));
        txtLogin.sendKeys("KarolN");
    }

    @Step("clickInCheckboxShowInGui")
    public void clickInCheckboxShowInGui(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chkShowInGui));
        chkShowInGui.click();
    }

    @Step("clickInCheckboxShowInGui")
    public void clickSaveButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSave));
        btnSave.click();
    }


}
