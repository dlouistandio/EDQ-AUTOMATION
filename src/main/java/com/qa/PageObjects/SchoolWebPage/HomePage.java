package com.qa.PageObjects.SchoolWebPage;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GeneralObjectSchool {
    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = " //a[.='Log in']")
    private WebElement loginButton;

    public void clickLoginButton(){
        waitElementsDisplay(loginButton);
        loginButton.click();
    }

}
