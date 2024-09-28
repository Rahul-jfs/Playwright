package com.automation;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OrangeHRM {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.navigate("https://opensource-demo.orangehrmlive.com/");

        Locator usernameInput = page.getByPlaceholder("Username");
        usernameInput.fill("Admin");

        Locator passwordInput = page.getByPlaceholder("Password");
        passwordInput.fill("admin123");

        page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Path.of("./target/screenshot.png")));

        page.screenshot(new Page.ScreenshotOptions().setMask(List.of(usernameInput)).setPath(Path.of("./target/screenshot1.png")));
        page.screenshot(new Page.ScreenshotOptions().setMask(List.of(usernameInput, passwordInput)).setMaskColor("Black").setPath(Path.of("./target/screenshot2.png")));

        usernameInput.screenshot(new Locator.ScreenshotOptions().setPath(Path.of("./target/s1.png")));

        page.locator("//button[@type='submit']").click();
        assertThat(page.locator("//h6")).isVisible();

        Page newPage = context.newPage();


        newPage.navigate("https://opensource-demo.orangehrmlive.com/");

//        Locator usernameInput1 = newPage.getByPlaceholder("Username");
//        usernameInput1.fill("Admin");
//
//        Locator passwordInput1 = newPage.getByPlaceholder("Password");
//        passwordInput1.fill("admin123");
//
//        newPage.locator("//button[@type='submit']").click();

    }

}
