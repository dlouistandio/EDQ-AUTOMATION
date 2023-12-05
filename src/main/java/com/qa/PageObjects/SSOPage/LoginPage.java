package com.qa.PageObjects.SSOPage;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GeneralObject {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//input[@id='signInFormUsername']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//input[@id='signInFormPassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//input[@name='signInSubmitButton']")
    private WebElement buttonSignIn;

    @FindBy(css = ".visible-md #loginErrorMessage")
    private WebElement alertText;

    public String getAlertText (){
        waitElementsDisplay(alertText);
        return alertText.getText();
    }
    @Step
    public void loginUser(String user, String pass){
        log().info("Username Is " + user);
        emailField.sendKeys(user);
        log().info("Password Is " + pass);
        passwordField.sendKeys(pass);
        buttonSignIn.click();
    }

    @Step
    public void loginInvalidUser(String user, String pass){
        log().info("Username Is " + user);
        emailField.sendKeys(user);
        log().info("Password Is " + pass);
        passwordField.sendKeys(pass);
        buttonSignIn.click();
    }
}
