package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage {

   @FindBy(xpath ="//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")
    WebElement shopTab;
   @FindBy(xpath = "/html/body/app-root/app-main-view/div/app-shop-panel/div/app-shop-buy/table/tbody/tr[5]/td[2]/input")
    WebElement faxField;
   @FindBy(xpath = "//*[@id=\"save_changes\"]")
    WebElement saveChangeButton;
   @FindBy(xpath = "//*[@id=\"buy_package\"]")
    WebElement buyPackage;
   @FindBy(xpath = "//*[@id=\"choose_package\"]")
    WebElement valuePackage;


}
