package com.test;

import com.qa.PageObjects.SchoolWebPage.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

public class BaseTestSchool {
    public WebDriver driver;
    public HomePage homePage;


    public WebDriver initDriver() throws IOException {
        Properties props = new Properties();
        DesiredCapabilities caps = new DesiredCapabilities();
        WebDriver driver = null;

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/GlobalData.properties");
        props.load(fis);
        String browserName = props.getProperty("browser");
        String webUrl = props.getProperty("url2");

        if (browserName.equalsIgnoreCase("chrome")){
            caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
            caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        }
//        driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(webUrl);
        return driver;
    }


    public void changeTabDriver(){
        String currentHandle= driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();
        for(String actual: handles) {
            if(!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
            }
        }
    }

    public String generateRandomString(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    @BeforeMethod(alwaysRun = true)
    public void launchApp() throws IOException {
        driver = initDriver();
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
