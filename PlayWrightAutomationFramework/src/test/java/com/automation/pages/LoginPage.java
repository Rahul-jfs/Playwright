package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;

public class LoginPage extends BasePage{

    Locator usernameInput;
    Locator passwordInput;
    Locator loginBtn;

    public LoginPage(){
        usernameInput = page.getByPlaceholder("Username");
        passwordInput = page.getByPlaceholder("Password");
        loginBtn = page.locator("//button[@type='submit']");
    }

    public void openWebsite() {
        page.navigate(ConfigReader.getConfigValue("application.url"));
    }

    public void enterLoginCredentials(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
