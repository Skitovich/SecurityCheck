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

    String fileName = "Attachments.pdf";
    int minusYearsFromNow = 3;


    @BeforeEach
    void openHomePage() {
        open("");
    }

    @Test
    void shouldEnterToMail() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        val mailPage = new MailPage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestionNum13(minusYearsFromNow,"MM.yyyy");
        questionnairePage.fillQuestionNum14(minusYearsFromNow,"yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow,"MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(fileName);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
        mailPage.goToYandexMail();
        mailPage.checkLoginMailAndCheckAttach(fileName);
    }

    @Test
    void shouldEnterToMail1() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        val mailPage = new MailPage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestionNum13(minusYearsFromNow,"MM.yyyy");
        questionnairePage.fillQuestionNum14(minusYearsFromNow,"yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow,"MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(fileName);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
        mailPage.goToYandexMail();
        mailPage.checkLoginMailAndCheckAttach(fileName);
    }
}
