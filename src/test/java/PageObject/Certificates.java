package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
@FindBy(xpath = "//*[@id=\"mat-option-0\"]/div")
WebElement clickOnSelectRole;
@FindBy(id = "privilege_add")
WebElement saveNewRoleButton;

@FindBy(xpath = "(//button[text()=\"Pobierz\"])[last()]")
WebElement downloadCertificateButton;

@FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
WebElement deleteCertificateButton;

@FindBy(xpath = "(//p[contains(@id,'cn')])[last()]")
WebElement verifyCreateCert;
@FindBy(xpath = "(//p[contains(@id,'role')])[last()]")
WebElement verifyAddRole;
@FindBy(id = "clear_button")
WebElement clearButton;




    private WebDriver driver;
    public Certificates(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("click On Certificates Button")
    public void clickOnCertificatesButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(certificatesButton));

        certificatesButton.click();
        System.out.println("1");
        ;}

    @Step("click On Add User Button")
    public void clickOnAddUserButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addUserButton));
        addUserButton.click();
        System.out.println("2");

    }

    @Step("type Into Name Field")
    public String typeIntoAddNameField(String name){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addNameField));
        addNameField.sendKeys(name);

        System.out.println("3");

        return name;}



    @Step("type Into Email Field")
    public void typeIntoAddEmailField(String email){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addEmailField));
        addEmailField.sendKeys(email);
        System.out.println("4");

    }
    @Step("type Into City Field")
    public void typeIntoAddCityField(String city){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addCityField));
        addCityField.sendKeys(city);
        System.out.println("5");

    }
    @Step("type Into Country Field")
    public void typeIntoAddCountryField(String country){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addCountryField));
        addCountryField.sendKeys(country);
        System.out.println("6");
    }
    @Step("type Into State Field")
    public void typeIntoAddStateField(String state){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addStateField));
        addStateField.sendKeys(state);

        System.out.println("7");
    }
    @Step("type Into Organisation Field")
    public void typeIntoAddOrganisationField(String organisation){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addOrganisationField));
        addOrganisationField.sendKeys(organisation);
        System.out.println("8");

    }
    @Step("type Into OrganisationalUnit Field")
    public void typeIntoAddOrganisationalUnitField(String organisationalUnit){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addOrganisationalUnitField));
        addOrganisationalUnitField.sendKeys(organisationalUnit);
        System.out.println("9");

    }
    @Step("load File With Certificates")
    public void loadFileWithCertificates(){

        chooseFile.sendKeys("C:\\Users\\User\\Downloads\\cert.crt");
        System.out.println("10");
    }
    @Step("click Save New Certificate Button")
    public void clickSaveNewCertificateButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveNewCertidicate));
        saveNewCertidicate.click();
        System.out.println("11");

    }
    @Step("type Into Search Name Field")
    public void typeIntoSearchNameField(String searchName){
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(searchNameField));
        } catch (TimeoutException e) {
            System.out.println(e.toString());
        }
        searchNameField.click();
        searchNameField.clear();
        searchNameField.sendKeys(searchName);
        System.out.println("12");

    }
    @Step("click On Search Certificate Button")
    public void clickOnSearchCertificateButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(searchCertificateButton).click().build().perform();
        System.out.println("13");

    }
    @Step("validate The Certificate Creation")
    public void validateTheCertificateCreation(String name){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyCreateCert));

      String certName=verifyCreateCert.getText();

        assertEquals(certName,name);
        System.out.println("14");

    }
    @Step("click Into Show Roles")
    public void clickIntoShowRoles(){


        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoles));
            showRoles.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoles));
            showRoles.click();
        }
       }

    @Step("click Add Assignment Button")
    public void clickAddAssignmentButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addAssignmentButton));
        addAssignmentButton.click();}
    @Step("select Choose Role")
    public void selectChooseRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickInRole));
       clickInRole.click();
   clickOnSelectRole.click();}
    @Step("click On Save New Role Button")
    public void clickOnSaveNewRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveNewRoleButton));
        saveNewRoleButton.click();}
    @Step("click On Download Certificate Button")
    public void clickOnDownloadCertificateButton(){


        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(downloadCertificateButton));
            downloadCertificateButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(downloadCertificateButton));
            downloadCertificateButton.click();
        }
        }
    @Step("click On Delete Certificate Button")
    public void clickOnDeleteCertificateButton(){

        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteCertificateButton));
            deleteCertificateButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteCertificateButton));
            deleteCertificateButton.click();
        }}

        @Step("validate Add Role For Certificate")
        public void validateAddRoleForCertificate() {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddRole));


            List<WebElement> allElement=driver.findElements(By.xpath("(//p[contains(@id,'cn')])[last()]")) ;
            int count=allElement.size();
            String result=allElement.get(count-1).getText();
            assertEquals(result, "Super Admin");
        }

    @Step("validate The Certificate Delete")
    public void validateTheCertificateDelete(String certificate){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyCreateCert));


        String result=verifyCreateCert.getText();
        assertNotEquals(result,certificate);

    }
    @Step("clear Certificate SearchField")
    public void clearCertificateSearchField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(clearButton));
        clearButton.click();
    }


}
