package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Certificates {



@FindBy(id = "certificates")
WebElement certificatesButton;

@FindBy(id = "add_user_button")
WebElement addUserButton;
@FindBy(id = "add_cn")
WebElement addNameField;
@FindBy(id = "add_email")
WebElement addEmailField;
@FindBy(id = "add_city")
WebElement addCityField;
@FindBy(id = "add_country")
WebElement addCountryField;
@FindBy(id = "add_state")
WebElement addStateField;
@FindBy(id = "add_organization")
WebElement addOrganisationField;
@FindBy(id = "add_organizational_unit")
WebElement addOrganisationalUnitField;
@FindBy(xpath = "//*[@id=\"ngx-mat-file-input-0\"]/input")
WebElement chooseFile;
@FindBy(id = "cert_add")
WebElement saveNewCertidicate;
@FindBy(id = "filter_value_input")
WebElement searchNameField;
@FindBy(id = "search_button")
WebElement searchCertificateButton;

@FindBy(xpath= "(//button[text()=\"Pokaż role\"])[last()]")
WebElement showRoles;
@FindBy(id = "add_assignment_button")
WebElement addAssignmentButton;
@FindBy(id = "choose_role")
WebElement clickInRole;
@FindBy(id = "mat-option-0")
WebElement clickOnSelectRole;
@FindBy(id = "privilege_add")
WebElement saveNewRoleButton;

@FindBy(xpath = "(//button[text()=\"Pobierz\"])[last()]")
WebElement downloadCertificateButton;

@FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
WebElement deleteCertificateButton;

@FindBy(xpath = "//p[contains(@id,'cn')]")
WebElement verifyCreateCert;
@FindBy(xpath = "//p[contains(@id,'role')]")
WebElement verifyAddRole;




    private WebDriver driver;
    public Certificates(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("click On Certificates Button")
    public void clickOnCertificatesButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(certificatesButton));

        certificatesButton.click();}

    @Step("click On Add User Button")
    public void clickOnAddUserButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addUserButton));
        addUserButton.click();}

    @Step("type Into Name Field")
    public void typeIntoAddNameField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addNameField));
        addNameField.sendKeys("Artur");}
    @Step("type Into Email Field")
    public void typeIntoAddEmailField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addEmailField));
        addEmailField.sendKeys("artur@o2.pl");}
    @Step("type Into City Field")
    public void typeIntoAddCityField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addCityField));
        addCityField.sendKeys("Warszawa");}
    @Step("type Into Country Field")
    public void typeIntoAddCountryField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addCountryField));
        addCountryField.sendKeys("Polska");}
    @Step("type Into State Field")
    public void typeIntoAddStateField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addStateField));
        addStateField.sendKeys("Stan");}
    @Step("type Into Organisation Field")
    public void typeIntoAddOrganisationField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addOrganisationField));
        addOrganisationField.sendKeys("Organizacja");}
    @Step("type Into OrganisationalUnit Field")
    public void typeIntoAddOrganisationalUnitField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addOrganisationalUnitField));
        addOrganisationalUnitField.sendKeys("Dział");}
    @Step("load File With Certificates")
    public void loadFileWithCertificates(){

        chooseFile.sendKeys("C:\\Users\\User\\Downloads\\cert.crt"); }
    @Step("click Save New Certificate Button")
    public void clickSaveNewCertificateButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(saveNewCertidicate));
        saveNewCertidicate.click(); }
    @Step("type Into Search Name Field")
    public void typeIntoSearchNameField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchNameField));
        searchNameField.sendKeys("Artur");}
    @Step("click On Search Certificate Button")
    public void clickOnSearchCertificateButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(searchCertificateButton).click().build().perform();
    }
    @Step("validate The Certificate Creation")
    public void validateTheCertificateCreation(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyCreateCert));

        List<WebElement> allElement=driver.findElements(By.xpath("//p[contains(@id,'cn')]")) ;
        int count=allElement.size();
        String result=allElement.get(count-1).getText();

        assertEquals(result,"Artur");

    }
    @Step("click Into Show Roles")
    public void clickIntoShowRoles(){


        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(showRoles));
            showRoles.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(showRoles));
            showRoles.click();
        }
       }

    @Step("click Add Assignment Button")
    public void clickAddAssignmentButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addAssignmentButton));
        addAssignmentButton.click();}
    @Step("select Choose Role")
    public void selectChooseRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(clickInRole));
       clickInRole.click();
   clickOnSelectRole.click();}
    @Step("click On Save New Role Button")
    public void clickOnSaveNewRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(saveNewRoleButton));
        saveNewRoleButton.click();}
    @Step("click On Download Certificate Button")
    public void clickOnDownloadCertificateButton(){


        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(downloadCertificateButton));
            downloadCertificateButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(downloadCertificateButton));
            downloadCertificateButton.click();
        }
        }
    @Step("click On Delete Certificate Button")
    public void clickOnDeleteCertificateButton(){

        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(deleteCertificateButton));
            deleteCertificateButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(deleteCertificateButton));
            deleteCertificateButton.click();
        }}

        @Step("validateAddRoleForCertificate")
        public void validateAddRoleForCertificate() {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddRole));

            List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'role')]"));
            int count = allElement.size();
            String result = allElement.get(count - 1).getText();

            assertEquals(result, "Super Admin");
        }

    @Step("validate The Certificate Creation")
    public void validateTheCertificateDelete(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyCreateCert));

        List<WebElement> allElement=driver.findElements(By.xpath("//p[contains(@id,'cn')]")) ;
        int count=allElement.size();
        String result=allElement.get(count-1).getText();

        assertNotEquals(result,"Artur");

    }


}
