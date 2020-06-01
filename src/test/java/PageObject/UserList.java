package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserList {
    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a")
    WebElement userListLink;
    @FindBy(id = "mat-input-0")
    WebElement searchField;
    @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-users-list/div/mat-table/mat-row")
    WebElement checkList;

    private WebDriver driver;
    public UserList(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickIntoUserListLink(){userListLink.click();}
    public void typeIntoSearchfield(){searchField.sendKeys("USR");}
    public void checkIfTheUserYouAreLookingForExists(){assertTrue(checkList.getText().contains("USR"));
        System.out.println(checkList.getText());}
        public void clickOnUser(){checkList.isDisplayed();
        checkList.click();}
}
