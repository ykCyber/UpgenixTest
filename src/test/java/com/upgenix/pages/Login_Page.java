package com.upgenix.pages;

import com.upgenix.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    public Login_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "login")
    public WebElement usernameInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement logInBtn;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement wrongLoginPasswordMsg;

    @FindBy(className = "field-password")
    public WebElement field;

    @FindBy(linkText = "Reset Password")
    public WebElement resetPasswordLink;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement bulletPasswordVerify;


}
