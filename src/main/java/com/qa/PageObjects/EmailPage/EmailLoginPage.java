package com.qa.PageObjects.EmailPage;

import com.qa.Components.GeneralObject;
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

    @FindBy(css = "[placeholder='anything']")
    private WebElement toEmailInboxField;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block btn btn-primary']")
    private WebElement checkEmailButton;
}
