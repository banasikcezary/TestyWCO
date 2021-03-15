package Tests;


import io.qameta.allure.Step;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import testng.listeners.TestListener;

import java.io.IOException;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

@Listeners(TestListener.class)
public class TestBase {
    public WebDriver driver;

    @Step("Loading configuration from configuration.properties")
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws IOException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");



      String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\downloadPath";


        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", downloadDir);

      options.setExperimentalOption("prefs", prefs);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
       capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);


        driver = new RemoteWebDriver(new URL("http://192.168.216.62:4448/wd/hub"),capabilities);

        RemoteWebDriver remoteWebDriver = (RemoteWebDriver) this.driver;
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        driver.navigate().to("https://wck.orange.pl/");
        System.out.println("Open Browser");
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {

        driver.close();
        driver.quit();

        System.out.println("Closing Browser");

    }

}
