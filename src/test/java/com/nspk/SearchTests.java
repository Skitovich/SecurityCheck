package com.nspk;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

    }
}
