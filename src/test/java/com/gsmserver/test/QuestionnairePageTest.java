package com.gsmserver.test;

import com.gsmserver.data.DataHelper;
import com.gsmserver.page.QuestionnairePage;
import com.gsmserver.page.ValidationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class QuestionnairePageTest extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("");
    }

    @Test
    void shouldClickRadioButtonTest() {
        new ValidationPage().
                jumpNewTab(DataHelper.generateFullName());
        new QuestionnairePage().
                fillForm(DataHelper.generateDataCandidate());
    }

}
