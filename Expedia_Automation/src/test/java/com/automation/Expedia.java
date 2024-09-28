package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.nio.file.Path;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Expedia {
    public static void main(String[] args) {

        String fromDate = "19 September 2024";
        String toDate = "24 September 2024";
        int noOfAdults = 3;
        int noOfChildren = 3;
        String[] childrenAge = {"15", "13", "9"};

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.expedia.com/");

        System.out.println(page.locator("text=Cars"));

        page.screenshot(new Page.ScreenshotOptions().setPath(Path.of("./target/expedia.png")));
        page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Path.of("./target/expedia1.png")));

        page.waitForLoadState();
        page.locator("//h2[text()='Last-minute weekend deals']").isVisible();
        page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Path.of("./target/expedia2.png")));
        assertThat(page.locator("//a[@data-testid='header-brand-logo-anchor']")).isVisible();

//        page.locator("//a/span[text()='Flights']").click();
//        page.locator("//button[@aria-label='Leaving from']").click();
//
//        Locator leavingFrom = page.getByPlaceholder("Leaving from");
//        leavingFrom.fill("Hydrabad");
////        page.locator("//button[@data-stid='origin_select-result-item-button']").waitFor(new Locator.WaitForOptions().setTimeout(60000));
//        page.locator("(//button[@data-stid='origin_select-result-item-button'])[1]").click();
//
//        page.locator("//button[@aria-label='Going to']").click();
//        Locator goingTo = page.getByPlaceholder("Going to");
//        goingTo.fill("Delhi");
//        page.locator("(//button[@data-stid='destination_select-result-item-button'])[1]").click();
//
//        page.locator("//button[@data-testid='uitk-date-selector-input1-default']").click();
//        page.locator("//div[contains(@aria-label,'" + fromDate + "')]/following-sibling::div").click();
//        page.locator("//div[contains(@aria-label,'" + toDate + "')]/following-sibling::div").click();
//
//        page.locator("//section//button[text()='Done']").click();
//
//        page.locator("//button[contains(@aria-label,'Travelers')]").click();
//
//        int i = 0;
//        while (i < noOfAdults-1) {
//            page.locator("//input[@id='traveler_selector_adult_step_input']/following-sibling::button").click();
//            i++;
//        }
//
//        int j = 0;
//        while (j < noOfChildren) {
//            page.locator("//input[@id='traveler_selector_children_step_input']/following-sibling::button").click();
//            j++;
//        }
//
//        int child = 0;
//        while (child < noOfChildren) {
//            page.locator("//select[@id='age-traveler_selector_children_age_selector-"+child+"']").selectOption(new SelectOption().setLabel(childrenAge[child]));
//            child++;
//        }
//
//        page.locator("//button[@id='travelers_selector_done_button']").click();
//        page.locator("//button[@id='search_button']").click();
//
//
//        page.locator("(//li[@data-test-id='offer-listing'])[1]").waitFor(new Locator.WaitForOptions().setTimeout(60000));
//        assertThat(page.locator("(//li[@data-test-id='offer-listing'])[1]")).isVisible();
//        page.locator("//select[@id='sort-filter-dropdown-SORT']").selectOption(new SelectOption().setLabel("Price (lowest to highest)"));
//
//        page.locator("(//li[@data-test-id='offer-listing'])[1]").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
//
//        System.out.println("Price in list: "+page.locator("(//div[@data-test-id='price-column'])[1]//section/span[2]").innerText());
//        System.out.println("Price in tab: "+ page.locator("(//button[@aria-selected='true']//span)[2]").textContent());

        page.close();
        playwright.close();
    }
}
