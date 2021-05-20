package com.nspk;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        var searchQuery = "Цифровой осциллограф RIGOL DS1102E";
        $("[name='searchword']").val(searchQuery).pressEnter();
        $(".search-title-highlight").shouldHave(Condition.text(searchQuery));

    }
}
