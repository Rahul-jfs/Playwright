package com.automation;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class APITesting {

    public static void main(String[] args) {

        String body = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        Playwright playwright = Playwright.create();

        APIRequest request = playwright.request();
        APIRequestContext requestContext = request.newContext();

        RequestOptions options = RequestOptions.create();

        options.setData(body);
        options.setHeader("Content-Type", "application/json");

        APIResponse response = requestContext.post("https://restful-booker.herokuapp.com/auth", options);
        System.out.println("text: "+response.text());
        System.out.println("status: "+ response.status());
        System.out.println("status text: "+ response.statusText());
        System.out.println("url: "+ response.url());

//        token : 9ed97a707296fed


        playwright.close();
    }

}
