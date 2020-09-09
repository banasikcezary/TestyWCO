package Tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import testng.listeners.TestListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)

public class TestBase {



    public WebDriver driver;

    @Step("Loading configuration from configuration.properties")
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
//        options.setCapability("marionette", true);
        options.addArguments("--no-sandbox");

        options.addArguments("--disable-gpu");



        driver = new RemoteWebDriver(new URL("http://192.168.216.133:4448/wd/hub"), options);
        driver.manage().window().maximize();

        driver.navigate().to("http://172.25.0.33:8005/login");
        System.out.println("Open Browser");


    }
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {

        screenshot();
        driver.close();
        driver.quit();

        System.out.println("Closing Browser");



    }


}
