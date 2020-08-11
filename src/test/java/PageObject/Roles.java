package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Roles {

    @FindBy(id = "roles")
    WebElement rolesButton;

    @FindBy(id = "add_privilege_button")
    WebElement addRoleButton;
    @FindBy(id = "add_role_name")
    WebElement addRoleNameField;
    @FindBy(id = "add_role_description")
    WebElement addRoleDescriptionField;
    @FindBy(id = "role_add")
    WebElement saveNewRole;

    @FindBy(xpath = "(//button[text()=\"Edytuj\"])[last()]")
    WebElement editRole;
    @FindBy(id = "edit_role_name")
    WebElement editRoleNameField;
    @FindBy(id = "edit_role_description")
    WebElement editRoleDesc;
    @FindBy(id = "role_edit")
    WebElement saveEditRole;


    @FindBy(xpath = "(//button[text()=\"Dodaj uprawnienie\"])[last()]")
    WebElement addPrivilageForNewRole;
    @FindBy(id = "choose_privilege")
    WebElement choosePrivilage;
    @FindBy(id="mat-option-0")
    WebElement selectPrivilage;
    @FindBy(id = "privilege_add")
    WebElement savePrivilege;

    @FindBy(xpath = "(//img)[last()]")
    WebElement openRole;
    @FindBy(xpath = "(//button[contains(@id, \"delete_privilege_\")])[last()]")
    WebElement deletePrivilegeFromRole;

    @FindBy(xpath = "(//button[(text()=\"Usuń\")])[last()]")
    WebElement deleteRole;

    @FindBy(xpath = "//p[contains(@id,'role_name')]")
    WebElement verifyAddNewRole;
    @FindBy(id = "open_folder_button_13")
    WebElement showPermissionRole;
    @FindBy(id = "privilege_13_0")
    WebElement checkPermissionRole;


    private WebDriver driver;
    public Roles(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnRolesButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(rolesButton));
        rolesButton.click();}
    public void clickOnAddRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addRoleButton));
        addRoleButton.click();}
    public void typeIntoAddRoleNameField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addRoleNameField));
        addRoleNameField.sendKeys("testRoleName");}
    public void typeIntoAddRoleDescriptionField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addRoleDescriptionField));
        addRoleDescriptionField.sendKeys("Rola123");}
    public void clickOnSaveNewRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(saveNewRole));
        saveNewRole.click();}
    public void clickOnEditRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(editRole));
        editRole.click();}
    public void typeIntoEditRoleNameField(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(editRoleNameField));
        editRoleNameField.clear();
        editRoleNameField.sendKeys("Rola123445");}
    public void typeIntoEditRoleDescription(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(editRoleDesc));
        editRoleDesc.clear();
        editRoleDesc.sendKeys("testEdycjiOpisu");}
    public void clickOnSaveEditRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(saveEditRole));
        saveEditRole.click();}

    public void clickAddPrivilegeForNewRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addPrivilageForNewRole));
        addPrivilageForNewRole.click();}
    public void selectChoosePrivilege(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(choosePrivilage));
        choosePrivilage.click();
        selectPrivilage.click();
    }
    public void clickOnSavePrivilege(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(savePrivilege));
        savePrivilege.click();}
    public void clickOpenRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(openRole));
        openRole.click();}
    public void clickOnDeletePrivilegeFromRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(deletePrivilegeFromRole));
        deletePrivilegeFromRole.click();}
    public void clickDeleteRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(deleteRole));
        deleteRole.click();}


    @Step("validateAddRoleForCertificate")
    public void validateAddRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));
        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'role_name')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();


        if(result !="testRoleName") {
            WebDriverWait webDriverWait1 = new WebDriverWait(driver, 20);
            webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));
            List<WebElement> allElement1 = driver.findElements(By.xpath("//p[contains(@id,'role_name')]"));
            int count1 = allElement1.size();
            String result1 = allElement1.get(count1 - 1).getText();

            assertEquals(result1, "testRoleName");
        }else{
            assertEquals(result, "testRoleName");
        }
    }

    @Step("validateAddRoleForCertificate")
    public void validateEditRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));

        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'role_name')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertEquals(result, "Rola123445");
    }

    @Step("validateAddRoleForCertificate")
    public void validateDeleteRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));

        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'role_name')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertNotEquals(result, "Rola123445");
    }

    @Step("validateAddRoleForCertificate")
    public void validateAddPermissionForRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));
        showPermissionRole.click();



        List<WebElement> allElement = driver.findElements(By.id("privilege_13_0"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertEquals(result, "W??czanie/wy??czanie ustawienia CLIR");
    }

    @Step("validateAddRoleForCertificate")
    public void validateDeletePermissionForRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));
        showPermissionRole.click();



        List<WebElement> allElement = driver.findElements(By.id("privilege_13_0"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertNotEquals(result, "W??czanie/wy??czanie ustawienia CLIR");
    }

}
