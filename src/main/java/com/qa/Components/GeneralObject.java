package com.qa.Components;

import com.qa.Log4j2.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralObject extends LogUtils {
    WebDriver driver;

    @FindBy(xpath = "//a[.='Sign In']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[.='Sign Up']")
    public WebElement signUpButton;

    @FindBy(xpath = "//div[@class='curriculum-session__add']/button")
    public WebElement addLessonButton;

    @FindBy(xpath = "//div[@class='ant-card ant-card-bordered active']/div[@class='ant-card-body']")
    public WebElement createBlankProductButton;

    @FindBy(xpath = "//div[@class='section-body__group']//input[@name='courseName']")
    public WebElement titleField;

    @FindBy(xpath = "//div[@class='section-footer']//button[@class='sc-qRumB gyLfCK btn btn-primary']")
    public WebElement createProductButton;

    @FindBy(xpath = "//div[@class='DraftEditor-root']")
    public WebElement descriptionField;

    @FindBy(xpath = "//div[@class='form-group']/input[@placeholder='Write lesson title']")
    public WebElement titleMaterial;

    @FindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']/span[1]")
    public WebElement descriptionFieldInput;

    @FindBy(xpath = "//div[@class='duration-picker']/input[1]")
    public WebElement durationField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveMaterialButton;

    @FindBy(xpath = "//div[@class='left-header__text']")
    public WebElement headerCourseText;

    @FindBy(css = ".maps-section__maps")
    public WebElement mapContainer;

    public GeneralObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitElementsDisplay(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitElementsNotDisplay(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOf(findBy));
    }

    public void moveMapPinpoint(){
        new Actions(driver).moveToElement(mapContainer, 5, 5).clickAndHold().moveByOffset(300, 0).release().build().perform();
    }
}
