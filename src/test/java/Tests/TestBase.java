package Tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {



    public WebDriver driver;

    @Step("Loading configuration from configuration.properties")
    @BeforeMethod
    public void beforeTest() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();

        driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), options);
        driver.manage().window().maximize();

        driver.navigate().to("http://172.25.0.33:8005/");

    }


    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();


    }


}
