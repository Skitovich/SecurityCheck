package com.gsmserver.test;


import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("/");

    }


}
