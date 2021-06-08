package com.gsmserver.test;

import com.gsmserver.data.DataHelper;
import com.gsmserver.page.MailPage;
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
        new ValidationPage().openLink(DataHelper.generateFullName());
        QuestionnairePage questionnairePage = new QuestionnairePage();
        MailPage mailPage = new MailPage();
        questionnairePage.fillValues();
        questionnairePage.fillQuestion13("13");
        questionnairePage.fillQuestion17("17");
        questionnairePage.radioButtonRelativesInOurOrganization("Да");
        questionnairePage.radioButtonRelativesPermanentlyAbroad("Нет");
        questionnairePage.uploadFile("Attachments.jpg");
        questionnairePage.checkboxClick();
        questionnairePage.submitClick();
        mailPage.goToYandexMail();
        mailPage.loginYandexMail();
        mailPage.generateTitle(DataHelper.generateFullName());
    }



//    @Test
//    void shouldFillFirstCardSuccessfully() {
//        val loginPage = new LoginPageV1();
//        val authInfo = DataHelper.getAuthInfo();
//        val verificationPage = loginPage.validLogin(authInfo);
//        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
//        val dashboardPage = verificationPage.validVerify(verificationCode);
//        val cardsPage = dashboardPage.depositMoneyToCard(1);
//        cardsPage.fillFirstCard(2000);
//        dashboardPage.cardBalanceCheck();
//    }




}
