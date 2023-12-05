package com.qa.PageObjects.ManageCourse;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageMaterialCoursePage extends GeneralObject {
    WebDriver driver;

    public ManageMaterialCoursePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='ant-message-notice-content']")
    private WebElement successAddMaterialAlert;

    @FindBy(xpath = "//div[@class='session-add']/button")
    private WebElement addMaterialSessionButton;

    @FindBy(xpath = "//h3[.='Session 1']")
    private WebElement sessionText;

    public String successAddMaterialText(){
        return successAddMaterialAlert.getText();
    }

    public String getHeaderText(){
        waitElementsDisplay(headerCourseText);
        return headerCourseText.getText();
    }

    public String sessionText(){
        return sessionText.getText();
    }

    public void inputFormMaterialText(){
        waitElementsDisplay(titleMaterial);
        titleMaterial.sendKeys("Ini Text");
        descriptionField.click();
        descriptionFieldInput.sendKeys("123");
        durationField.sendKeys("1");
        saveMaterialButton.click();
        waitElementsDisplay(successAddMaterialAlert);
    }

    //Select material lesson Exam, Media
    public void selectMaterialLessonType(String type){
        waitElementsDisplay(addMaterialSessionButton);
        addMaterialSessionButton.click();
        String xPathSelectedMenu =  "//div[.='"+ type +"']";
        WebElement materialLessonType = driver.findElement(By.xpath(xPathSelectedMenu));
        waitElementsDisplay(materialLessonType);
        materialLessonType.click();
    }

    public void addSessionMaterialSelfPaced(String material){
        waitElementsDisplay(headerCourseText);
        addLessonButton.click();
        addMaterialSessionButton.click();
        String xPathSelectedMenu =  "//div[.='"+ material +"']";
        WebElement addMaterialButton = driver.findElement(By.xpath(xPathSelectedMenu));
        waitElementsDisplay(addMaterialButton);
        addMaterialButton.click();
    }


}
