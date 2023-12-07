package com.qa.PageObjects.SchoolWebPage;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = " //a[.='Sign Out']")
    private WebElement signOutButton;

    @FindBy(xpath = " //input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = " //input[@id='password']")
    private WebElement passwordField;

    @FindBy(css = ".ant-form > div:nth-of-type(1) .ant-form-item-explain-error")
    private WebElement emailAlert;

    @FindBy(css = ".ant-form > div:nth-of-type(2) .ant-form-item-explain-error")
    private WebElement passwordAlert;

    @FindBy(xpath = "//Button[contains(text(),'Sign In')]")
    private WebElement signinButton;

    @FindBy(xpath = "//h2[@class='label']")
    private WebElement formLoginText;

    @FindBy(css = ".text-xl.mb-0")
    private WebElement webHeaderText;

    @FindBy(css = ".ant-alert")
    private WebElement invalidCredText;

    @FindBy(xpath = "//img[@alt='avatar']")
    private WebElement profileMenu;



    @Step
    public void clickLoginButton(){
        waitElementsDisplay(loginButton);
        loginButton.click();
    }

    @Step
    public void inputEmailNPassword(String email, String pass){
        waitElementsDisplay(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
    }

    @Step
    public String getAlertEmail(){
        waitElementsDisplay(emailAlert);
        return emailAlert.getText();
    }

    @Step
    public String getAlertPassword(){
        waitElementsDisplay(passwordAlert);
        return passwordAlert.getText();
    }

    @Step
    public String getLoginButtonText(){
        waitElementsDisplay(loginButton);
        return loginButton.getText();
    }

    @Step
    public String getAlertInvalidCred(){
        waitElementsDisplay(invalidCredText);
        return invalidCredText.getText();
    }

    @Step
    public String getHeaderWeb(){
        waitElementsDisplay(webHeaderText);
        return webHeaderText.getText();
    }


    @Step
    public String getFormLoginText(){
        waitElementsDisplay(formLoginText);
        return formLoginText.getText();
    }

    @Step
    public void clickSigninButton(){
        signinButton.click();
    }

    @Step
    public void moveToProfile(){
        Actions action = new Actions(driver);
        waitElementsDisplay(profileMenu);
        action.moveToElement(profileMenu).perform();
    }

    @Step
    public void clickSignOutButton(){
        waitElementsDisplay(signOutButton);
        signOutButton.click();
    }

}
