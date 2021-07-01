package com.nspkSecurityCheck.test;

import com.nspkSecurityCheck.data.DataHelper;
import com.nspkSecurityCheck.page.MailPage;
import com.nspkSecurityCheck.page.QuestionnairePage;
import com.nspkSecurityCheck.page.ValidationPage;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;


public class QuestionnairePageTest extends BaseTest {
    String attachJpg = "jpg";
    String attachDocx = "docx";
    String attachPng = "png";
    String attachPdf = "pdf";
    String attachXlsx = "xlsx";
    int minusYearsFromNow = 3;
    String dateFormatMonthYear = "MM.yyyy";
    String dateFormatYear = "yyyy";
    int linkLifetime = 90000;


    @BeforeEach
    void openHomePage() {
        open("");
    }

    @Test
    void shouldEnterToMailByHeaderTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        val mailPage = new MailPage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.fillQuestion14(minusYearsFromNow, dateFormatYear);
        questionnairePage.fillQuestion17(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(attachJpg);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
        mailPage.goToYandexMail();
        mailPage.checkLoginMailAndCheckAttach(attachJpg);
    }


    @Test
    void shouldSuccessfullyPassedValueEveryTextField2000charTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues2000charAndCheckNumOfChar();
        questionnairePage.fillQuestion17(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
    }


    @Test
    void shouldSuccessfullyPassedTenValuesEveryTableQuestionTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fill13QuestionManyTimes(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.fill14QuestionManyTimes(minusYearsFromNow, dateFormatYear);
        questionnairePage.fill17QuestionManyTimes(minusYearsFromNow, dateFormatMonthYear);
    }

    @Test
    void shouldAddOneValueEachTableQuestionAndSubmitFormTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.fillQuestion14(minusYearsFromNow, dateFormatYear);
        questionnairePage.fillQuestion17(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadFile(attachJpg);
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
    }

    @Test
    void shouldAddOneValueEachTableQuestionAndDeleteTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.fillQuestion14(minusYearsFromNow, dateFormatYear);
        questionnairePage.fillQuestion17(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.randomRowDelete();
        questionnairePage.randomRowDelete();
        questionnairePage.randomRowDelete();
    }

    @Test
    void shouldFillOneRowAndEditTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.editRandomRowAndFillsIt();
        questionnairePage.fillQuestion14(minusYearsFromNow, dateFormatYear);
        questionnairePage.editRandomRowAndFillsIt();
        questionnairePage.fillQuestion17(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.editRandomRowAndFillsIt();
    }

    @Test
    void shouldAddAllExtensionsTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.uploadAllExtensions(attachDocx, attachPng, attachJpg, attachXlsx, attachPdf);
    }

    @Test
    void shouldDeclinedByDeadLinkTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.fillQuestion14(minusYearsFromNow, dateFormatYear);
        questionnairePage.fillQuestion17(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.uploadAllExtensions(attachDocx, attachPng, attachJpg, attachXlsx, attachPdf);
        questionnairePage.checkboxClick();
        sleep(linkLifetime);
        questionnairePage.submitClickByDeadLink();
    }
}
