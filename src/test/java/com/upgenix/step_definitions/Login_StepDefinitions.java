package com.upgenix.step_definitions;

import com.upgenix.pages.Login_Page;
import com.upgenix.utilities.BrowserUtils;
import com.upgenix.utilities.ConfigurationReader;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {

    Login_Page login_page = new Login_Page();

    @Given("user is on the Upgenix login page")
    public void user_is_on_the_upgenix_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_username_and_valid_password(String username, String password) {
        login_page.usernameInputBox.sendKeys(username);
        login_page.passwordInputBox.sendKeys(password);
    }

    @When("user clicks to {string} button")
    public void user_clicks_to_button(String loginBtn) {
        login_page.logInBtn.click();
        BrowserUtils.sleep(2);
    }

    @Then("user should see the title is {string}")
    public void user_should_see_the_title_is(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

//

    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        login_page.usernameInputBox.sendKeys(username);
        login_page.passwordInputBox.sendKeys(password);
        login_page.logInBtn.click();
    }

    @Then("user should see {string} message displayed")
    public void user_should_see_message_displayed(String message) {
        Assert.assertEquals(message, login_page.wrongLoginPasswordMsg.getText());

    }

    //

    @When("user enters {string} or {string}")
    public void user_enters_username_or_password_is_empty(String username, String password) {
        login_page.usernameInputBox.sendKeys(username);
        login_page.passwordInputBox.sendKeys(password);
        login_page.logInBtn.click();


    }

    @Then("user should see {string} message is displayed")
    public void user_should_see_message_is_displayed(String message) {
        String message1 = login_page.usernameInputBox.getAttribute("validationMessage");
        String message2 = login_page.passwordInputBox.getAttribute("validationMessage");
        System.out.println(message1);
        System.out.println(message2);
        Assert.assertTrue(message1.equals(message) || message2.equals(message));
    }

    @When("user clicks {string} link")
    public void user_clicks_link(String link) {
        login_page.resetPasswordLink.click();

    }

    //

    @When("user enters password, user should see the password in bullet signs by default")
    public void user_enters_password_user_should_see_the_password_in_bullet_signs_by_default() {
        Assert.assertTrue(login_page.bulletPasswordVerify.isDisplayed());
    }

    @When("user enters valid {string} and valid {string} and press Enter key")
    public void user_enters_valid_username_and_valid_password_and_press_enter_key(String username, String password) {
        login_page.usernameInputBox.sendKeys(username + Keys.ENTER);
        login_page.passwordInputBox.sendKeys(password + Keys.ENTER);
    }


}
