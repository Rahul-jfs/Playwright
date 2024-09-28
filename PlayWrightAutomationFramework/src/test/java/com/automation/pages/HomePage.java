package com.automation.pages;

import com.microsoft.playwright.Locator;

public class HomePage extends BasePage{

    Locator homePageTitle;

    public HomePage(){
        homePageTitle = page.locator("//span/h6");
    }

    public boolean isHomePageDisplayed() {
        return homePageTitle.textContent().equals("Dashboard");
    }
}