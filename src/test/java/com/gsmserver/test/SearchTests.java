package com.gsmserver.test;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.page.HomePage;
import com.gsmserver.page.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @BeforeEach
    void openHomePage() {
        open("https://gsmserver.com/");
    }

    @BeforeAll
    static void setUp() {
        Configuration.browser = "firefox";
//        Configuration.startMaximized = true;
    }

    @Test
    void searchProductByTitle() {
        
        var productName = "Z3X Easy-Jtag Plus Full Upgrade Set";
        var productId = "872996";

        $("[name='searchword']").val(productName).pressEnter();
        $(".search-title-highlight").shouldHave(text(productName));

        findElementById(productId).$(".product-info_title").shouldHave(text(productName));
        findElementById(productId).$("[data-action-click='site.cart.add']").click();
        findElementById(productId).$(".in-cart").shouldBe(visible).click();

        $("[id='cart']").shouldHave(text("Cart"));
        findElementById(productId).$(".product-title").shouldHave(text(productName));
        $$("#cart tr[data-product-id]").shouldHaveSize(1);

    }

    @Test
    void oloTest() {
        var productName = "Z3X Easy-Jtag Plus Full Upgrade Set";
        
        new HomePage().searchFor(productName);
        var actualSearchResultTitle = new SearchResultPage().getSearchResultTitle();
        Assertions.assertEquals(productName,actualSearchResultTitle);
    }

    private SelenideElement findElementById(String productId) {
        return $(by("data-product-id", productId));
    }
}
