package com.gsmserver.test;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class QuestionnairePageTest extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("");
    }

}
