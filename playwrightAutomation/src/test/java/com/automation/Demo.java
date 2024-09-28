package com.automation;

import com.microsoft.playwright.*;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Demo {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");

        assertThat(page).hasURL("https://www.saucedemo.com/");

        Locator heading = page.locator(".login_logo");
        assertThat(heading).hasText("Swag Labs");

        Locator usernameInp = page.locator("#user-name");
        Locator passwordInp = page.locator("#password");
        Locator loginBtn = page.locator("#login-button");

        usernameInp.fill("standard_user");
        passwordInp.fill("secret_sauce");
        loginBtn.click();

        Locator productPageTitle = page.locator(".title");
        assertThat(productPageTitle).hasText("Products");

        Locator firstProductAddToCartBtn = page.locator("#add-to-cart-sauce-labs-backpack");
        Locator firstPrice = page.locator(".inventory_item_price");
        Locator productsName = page.locator(".inventory_item_name");

        List<String> proPrice = firstPrice.allInnerTexts();
        List<String> proNames = productsName.allInnerTexts();
        System.out.println(proPrice);
        System.out.println(productsName.allInnerTexts());

        firstProductAddToCartBtn.click();

        Locator cartBadge = page.locator(".shopping_cart_badge");
        assertThat(cartBadge).hasText("1");

        Locator cartIcon = page.locator(".shopping_cart_link");
        cartIcon.click();

        Locator cartItems = page.locator(".cart_item a");

        System.out.println("Products in cart: "+ cartItems.allInnerTexts());

        Locator checkOutBtn = page.locator("#checkout");

        assertThat(cartItems).hasText(proNames.get(0));
        assertThat(checkOutBtn).isVisible();

        checkOutBtn.click();

        Locator firstNameInput = page.getByPlaceholder("First Name");
        Locator lastNameInput = page.getByPlaceholder("Last Name");
        Locator zipCode = page.locator("#postal-code");
        Locator continueBtn = page.locator("#continue");

        assertThat(firstNameInput).isVisible();
        assertThat(continueBtn).isVisible();

        firstNameInput.fill("Kumar");
        lastNameInput.fill("Hari");
        zipCode.fill("123123");

        continueBtn.click();

        System.out.println("----------- CheckOut overview -----------");
        System.out.println(page.locator(".inventory_item_name").textContent());
        System.out.println(page.locator(".inventory_item_desc").textContent());
        System.out.println("Payment Information : "+ page.locator("//div[@data-test='payment-info-value']").textContent());
        System.out.println("Shipping info : "+ page.locator("//div[@data-test='shipping-info-value']").textContent());
        System.out.println(page.locator("//div[@data-test='total-info-label']").textContent());
        System.out.println(page.locator("//div[@data-test='subtotal-label']").textContent());
        System.out.println(page.locator("//div[@data-test='tax-label']").textContent());
        System.out.println(page.locator("//div[@data-test='total-label']").textContent());

        playwright.close();
    }
}
