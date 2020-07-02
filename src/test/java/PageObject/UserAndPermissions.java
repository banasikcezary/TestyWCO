package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

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
    @FindBy(xpath = "//*[@id=\"mat-input-0\"]")
    WebElement searchUserField;
    @FindBy(id = "search_button")
    WebElement searchButton;
    @FindBy(xpath = "(//button[text()=\"Pokaż role\"])[last()]")
    WebElement showRoleButton;
    @FindBy(id = "add_assignment_button")
    WebElement addAssignmentButton;
    @FindBy(xpath = "//*[@id=\"choose_role\"]/div/div[1]")
    WebElement selectRole;
    @FindBy(id = "privilege_add")
    WebElement addRoleButton;
    @FindBy(xpath = "(//button[text()=\"Usuń\"])[last()]")
    WebElement deleteUser;
    @FindBy(xpath = "(//p[contains(@id,\"username\")])[last()]")
    WebElement assertRoleName;


    private WebDriver driver;

    public UserAndPermissions(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnUserAndPermissionButton() {
        userAndPermission.click();
    }

    public void clickOnUserButton() {
        users.click();
    }

    public void clickOnAddUserButton() {
        addUserButton.click();
    }

    public void typeIntoLoginField() {
        loginField.sendKeys("KarolN");
    }

    public void typeIntoFirstNameField() {
        firstNameField.sendKeys("Karol");
    }

    public void typeIntoLastName() {
        lastNameField.sendKeys("Nowak");
    }

    public void typeIntoEmailField() {
        emailField.sendKeys("qwerty@o2.pl");
    }

    public void typeIntoPhoneField() {
        phoneField.sendKeys("666555777");
    }

    public void clickOnSaveNewUserButton() {
        saveUserButton.click();
        driver.findElement(By.xpath("//html")).click();

    }

    public void assertUser() {
        driver.navigate().refresh();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));

        String name = assertRoleName.getText();
        assertEquals(name, "KarolN");
    }

//    public void typeIntoSearchUserField() {
////        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
////        webDriverWait.until(ExpectedConditions.visibilityOf(searchUserField));
////        searchUserField.clear();
////        searchUserField.sendKeys("KarolN");
//    }

    //  public void clickOnSearchButton(){searchButton.click();}

    public void clickOnShowRoleButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(showRoleButton));
        try {

            Actions actions = new Actions(driver);
            actions.moveToElement(showRoleButton).click().build().perform();



        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            Actions actions = new Actions(driver);
            actions.moveToElement(showRoleButton).click().build().perform();


        }
    }

    public void clickOnAddAssignmentButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addAssignmentButton));
        addAssignmentButton.click();
    }

    public void selectRole() {
        Select select = new Select(selectRole);
        select.selectByVisibleText("rola1");
    }

    public void clickAddRoleButton() {
        addRoleButton.click();
    }

    public void clickOnDeleteUser() {

        try {

            Actions actions = new Actions(driver);
            actions.moveToElement(deleteUser).click().build().perform();
            driver.navigate().refresh();
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));
            String name = assertRoleName.getText();
            assertNotEquals(name, "KarolN");

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            Actions actions = new Actions(driver);
            actions.moveToElement(deleteUser).click().build().perform();

            driver.navigate().refresh();
            WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
            webDriverWait.until(ExpectedConditions.visibilityOf(assertRoleName));
            String name = assertRoleName.getText();
            assertNotEquals(name, "KarolN");
        }
        //deleteUser.click();}

    }
}