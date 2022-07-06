package com.upgenix.pages;

import com.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Page {

    public Logout_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "oe_topbar_name")
    public WebElement usernameIcon;

    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement logOutBtn;

    @FindBy(className = "modal-title")
    public WebElement sessionExpiredMessage;


}
