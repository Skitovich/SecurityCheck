package com.gsmserver.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.data.DataHelper;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MailPage {
    private static final SelenideElement refresh = $x("//span[@data-click-action='mailbox.check']");
    private static final SelenideElement enterMail = $x("//a[contains(@class,'Button-Enter')]");
    private static final SelenideElement login = $x("//input[@id='passp-field-login']");
    private static final SelenideElement password = $x("//input[@id='passp-field-passwd']");
    private static final SelenideElement enter = $x("//button[@type='submit']");
    private static final SelenideElement attachDocx = $x("//span[contains(@title,'kandidat_anketa.docx')]");
    private static final SelenideElement attachPdf = $x("//span[contains(@title,'kandidat_anketa.pdf')]");

    public MailPage() {
    }

    @Step
    public void goToYandexMail() {
        open("https://mail.yandex.ru/?from=header-360&uid=1130000048345014#inbox");
    }

    @Step
    public void refreshInbox() {
        refresh.waitUntil(Condition.visible, 7000).click();
    }

    @Step
    public void openMailByTitle() {
        $x("//span[contains(text()," +
                "'" + DataHelper.FullName.getPatronymic() + " " + DataHelper.FullName.getLastname() + "')]").
                waitUntil(Condition.visible,30000).click();
    }

    @Step
    public void loginYandexMail() {
        enterMail.click();
        login.val("TestNspkAnketa");
        enter.click();
        password.val("qwerty137");
        enter.click();
        refresh.waitUntil(Condition.visible, 8000);
    }

    @Step
    public void checkAttachments(String fileName) {
        $x("//div[contains(text()," +
                "'"+DataHelper.FullName.getPatronymic()+" "+DataHelper.FullName.getLastname()+"')]")
                .shouldBe(Condition.visible);
        $x("//span[contains(@title,"+fileName+")]").shouldBe(Condition.visible);
        attachPdf.shouldHave(Condition.exist);
        attachDocx.shouldHave(Condition.exist);
    }

}
