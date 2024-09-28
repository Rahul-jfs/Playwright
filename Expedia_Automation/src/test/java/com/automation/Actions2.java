package com.automation;

import com.microsoft.playwright.*;

import java.util.List;

public class Actions2 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
//        page.navigate("https://www.globalsqa.com/demo-site/draganddrop/");
//
//        FrameLocator frameLocator = page.frameLocator("//iframe[@class='demo-frame lazyloaded']");
//
//        List<Locator> draggableImg = frameLocator.locator(".ui-draggable").all();
//
//        for(Locator eachImg : draggableImg){
//            eachImg.dragTo(frameLocator.locator("div#trash"));
//        }

        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.locator("(//li/button)[1]").click();
        page.onDialog(dialog -> {
            System.out.println("f11");
            dialog.accept();
            System.out.println("f11");
        });
        page.locator("(//li/button)[2]").click();
        page.onDialog(dialog -> {
            System.out.println("f2");
            dialog.dismiss();
        });
        page.locator("(//li/button)[2]").click();
        page.onDialog(dialog -> {
            dialog.dismiss();
        });

        page.navigate("http://the-internet.herokuapp.com/javascript_alerts");

        page.waitForLoadState();
        page.onDialog(dialog -> {
            System.out.println("Dialog type: " + dialog.type());
            System.out.println("Dialog message: " + dialog.message());

            switch (dialog.type()) {
                case "alert":
                    System.out.println("Handling alert dialog");
                    dialog.accept();
                    break;
                case "confirm":
                    System.out.println("Handling confirm dialog");
                    dialog.accept();
                    break;
                case "prompt":
                    System.out.println("Handling prompt dialog");
                    dialog.accept("ust");
                    break;
                default:
                    System.out.println("Unknown dialog type: " + dialog.type());
                    break;
            }
        });

        page.getByText("Click for JS Alert").click();

        page.getByText("Click for JS Confirm").click();

        page.getByText("Click for JS Prompt").click();

    }

}
