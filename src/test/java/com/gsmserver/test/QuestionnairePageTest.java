package com.gsmserver.test;

import com.gsmserver.data.DataHelper;
import com.gsmserver.page.MailPage;
import com.gsmserver.page.QuestionnairePage;
import com.gsmserver.page.ValidationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class QuestionnairePageTest extends BaseTest {


    @BeforeEach
    void openHomePage() {
        open("");
    }


    @Test
    void shouldClickRadioButtonTest() {
        new ValidationPage().jumpNewTab(DataHelper.generateFullName());
        QuestionnairePage questionnairePage = new QuestionnairePage();
        MailPage mailPage = new MailPage();
        questionnairePage.fillValues();
        questionnairePage.fillQuestion13("13");
        questionnairePage.fillQuestion17("17");
        questionnairePage.radioButtonRelativesInOurOrganization("Да");
        questionnairePage.radioButtonRelativesPermanentlyAbroad("Нет");
        questionnairePage.uploadFile("Attachments.pdf");
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
        questionnairePage.goToYandexMail();
        mailPage.refresh();
        mailPage.generateTitle(DataHelper.generateFullName());
    }

}
