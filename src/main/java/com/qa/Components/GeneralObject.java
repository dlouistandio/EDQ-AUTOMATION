package com.qa.Components;

import com.qa.Log4j2.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralObject extends LogUtils {
    WebDriver driver;

    @FindBy(xpath = "//a[.='Sign In']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[.='Sign Up']")
    private WebElement signUpButton;



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
}
