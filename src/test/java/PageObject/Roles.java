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

public class Roles {

    @FindBy(xpath = "//*[@id=\"roles\"]")
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

    @FindBy(xpath = "(//p[contains(@id,'role_name')])[last()]")
    WebElement verifyAddNewRole;
    @FindBy(id = "open_folder_button_12")
    WebElement showPermissionRole;
    @FindBy(id = "privilege_12_0")
    WebElement checkPermissionRole;


    private WebDriver driver;
    public Roles(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnRolesButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rolesButton));
//        Actions actions=new Actions(driver);
//        actions.moveToElement(rolesButton).click().build().perform();
       rolesButton.click();
    }
    public void clickOnAddRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addRoleButton));
        addRoleButton.click();}
    public void typeIntoAddRoleNameField(String name){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addRoleNameField));
        addRoleNameField.sendKeys(name);}
    public void typeIntoAddRoleDescriptionField(String description){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(addRoleDescriptionField));
        addRoleDescriptionField.sendKeys(description);}
    public void clickOnSaveNewRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveNewRole));
        saveNewRole.click();}
    public void clickOnEditRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(editRole));
        editRole.click();}
    public void typeIntoEditRoleNameField(String editName){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(editRoleNameField));
        editRoleNameField.clear();
        editRoleNameField.sendKeys(editName);}
    public void typeIntoEditRoleDescription(String editDescription){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(editRoleDesc));
        editRoleDesc.clear();
        editRoleDesc.sendKeys(editDescription);}
    public void clickOnSaveEditRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveEditRole));
        saveEditRole.click();}

    public void clickAddPrivilegeForNewRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addPrivilageForNewRole));
        addPrivilageForNewRole.click();}
    public void selectChoosePrivilege(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(choosePrivilage));
        choosePrivilage.click();
        selectPrivilage.click();
    }
    public void clickOnSavePrivilege(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(savePrivilege));
        savePrivilege.click();}
    public void clickOpenRole(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(openRole));
        openRole.click();}
    public void clickOnDeletePrivilegeFromRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deletePrivilegeFromRole));
        deletePrivilegeFromRole.click();}
    public void clickDeleteRoleButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteRole));
        deleteRole.click();}


    @Step("validateAddRoleForCertificate")
    public void validateAddRole(String addRole) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));
        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'role_name')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();


        if(result !=addRole) {
            WebDriverWait webDriverWait1 = new WebDriverWait(driver, 30);
            webDriverWait1.until(ExpectedConditions.visibilityOf(verifyAddNewRole));
            List<WebElement> allElement1 = driver.findElements(By.xpath("//p[contains(@id,'role_name')]"));
            int count1 = allElement1.size();
            String result1 = allElement1.get(count1 - 1).getText();

            assertEquals(result1, addRole);
        }else{
            assertEquals(result, addRole);
        }
    }

    @Step("validateAddRoleForCertificate")
    public void validateEditRole(String editRole) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));

        List<WebElement> allElement = driver.findElements(By.xpath("//p[contains(@id,'role_name')]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertEquals(result, editRole);
    }

    @Step("validateAddRoleForCertificate")
    public void validateDeleteRole(String editRole) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));

        List<WebElement> allElement = driver.findElements(By.xpath("(//p[contains(@id,'role_name')])[last()]"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertNotEquals(result, editRole);
    }

    @Step("validateAddRoleForCertificate")
    public void validateAddPermissionForRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));
        showPermissionRole.click();



        List<WebElement> allElement = driver.findElements(By.id("privilege_13_0"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertEquals(result, "W??czanie/wy??czanie ustawienia CLIR");
    }

    @Step("validateAddRoleForCertificate")
    public void validateDeletePermissionForRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(verifyAddNewRole));
        showPermissionRole.click();



        List<WebElement> allElement = driver.findElements(By.id("privilege_13_0"));
        int count = allElement.size();
        String result = allElement.get(count - 1).getText();

        assertNotEquals(result, "W??czanie/wy??czanie ustawienia CLIR");
    }

}
