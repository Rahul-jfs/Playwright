package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Then("verify home page is displayed")
    public void verify_home_page_is_displayed() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }


}
