package com.qa.PageObjects.ManageCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingCoursePage extends GeneralObjectManageCourse{
    WebDriver driver;

    public PricingCoursePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = " //div[@class='ant-space-item']/div[contains(text(),'Pricing')]")
    private WebElement pricingText;

    @FindBy(xpath = " //label[.='Pricing Type']")
    private WebElement pricingTypeText;

    @FindBy(xpath = " //div[@class='ant-space-item']/button")
    private WebElement addPricingButton;

    public String getPricingText(){
        return pricingText.getText();
    }

    public void SetPricingCourse(){
        clickTabPrice();
        waitElementsDisplay(pricingText);
        addPricingButton.click();
        waitElementsDisplay(pricingTypeText);
        
    }
}
