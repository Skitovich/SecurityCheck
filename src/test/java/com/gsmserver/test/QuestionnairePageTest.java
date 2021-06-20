package com.gsmserver.test;

import com.gsmserver.data.DataHelper;
import com.gsmserver.page.MailPage;
import com.gsmserver.page.QuestionnairePage;
import com.gsmserver.page.ValidationPage;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class QuestionnairePageTest extends BaseTest {
    String attachJpg = "jpg";
    String attachDocx = "docx";
    String attachPng = "png";
    String attachPdf = "pdf";
    String attachXlsx = "xlsx";

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
        questionnairePage.fillQuestion13(minusYearsFromNow, "MM.yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow, "yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow, "MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(attachJpg);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
        mailPage.goToYandexMail();
        mailPage.checkLoginMailAndCheckAttach(attachJpg);
    }


    @Test
    void shouldSuccessfullyPassedValueEveryTextField2000char() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues2000char();
        questionnairePage.fillQuestion13(minusYearsFromNow, "MM.yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow, "yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow, "MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(attachJpg);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
    }

    @Test
    void shouldSuccessfullyPassed10ValuesEveryTableQuestion() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow + 1, "MM.yyyy");
        questionnairePage.fillQuestion13(minusYearsFromNow + 2, "MM.yyyy");
        questionnairePage.fillQuestion13(minusYearsFromNow + 3, "MM.yyyy");
        questionnairePage.fillQuestion13(minusYearsFromNow + 4, "MM.yyyy");
        questionnairePage.fillQuestion13(minusYearsFromNow + 5, "MM.yyyy");
        questionnairePage.fillQuestion13(minusYearsFromNow + 6, "MM.yyyy");
        questionnairePage.fillQuestion13(minusYearsFromNow + 7, "MM.yyyy");
        questionnairePage.fillQuestion13(minusYearsFromNow + 8, "MM.yyyy");
        questionnairePage.fillQuestion13(minusYearsFromNow + 9, "MM.yyyy");
        questionnairePage.fillQuestion13(minusYearsFromNow + 10, "MM.yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 1, "yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 2, "yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 3, "yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 4, "yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 5, "yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 6, "yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 7, "yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 8, "yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 9, "yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow + 10, "yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 1, "MM.yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 2, "MM.yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 3, "MM.yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 4, "MM.yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 5, "MM.yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 6, "MM.yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 7, "MM.yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 8, "MM.yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 9, "MM.yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow + 10, "MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(attachJpg);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
    }

    @Test
    void shouldAddOneValueEachTableQuestionAndSubmitForm() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow, "MM.yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow, "yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow, "MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(attachJpg);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
    }


    @Test
    void shouldEditAndDeleteOneValueEachTableQuestionAndSubmitForm() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fill13QuestionAndEdit(minusYearsFromNow, "MM.yyyy");
        questionnairePage.deleteLine();
        questionnairePage.fill14QuestionAndEdit(minusYearsFromNow, "yyyy");
        questionnairePage.deleteLine();
        questionnairePage.fill17QuestionAndEdit(minusYearsFromNow, "MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(attachJpg);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
    }

    @Test
    void shouldAddAllExtensionsAndSubmitForm() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow, "MM.yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow, "yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow, "MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadAllExtensions(attachPdf, attachJpg, attachDocx, attachPng, attachXlsx);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
    }

    @Test
    void shouldDeclinedByDeadLink() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow, "MM.yyyy");
        questionnairePage.fillQuestion14(minusYearsFromNow, "yyyy");
        questionnairePage.fillQuestion17(minusYearsFromNow, "MM.yyyy");
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(attachJpg);
        questionnairePage.checkboxClick();
        sleep(360000);
        questionnairePage.submitClickByDeadLink();
    }
}
