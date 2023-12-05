package com.qa.PageObjects.ManageCourse;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.By;
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



    public void addSessionMaterialEvent(String material){
        String xPathSelectedMenu =  "//div[.='"+ material +"']";
        WebElement addMaterialButton = driver.findElement(By.xpath(xPathSelectedMenu));
        waitElementsDisplay(addMaterialButton);
        addMaterialButton.click();
    }

    public void inputFormWebinar(){
        waitElementsDisplay(titleMaterial);
        titleMaterial.sendKeys("Zoom");
        linkWebinar.sendKeys("zoom");
        descriptionField.click();
        descriptionFieldInput.sendKeys("123");
        durationField.sendKeys("1");
        saveMaterialButton.click();
    }


    public void inputFormOnsite() throws InterruptedException {
        waitElementsDisplay(titleMaterial);
        titleMaterial.sendKeys("Onsite");
        descriptionField.click();
        descriptionFieldInput.sendKeys("123");
        waitElementsDisplay(mapContainer);
        moveMapPinpoint();
        durationField.sendKeys("1");
        saveMaterialButton.click();
        Thread.sleep(5000);
    }


}
