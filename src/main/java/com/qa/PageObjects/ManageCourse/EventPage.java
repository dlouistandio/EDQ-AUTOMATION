package com.qa.PageObjects.ManageCourse;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventPage extends GeneralObject {
    WebDriver driver;

    public EventPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='form-group']/input[@placeholder='Insert your webinar link here..']")
    private WebElement linkWebinar;

    @FindBy(css = "[placeholder='Search location']")
    private WebElement mapSearchInput;

    @FindBy(css = ".search-result > div:nth-of-type(1) > .item-detail")
    private WebElement mapSearchResult;


    @Step
    public void addSessionMaterialEvent(String material){
        String xPathSelectedMenu =  "//div[.='"+ material +"']";
        WebElement addMaterialButton = driver.findElement(By.xpath(xPathSelectedMenu));
        waitElementsDisplay(addMaterialButton);
        addMaterialButton.click();
    }

    @Step
    public void inputFormWebinar(){
        waitElementsDisplay(titleMaterial);
        titleMaterial.sendKeys("Zoom");
        linkWebinar.sendKeys("zoom");
        descriptionField.click();
        descriptionFieldInput.sendKeys("123");
        durationField.sendKeys("1");
        saveMaterialButton.click();
    }

    @Step
    public void inputFormOnsite() {
        waitElementsDisplay(titleMaterial);
        titleMaterial.sendKeys("Onsite");
        descriptionField.click();
        descriptionFieldInput.sendKeys("123");
        mapSearchInput.sendKeys("Jakarta");
        waitElementsDisplay(mapSearchResult);
        mapSearchResult.click();
        waitElementsNotDisplay(mapSearchResult);
        durationField.sendKeys("1");
        saveMaterialButton.click();
    }


}
