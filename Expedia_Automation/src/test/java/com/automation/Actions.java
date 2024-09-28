package com.automation;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Actions {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
//        page.navigate("https://the-internet.herokuapp.com/inputs");
//
//        page.locator("//input[@type='number']").fill("33");
//
//
//        page.navigate("https://the-internet.herokuapp.com/checkboxes");
//        List<Locator> checkBoxes = page.locator("//input[@type='checkbox']").all();
//        for(Locator checkBox: checkBoxes){
//            if(!checkBox.isChecked()){
//                checkBox.check();
//            }else {
//                checkBox.uncheck();
//            }
//        }
//
//
//        page.navigate("https://the-internet.herokuapp.com/dropdown");
//        page.locator("//select[@id='dropdown']").selectOption("Option 2");
//        page.locator("//select[@id='dropdown']").selectOption(new SelectOption().setLabel("Option 1"));
////        page.locator("//select[@id='dropdown']").selectOption(new String[] {"Option 1", "Option 2"});
//
//        page.navigate("https://the-internet.herokuapp.com/add_remove_elements/");
//        page.locator("//div[@class='example']/button").dblclick();
//        System.out.println(page.locator("//div[@id='elements']/button").all().size());
//
//        page.navigate("https://the-internet.herokuapp.com/context_menu");
//        page.locator("//div[@id='hot-spot']").click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));

        page.navigate("https://the-internet.herokuapp.com/login");
        page.locator("//input[@name='username']").pressSequentially("Hello World");
//        playwright.close();
    }
}
