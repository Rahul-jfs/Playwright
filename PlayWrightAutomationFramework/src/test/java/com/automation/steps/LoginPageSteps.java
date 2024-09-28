package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user opens website")
    public void user_opens_website() {
        loginPage.openWebsite();
    }
    @When("user enters valid credentials as {string} and {string}")
    public void user_enters_valid_credentials_as_and(String username, String password) {
        loginPage.enterLoginCredentials(ConfigReader.getConfigValue(username), ConfigReader.getConfigValue(password));
    }
    @When("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginBtn();
    }

}
