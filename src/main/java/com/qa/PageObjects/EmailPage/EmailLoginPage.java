package com.qa.PageObjects.EmailPage;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailLoginPage extends GeneralObject {
    WebDriver driver;

    public EmailLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='page']//a[.='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement signInButtonForm;


    @Step
    public void inputEmailField (){
        waitElementsDisplay(usernameField);
        usernameField.sendKeys("eduqatautomationtest@gmail.com");
    }

    @Step
    public void inputPasswordField (){
        waitElementsDisplay(passwordField);
        passwordField.sendKeys("woof123puffy");
    }

    @Step
    public void clickLoginButton (){
        waitElementsDisplay(signInButtonForm);
        signInButtonForm.click();
    }

    @Step
    public void goToLoginPage (){
        waitElementsDisplay(signInButton);
        signInButton.click();
    }
}
