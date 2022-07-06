package com.upgenix.step_definitions;

import com.upgenix.pages.Login_Page;
import com.upgenix.pages.Logout_Page;
import com.upgenix.utilities.ConfigurationReader;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_StepDefinitions {

    Login_Page login_page = new Login_Page();
    Logout_Page logout_page = new Logout_Page();

    @Given("user is on the Upgenix home page")
    public void user_is_on_the_upgenix_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        login_page.usernameInputBox.sendKeys(ConfigurationReader.getProperty("username"));
        login_page.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        login_page.logInBtn.click();
    }

    @When("user clicks to {string} icon")
    public void user_clicks_to_icon(String usernameIcon) {
        logout_page.usernameIcon.click();
    }

    @When("user clicks to {string} dropdown")
    public void user_clicks_to_logOut_dropdown(String logOutBtn) {
        logout_page.logOutBtn.click();
    }

    @When("user clicks to step back button")
    public void user_clicks_to_step_back_button() {
        Driver.getDriver().navigate().back();
    }

    @Then("user should see {string} displayed")
    public void user_should_see__message_displayed(String sessionExpiredMessage) {
        Assert.assertEquals(sessionExpiredMessage, logout_page.sessionExpiredMessage.getText());
    }


}
