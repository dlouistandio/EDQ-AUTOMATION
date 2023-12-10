package com.qa.PageObjects.SSOPage;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

    @FindBy(css = ".visible-md .textDescription-customizable")
    private WebElement loginFormText;

    @FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//a[.='Sign up']")
    private WebElement signUpButton;

    @FindBy(css = ".visible-md [name='username']")
    private WebElement signUpEmailField;

    @FindBy(css = ".visible-md [name='requiredAttributes[name]']")
    private WebElement signUpNameField;

    @FindBy(css = ".visible-md [name='password']")
    private WebElement signUpPasswordField;

    @FindBy(css = ".visible-md [name='signUpButton']")
    private WebElement signUpButtonForm;


    @Step
    public String getAlertText (){
        waitElementsDisplay(alertText);
        return alertText.getText();
    }
    @Step
    public String getValidationEmailText(){
        String message = emailField.getAttribute("validationMessage");
        return message;
    }
    @Step
    public String getValidationPasswordText(){
        String message = passwordField.getAttribute("validationMessage");
        return message;
    }
    @Step
    public void loginUser(String user, String pass){
        log().info("Username Is " + user);
        emailField.sendKeys(user);
        log().info("Password Is " + pass);
        passwordField.sendKeys(pass);
    }
    @Step
    public void clickSignInButton(){
        buttonSignIn.click();
    }

    @Step
    public String getLoginFormText(){
        waitElementsDisplay(loginFormText);
        return loginFormText.getText();
    }

    @Step
    public void clickSignUpButton(){
        signUpButton.click();
    }


    @Step
    public void signUpUser(String user,String name, String pass){
        waitElementsDisplay(signUpEmailField);
        log().info("Username Is " + user);
        signUpEmailField.sendKeys(user);
        log().info("Password Is " + pass);
        signUpNameField.sendKeys(name);
        signUpPasswordField.sendKeys(pass);
    }

    @Step
    public void clickSignUpButtonForm(){
        signUpButtonForm.click();
    }


}
