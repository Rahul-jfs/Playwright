package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Demo {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.ebay.com/");

        page.getByTitle("Advanced Search").click();

        assertThat(page.locator(".adv-form")).isVisible();

        page.locator("//label[text()='Enter keywords or item number']/following-sibling::span/input").fill("Java");

        page.locator("//label[text()='In this category']/following-sibling::div//select").selectOption(new SelectOption().setLabel("Books & Magazines"));

        page.locator("//label[text()='Min price']/following-sibling::span[@class='textbox']/input").fill("0");
        page.locator("//label[text()='Max price']/following-sibling::span[@class='textbox']/input").fill("100");
        page.locator("//legend[text()='Condition']/following-sibling::div//label[contains(text(),'New')]").click();

        page.locator("//label[contains(text(),'Available to')]").click();

        page.locator("//label[contains(text(),'Available to')]/following-sibling::span//select").selectOption(new SelectOption().setLabel("India"));

        page.locator("//div[@class='adv-form__actions']//button[text()='Search']").click();
        List<Locator> results = page.locator("//div[@id='srp-river-main']//ul/li[@data-viewport]").all();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Locator> resultNames = page.locator("//ul/li[@data-viewport]//span[@role='heading']").all();
        System.out.println("size: "+ resultNames.size());
        resultNames.forEach(name -> System.out.println(name.innerText()));


        Page newTab = page.waitForPopup(() -> {
            resultNames.get(0).click();
        });


        newTab.waitForLoadState();

        System.out.println(newTab.locator("//div[@class='x-price-primary']//span").isVisible());
        System.out.println(newTab.locator("//div[@class='x-price-primary']//span").innerText());
        System.out.println(newTab.locator("//div[@class='x-price-primary']//span").isVisible());
        newTab.close();
        page.close();

        System.out.println("done");
    }

}
