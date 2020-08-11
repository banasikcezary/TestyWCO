package PageObject;

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

    @FindBy(xpath = "//*[contains(@id, \"role_\")]")
    WebElement assertUserRole;



    private WebDriver driver;

    public UserAndPermissions(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnUserAndPermissionButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(userAndPermission));
        userAndPermission.click();
    }

    public void clickOnUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(users));
        Actions actions = new Actions(driver);
        actions.moveToElement(users).click().build().perform();
    }

    public void clickOnAddUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addUserButton));

        addUserButton.click();
    }

    public void typeIntoLoginField() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(loginField));
        webDriverWait.ignoring(TimeoutException.class);

        loginField.sendKeys("KarolN");
    }

    public void typeIntoFirstNameField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.sendKeys("Karol");
    }

    public void typeIntoLastName() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(lastNameField));
        lastNameField.sendKeys("Nowak");
    }

    public void typeIntoEmailField() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys("qwerty@o2.pl");
    }

    public void typeIntoPhoneField() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(phoneField));
        phoneField.sendKeys("666555777");
    }

    public void clickOnSaveNewUserButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(saveUserButton));
        saveUserButton.click();
        driver.findElement(By.xpath("//html")).click();

    }

    public void assertUser() {
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));

        String name = assertRoleName.getText();
        assertEquals(name, "KarolN");
    }

    public void assertDeleteUser() {
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));

        String name = assertRoleName.getText();
        assertNotEquals(name, "KarolN");
    }

    public void typeIntoSearchUserField() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(searchUserField));
        searchUserField.clear();
        searchUserField.sendKeys("KarolN");
    }

      public void clickOnSearchButton(){
          WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
          webDriverWait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();}

    public void clickOnShowRoleButton() {



        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            showRoleButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
            showRoleButton.click();
        }
    }

    public void clickOnAddAssignmentButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addAssignmentButton));
        addAssignmentButton.click();

    }

    public void selectRole() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(selectRole));

        selectRole.click();
        role.click();

    }

    public void clickAddRoleButton() {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(addRoleButton));
        addRoleButton.click();
    }

    public void assertionAddRoleForUser(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(assertUserRole));
        String userRola = assertUserRole.getText();
        assertEquals(userRola,"Super Admin");
    }



    public void clickOnDeleteUser() {

        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(deleteUser));
           deleteUser.click();
            driver.findElement(By.xpath("//html")).click();
            driver.navigate().refresh();
            WebDriverWait webDriverWait1 = new WebDriverWait(driver, 10);
            webDriverWait1.until(ExpectedConditions.visibilityOf(assertRoleName));
            String name = assertRoleName.getText();
            assertNotEquals(name, "KarolN");

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(deleteUser));
            deleteUser.click();
            driver.findElement(By.xpath("//html")).click();
            driver.navigate().refresh();

            WebDriverWait webDriverWait1 = new WebDriverWait(driver, 10);
            webDriverWait1.until(ExpectedConditions.visibilityOf(assertRoleName));
            String name = assertRoleName.getText();
            assertNotEquals(name, "KarolN");
        }


    }
}