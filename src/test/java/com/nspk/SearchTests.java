package com.nspk;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "firefox";
//        Configuration.startMaximized = true;
    }

    @Test
    void searchProductByTitle() {
        open("https://gsmserver.ru");
        var searchQuery = "Активация Sigma Pack 4";
        $("[name='searchword']").val(searchQuery).pressEnter();
        $(".search-title-highlight").shouldHave(text(searchQuery));
        $(".product-info_title").shouldHave(text(searchQuery));
        sleep(5000);
        $(".product-view-list [data-action-click = 'site.cart.add']").click();
        $("#right-panel-content-wrapper > ul > li:nth-child(1) > div.product-price-wrapper > div.bottom " +
                "> div > div > div.quantity-input > span").shouldBe(visible).click();

        $("[id='cart']").shouldHave(text("Корзина"));


    }
}
