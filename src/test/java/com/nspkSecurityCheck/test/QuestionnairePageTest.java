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

    /*
    Проверить, что при отправке корректно заполненной анкете на указанный в настройках
    адрес  hr получает письмо  с анкетой в doc файле, pdf файле и вложения (если были прикреплены кандидатом в анкете)
    */

    @Test
    void shouldEnterToMailByHeaderTestAndCheckAttach() {
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
        mailPage.checkAttachments(attachJpg);
    }

    /*
    При отправке электронного письма темой письма является: «Анкета – ФИО_Кандидата», где ФИО_Кандидата –
    фамилия, имя, отчество кандидата из анкеты.
     */

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
        mailPage.checkAttachments(attachJpg);
    }

    // Проверить, что максимальная длина каждого поля = 2000 символов
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


    /* Проверить, что можно успешно создать более, чем 10 строк
     и при этом корректно работает пагинация по 10 строк в таблицах
    1) 13
    2) 14
    3) 17
    */
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

    // Проверить возможность добавления одной записи в таблицу
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
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
    }

    //Проверить возможность добавления нескольких  записей  в таблицу
    @Test
    void shouldAddSeveralValueEachTableQuestionAndSubmitFormTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.fillGeneratedValues();
        questionnairePage.fillQuestion13(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.fillQuestion13(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.fillQuestion14(minusYearsFromNow, dateFormatYear);
        questionnairePage.fillQuestion14(minusYearsFromNow, dateFormatYear);
        questionnairePage.fillQuestion17(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.fillQuestion17(minusYearsFromNow, dateFormatMonthYear);
        questionnairePage.radioButtonRelativesInOurOrganization();
        questionnairePage.radioButtonRelativesPermanentlyAbroad();
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
    }

    // Проверить возможность удаления одной записи в таблице
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

    // Проверить возможность редактирования  записи в таблице
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

    /* Дополнительные сведения: успешная загрузка  отдельных файлов определенных форматов, которые задаются в настройках
    1) .doc
    2) .docx
    3) .xls
    4) .xlsx
    5)  .pdf
    6)  .png
    7)  .jpg
    8) .jpeg
     */
    @Test
    void shouldAddAllExtensionsTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.openLink(getAuthInfo);
        val questionnairePage = new QuestionnairePage();
        questionnairePage.uploadAllExtensions(attachDocx, attachPng, attachJpg, attachXlsx, attachPdf);
    }

    /*
    Проверить, что при истечении сессии и попытке отправить заполненную анкету:
    1) анкета не отправляется
    2) пользователю отображается алерт о том, что время жизни сессии истекло
    */
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
