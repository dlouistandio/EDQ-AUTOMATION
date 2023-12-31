package com.test;

import com.qa.PageObjects.DashboardSchool.DashboardSchool;
import com.qa.PageObjects.DashboardVendor.CreateSchoolPage;
import com.qa.PageObjects.EmailPage.EmailInbox;
import com.qa.PageObjects.EmailPage.EmailLoginPage;
import com.qa.PageObjects.InvitationUser.InvitationLearnerPage;
import com.qa.PageObjects.InvitationUser.InvitationUserPage;
import com.qa.PageObjects.ManageCourse.CohortPage;
import com.qa.PageObjects.ManageCourse.EventPage;
import com.qa.PageObjects.ManageCourse.ManageMaterialCoursePage;
import com.qa.PageObjects.ManageCourse.SelfPacedPage;
import com.qa.PageObjects.DashboardVendor.DashboardVendor;
import com.qa.PageObjects.SSOPage.ForgotPasswordPage;
import com.qa.PageObjects.SSOPage.LoginPage;
import com.qa.PageObjects.SSOPage.SignUpPage;
import com.qa.PageObjects.SchoolWebPage.ForgotPasswordSchoolPage;
import com.qa.PageObjects.SchoolWebPage.HomePage;
import com.qa.PageObjects.SchoolWebPage.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public DashboardVendor dashboardVendor;
    public DashboardSchool dashboardSchool;
    public EventPage eventPage;
    public CohortPage cohortPage;
    public SelfPacedPage selfPacedPage;
    public ManageMaterialCoursePage manageMaterialCoursePage;
    public HomePage homePage;
    public CreateSchoolPage createSchoolPage;
    public SignUpPage signUpPage;
    public EmailLoginPage emailLoginPage;
    public EmailInbox emailInbox;
    public ForgotPasswordPage forgotPasswordPage;
    public InvitationUserPage invitationUserPage;
    public InvitationLearnerPage invitationLearnerPage;
    public ForgotPasswordSchoolPage forgotPasswordSchoolPage;
    public RegisterPage registerPage;

    public WebDriver initDriver(String url) throws IOException {
        Properties props = new Properties();
        DesiredCapabilities caps = new DesiredCapabilities();
        WebDriver driver = null;

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/GlobalData.properties");
        props.load(fis);
        String browserName = props.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")){
            caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
            caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
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

    public String emailProperties() throws IOException {
            // Load properties from file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/GlobalData.properties");
            props.load(fis);

            // Generate a random string
            String randomString = UUID.randomUUID().toString();

            // Replace the placeholder in the properties file
            props.setProperty("email_register", randomString + "@mailsac.com");

            // Save the updated properties to file
            props.store(new FileOutputStream("GlobalData.properties"), null);
            String email = props.getProperty("email_register");
            return email;

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
    @Parameters({"url"})
    public void launchApp(String url) throws IOException {
        driver = initDriver(url);
        loginPage = new LoginPage(driver);
        dashboardVendor = new DashboardVendor(driver);
        dashboardSchool = new DashboardSchool(driver);
        selfPacedPage = new SelfPacedPage(driver);
        eventPage = new EventPage(driver);
        cohortPage = new CohortPage(driver);
        manageMaterialCoursePage = new ManageMaterialCoursePage(driver);
        homePage = new HomePage(driver);
        createSchoolPage = new CreateSchoolPage(driver);
        signUpPage = new SignUpPage(driver);
        emailLoginPage = new EmailLoginPage(driver);
        emailInbox = new EmailInbox(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        invitationLearnerPage = new InvitationLearnerPage(driver);
        invitationUserPage = new InvitationUserPage(driver);
        forgotPasswordSchoolPage = new ForgotPasswordSchoolPage(driver);
        registerPage = new RegisterPage(driver);
     }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
