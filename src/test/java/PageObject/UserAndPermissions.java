package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

public class UserAndPermissions {

    @FindBy(id = "privileges_component_link")
    WebElement userAndPermission;
    @FindBy(id = "users")
    WebElement users;
    @FindBy(id = "add_user_button")
    WebElement addUserButton;
    @FindBy(id = "add_login")
    WebElement loginField;
    @FindBy(id = "add_first_name")
    WebElement firstNameField;
    @FindBy(id = "add_last_name")
    WebElement lastNameField;
    @FindBy(id = "add_email")
    WebElement emailField;
    @FindBy(id = "add_phone")
    WebElement phoneField;
    @FindBy(id = "user_add")
    WebElement saveUserButton;
    @FindBy(id = "filter_value_input")
    WebElement searchUserField;
    @FindBy(id = "search_button")
    WebElement searchButton;
    @FindBy(xpath = "(//button[text()=\"Pokaż role\"])[last()]")
    WebElement showRoleButton;
    @FindBy(id = "add_assignment_button")
    WebElement addAssignmentButton;
    @FindBy(id = "choose_role")
    WebElement selectRole;
    @FindBy(id = "privilege_add")
    WebElement addRoleButton;
    @FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
    WebElement deleteUser;
    @FindBy(xpath = "(//p[contains(@id,\"username\")])[last()]")
    WebElement assertRoleName;

    @FindBy(id = "mat-option-0")
    WebElement role;

    @FindBy(xpath = "(//*[contains(@id, \"role_\")])[last()]")
    WebElement assertUserRole;



    private WebDriver driver;

    public UserAndPermissions(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("clickOnUserAndPermissionButton")

    public void clickOnUserAndPermissionButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(userAndPermission));
        userAndPermission.click();
    }

    @Step("clickOnUserButton")
    public void clickOnUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(users));
        Actions actions = new Actions(driver);
        actions.moveToElement(users).click().build().perform();
    }

    @Step("clickOnAddUserButton")
    public void clickOnAddUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addUserButton));

        addUserButton.click();
    }

    @Step("typeIntoLoginField")
    public void typeIntoLoginField(String login) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(loginField));
        webDriverWait.ignoring(TimeoutException.class);

        loginField.sendKeys(login);
    }

    @Step("typeIntoFirstNameField")
    public void typeIntoFirstNameField(String firstName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys(firstName);
    }

    @Step("typeIntoLastName")
    public void typeIntoLastName(String lastName) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.sendKeys(lastName);
    }

    @Step("typeIntoEmailField")
    public void typeIntoEmailField(String email) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
    }

    @Step("typeIntoPhoneField")
    public void typeIntoPhoneField(String phone) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.sendKeys(phone);
    }

    @Step("clickOnSaveNewUserButton")
    public void clickOnSaveNewUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveUserButton));
        saveUserButton.click();
        driver.findElement(By.xpath("//html")).click();

    }

    @Step("assertUser")
    public void assertUser(String user) {
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));

        String name = assertRoleName.getText();
        assertEquals(name, user);
    }

    @Step("assertDeleteUser")
    public void assertDeleteUser(String user) {
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));

        String name = assertRoleName.getText();
        assertNotEquals(name, user);
    }

    @Step("typeIntoSearchUserField")
    public void typeIntoSearchUserField(String searchUser) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchUserField));
        searchUserField.click();
        searchUserField.sendKeys(searchUser);
    }

    @Step("clickOnSearchButton")
    public void clickOnSearchButton(){
          WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
          webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();}

    @Step("clickOnShowRoleButton")
    public void clickOnShowRoleButton() {



        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            showRoleButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            showRoleButton.click();
        }
    }

    @Step("clickOnAddAssignmentButton")
    public void clickOnAddAssignmentButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addAssignmentButton));
        addAssignmentButton.click();

    }

    @Step("selectRole")
    public void selectRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectRole));

        selectRole.click();
        role.click();

    }

    @Step("clickAddRoleButton")
    public void clickAddRoleButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addRoleButton));
        addRoleButton.click();
    }

    @Step("assertionAddRoleForUser")
    public void assertionAddRoleForUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(assertUserRole));
        String userRola = assertUserRole.getText();
        assertEquals(userRola,"Super Admin");
    }



    @Step("clickOnDeleteUser")
    public void clickOnDeleteUser(String user) {

        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteUser));
           deleteUser.click();
            driver.findElement(By.xpath("//html")).click();
            driver.navigate().refresh();
            WebDriverWait webDriverWait1 = new WebDriverWait(driver, 30);
            webDriverWait1.until(ExpectedConditions.visibilityOf(assertRoleName));
            String name = assertRoleName.getText();
            assertNotEquals(name, user);

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteUser));
            deleteUser.click();
            driver.findElement(By.xpath("//html")).click();
            driver.navigate().refresh();

            WebDriverWait webDriverWait1 = new WebDriverWait(driver, 30);
            webDriverWait1.until(ExpectedConditions.visibilityOf(assertRoleName));
            String name = assertRoleName.getText();
            assertNotEquals(name, user);
        }


    }
}