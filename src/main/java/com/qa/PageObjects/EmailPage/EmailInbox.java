package com.qa.PageObjects.EmailPage;

import com.qa.Components.GeneralObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmailInbox extends GeneralObject {
    WebDriver driver;

    public EmailInbox(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
