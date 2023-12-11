package com.qa.PageObjects.SSOPage;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends GeneralObject {
    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']//a[.='Forgot your password?']")
    private WebElement goToForgotPasswordButton;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(css = "[name='reset_my_password']")
    private WebElement resetButton;

    @FindBy(css = "#forgot_password_code")
    private WebElement codeForgotEmailField;

    @FindBy(css = "#new_password")
    private WebElement newPasswordField;

    @FindBy(css = "#confirm_password")
    private WebElement reEnterNewPasswordField;

    @FindBy(css = "[name='reset_password']")
    private WebElement confirmResetButton;

    @FindBy(xpath = "//p[@id='errorMessage']")
    private WebElement wrongCodeAlert;


    @Step
    public void clickGoToForgotPassword(){
        waitElementsDisplay(goToForgotPasswordButton);
        goToForgotPasswordButton.click();
    }

    @Step
    public void inputEmailField(String email){
        waitElementsDisplay(usernameField);
        usernameField.sendKeys(email);
    }

    @Step
    public String getValidationEmailText(){
        String message = usernameField.getAttribute("validationMessage");
        return message;
    }

    @Step
    public String getValidationCodeText(){
        String message = codeForgotEmailField.getAttribute("validationMessage");
        return message;
    }

    @Step
    public String getValidationPasswordText(){
        String message = newPasswordField.getAttribute("validationMessage");
        return message;
    }

    @Step
    public String getWrongCodeAlert(){
        waitElementsDisplay(wrongCodeAlert);
        return wrongCodeAlert.getText();
    }

    @Step
    public boolean checkButtonDisabled(){
        waitElementsDisplay(confirmResetButton);
        return confirmResetButton.isEnabled();
    }

    @Step
    public void clickResetButton(){
        waitElementsDisplay(resetButton);
        resetButton.click();
    }

    @Step
    public void inputCodeForgotEmailField(String code){
        waitElementsDisplay(codeForgotEmailField);
        codeForgotEmailField.sendKeys(code);
    }

    @Step
    public void inputNewPasswordField(String pass){
        waitElementsDisplay(newPasswordField);
        newPasswordField.sendKeys(pass);
    }

    @Step
    public void inputReEnterNewPasswordField(String reEnter){
        waitElementsDisplay(reEnterNewPasswordField);
        reEnterNewPasswordField.sendKeys(reEnter);
    }

    @Step
    public void clickConfirmReset(){
        waitElementsDisplay(confirmResetButton);
        confirmResetButton.click();
    }

}
