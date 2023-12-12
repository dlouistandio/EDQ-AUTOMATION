package com.qa.PageObjects.DashboardVendor;

import com.qa.Components.GeneralObject;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardVendor extends GeneralObject {
    WebDriver driver;

    public DashboardVendor(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[.='My Schools']")
    private WebElement mySchoolText;

    @FindBy(xpath = "//a[.='My Schools']")
    private WebElement btnMySchool;

    @FindBy(xpath = "//a[.='Create New School']")
    private WebElement btnNewSchool;

    @FindBy(xpath = "//a[.='Settings']")
    private WebElement btnSetting;

    @FindBy(xpath = "//a[.='Logout']")
    private WebElement btnLogout;

    @FindBy(css = ".grid > a:nth-of-type(1)")
    private WebElement cardSchool;

    @FindBy(css = "[aria-haspopup='menu']")
    private WebElement userProfile;

    @FindBy(css = ".block[href='/logout']")
    private WebElement logoutDropdownButton;

    @Step
    public String getMySchoolText(){
        waitElementsDisplay(mySchoolText);
        return mySchoolText.getText();
    }

    @Step
    public void goToSchool(){
        waitElementsDisplay(cardSchool);
        cardSchool.click();
    }

    @Step
    public void clickCreateNewSchool(){
        waitElementsDisplay(btnNewSchool);
        btnNewSchool.click();
    }

    @Step
    public void clickLogoutButtonDashboard(){
        waitElementsDisplay(btnLogout);
        btnLogout.click();
    }

    @Step
    public void clickLogoutButtonDropdown(){
        waitElementsDisplay(userProfile);
        userProfile.click();
        waitElementsDisplay(logoutDropdownButton);
        logoutDropdownButton.click();
    }


}
