package com.qa.PageObjects.SchoolWebPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralObjectSchool {
    WebDriver driver;
    public GeneralObjectSchool(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step
    public void waitElementsDisplay(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    @Step
    public void waitElementsNotDisplay(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOf(findBy));
    }
}
