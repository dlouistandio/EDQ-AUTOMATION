package com.qa.PageObjects.SSOPage;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends GeneralObject {
    WebDriver driver;

    public SignUpPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//a[.='Sign up']")
    private WebElement goToSignUpButton;

    @FindBy(css = ".visible-md [name='username']")
    private WebElement usernameField;

    @FindBy(css = ".visible-md [name='requiredAttributes[name]']")
    private WebElement nameField;

    @FindBy(css = ".visible-md [name='password']")
    private WebElement passwordField;

    @FindBy(css = ".visible-md [name='signUpButton']")
    private WebElement signUpButton;

    @FindBy(xpath = "//p[@id='confirmMessage']")
    private WebElement successVerifyText;


    @Step
    public void clickGoToSignUpForm(){
        waitElementsDisplay(goToSignUpButton);
        goToSignUpButton.click();
    }

    @Step
    public void inputUsernameField(String username){
        waitElementsDisplay(usernameField);
        usernameField.sendKeys(username);
    }

    @Step
    public boolean checkButtonDisabled(){
        waitElementsDisplay(signUpButton);
        return signUpButton.isEnabled();
    }

    @Step
    public String getEmail(){
        waitElementsDisplay(usernameField);
       return usernameField.getText();
    }

    @Step
    public String getEmailAlert(){
        String message = usernameField.getAttribute("validationMessage");
        return message;
    }

    @Step
    public String getNameAlert(){
        String message = nameField.getAttribute("validationMessage");
        return message;
    }

    @Step
    public String getSuccessVerifyText(){
        return successVerifyText.getText();
    }

    @Step
    public void inputNameField(String name){
        waitElementsDisplay(nameField);
        nameField.sendKeys(name);
    }

    @Step
    public void inputPasswordField(String pass){
        waitElementsDisplay(passwordField);
        passwordField.sendKeys(pass);
    }

    @Step
    public void clickSignUpButton(){
        waitElementsDisplay(signUpButton);
        signUpButton.click();
    }

    @Step
    public String getEmailValue(){
        return usernameField.getAttribute("value");
    }

}
