package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
@FindBy(id = "add_organisation")
WebElement addOrganisationField;
@FindBy(id = "add_organisational_unit")
WebElement addOrganisationalUnitField;
@FindBy(id = "ngx-mat-file-input-2")
WebElement chooseFile;
@FindBy(id = "cert_add")
WebElement saveNewCertidicate;
@FindBy(id = "mat-input-32")
WebElement searchNameField;
@FindBy(id = "search_button")
WebElement searchCertificateButton;

@FindBy(id = "(//button[text()=\"Pokaż role\"])[last()]")
WebElement showRoles;
@FindBy(id = "add_assignment_button")
WebElement addAssignmentButton;
@FindBy(id = "choose_role")
WebElement chooseRole;
@FindBy(id = "privilege_add")
WebElement saveNewRoleButton;

@FindBy(id = "(//button[text()=\"Pobierz\"])[last()]")
WebElement downloadCertificateButton;

@FindBy(id = "(//button[text()=\"Usuń\"])[last()]")
WebElement deleteCertificateButton;




    private WebDriver driver;
    public Certificates(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnCertificatesButton(){certificatesButton.click();}
    public void clickOnAddUserButton(){addUserButton.click();}
    public void typeIntoAddNameField(){addNameField.sendKeys("testName");}
    public void typeIntoAddEmailField(){addEmailField.sendKeys("testEmail@o2.pl");}
    public void typeIntoAddCityField(){addCityField.sendKeys("testMiasto");}
    public void typeIntoAddCountryField(){addCountryField.sendKeys("testPanstwo");}
    public void typeIntoAddStateField(){addStateField.sendKeys("testState");}
    public void typeIntoAddOrganisationField(){addOrganisationField.sendKeys("testOrgarnisation");}
    public void typeIntoAddOrganisationalUnitField(){addOrganisationalUnitField.sendKeys("testOrganisationalUnit");}
    public void loadFileWithCertificates(){chooseFile.sendKeys("");}
    public void clickSaveNewCertificateButton(){saveNewCertidicate.click();}
    public void typeIntoSearchNameField(){searchNameField.sendKeys("testName");}
    public void clickOnSearchCertificateButton(){searchCertificateButton.click();}

    public void clickIntoShowRoles(){showRoles.click();}
    public void clickAddAssignmentButton(){addAssignmentButton.click();}
    public void selectChooseRole(){
        Select select= new Select(chooseRole);
    select.selectByVisibleText("rola1");}
    public void clickOnSaveNewRoleButton(){saveNewRoleButton.click();}
    public void clickOnDownloadCertificateButton(){downloadCertificateButton.click();}
    public void clickOnDeleteCertificateButton(){deleteCertificateButton.click();}


}
