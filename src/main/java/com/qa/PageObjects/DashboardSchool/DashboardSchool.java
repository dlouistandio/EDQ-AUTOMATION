package com.qa.PageObjects.DashboardSchool;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;


public class DashboardSchool extends GeneralObject {
    WebDriver driver;

    public DashboardSchool(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement dashboardText;


    @FindBy(xpath = "//div[@class='section-header__title']")
    private WebElement createNewProductText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement nextButton;

    @FindBy(css = ".ant-btn")
    private WebElement dateOkButton;

    @FindBy(css = "[placeholder='Select date']")
    private WebElement dateField;


    @FindBy(xpath = "//div[@class='ant-col ant-col-xs-12 ant-col-sm-12']/button[@class='sc-qRumB gyLfCK btn btn-primary']")
    private WebElement buttonCreate;

    public String createNewProductText(){
        return createNewProductText.getText();
    }

    public void chooseMenu(String menu) {
        waitElementsDisplay(dashboardText);
        String xPathSelectedMenu =  "//a[@href='"+menu+"']";
        WebElement menuContent = driver.findElement(By.xpath(xPathSelectedMenu));
        menuContent.click();
    }

    public void chooseCourseType(String menu) {
        String xPathSelectedMenu =  "//div[@class='course-type__form']//div["+menu+"]/label[@class='radio-group']";
        WebElement menuContent = driver.findElement(By.xpath(xPathSelectedMenu));
        menuContent.click();
    }

    public void clickNewProductButton(){
        waitElementsDisplay(buttonCreate);
        buttonCreate.click();
    }

    public void setTitleCourse(String nameCourse){
        waitElementsDisplay(titleField);
        titleField.sendKeys(nameCourse);
    }

    public void setDateEvent(){
        dateField.click();
        String xPathSelectedMenu =  "//tr[3]//div[.='15']";
        WebElement datePicker = driver.findElement(By.xpath(xPathSelectedMenu));
        waitElementsDisplay(datePicker);
        datePicker.click();
        dateOkButton.click();
    }

    public void createNewCourse(){
        createProductButton.click();
    }

    public void modalNewProcuctMenu(){
        waitElementsDisplay(createNewProductText);
        createBlankProductButton.click();
        nextButton.click();
    }
}
