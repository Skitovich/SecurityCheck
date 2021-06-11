package com.gsmserver.test;

import com.gsmserver.data.DataHelper;
import com.gsmserver.page.MailPage;
import com.gsmserver.page.QuestionnairePage;
import com.gsmserver.page.ValidationPage;
import lombok.val;
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
        new ValidationPage().openLink(DataHelper.getFullNameInfo());
        QuestionnairePage questionnairePage = new QuestionnairePage();
        MailPage mailPage = new MailPage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestionNum13(3,"MM.yyyy");
        questionnairePage.fillQuestion17(3,"MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization("Да");
        questionnairePage.radioButtonRelativesPermanentlyAbroad("Нет");
        questionnairePage.uploadFile("Attachments.pdf");
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
        mailPage.goToYandexMail();
        mailPage.loginYandexMail();
        mailPage.refreshInbox();
        mailPage.openMailByTitle();
    }


    @Test
    void shouldEnterToMail() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        val mailPage = new MailPage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestionNum13(3,"mm.yyyy");
        questionnairePage.fillQuestion17(3,"mm.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization("Да");
        questionnairePage.radioButtonRelativesPermanentlyAbroad("Нет");
        questionnairePage.uploadFile("Attachments.pdf");
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
        mailPage.goToYandexMail();
        mailPage.loginYandexMail();
        mailPage.refreshInbox();
        mailPage.openMailByTitle();
    }
}
