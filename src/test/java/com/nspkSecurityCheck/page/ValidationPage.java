package com.nspkSecurityCheck.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.nspkSecurityCheck.data.DataHelper;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class ValidationPage {
    private static final SelenideElement userLastName = $x("//input[@id='userInfo_lastName']");
    private static final SelenideElement userFirstName = $x("//input[@id='userInfo_firstName']");
    private static final SelenideElement userPatronymic = $x("//input[@id='userInfo_patronymic']");
    private static final SelenideElement buttonGenerateLink = $x("//button[contains(@class,'generateBtn')]");
    private static final SelenideElement buttonCopyToClipboard = $x("//button[contains(@class,'copyBtn')]");
    private static final SelenideElement buttonClearForm = $x("//button[contains(@class,'clearBtn')]");
    private static final SelenideElement linkForCandidate = $x("//div[contains(text(),'http')]");
    private static final SelenideElement popupCopyClipBoard = $x("//span[text()='Ссылка скопирована']");
    private static final SelenideElement openExpiredLink = $x("//div[text()='Данная ссылка некорректна или неактуальна']");
    private String alphabet = "АаБбВвГгДдЕеЁёЖжЗзИиКкЛлМмНнОоПпРрСсТУуФфЦцЮюЯяЭэХх-";


    public ValidationPage() {
    }


    @Step("Открывает сгенерированную ссылку")
    public void openGenerateLink() {
        String link = linkForCandidate.getText();
        open(link);
    }

    @Step("Заполняет поле сгеренрированными данными и генерирует ссылку")
    public void fillFormAndGenerateLink(DataHelper.FullName fullName) {
        fullName.generateFullName();
        userFirstName.val(DataHelper.FullName.getFirstname());
        userLastName.val(DataHelper.FullName.getLastname());
        userPatronymic.val(DataHelper.FullName.getPatronymic());
        buttonGenerateLink.click();
        linkForCandidate.shouldBe(Condition.visible);
    }

    @Step("Заполняет поля, генерирует ссылку и открывает сгенерированную ссылку")
    public void openLink(DataHelper.FullName fullName) {
        fillFormAndGenerateLink(fullName);
        openGenerateLink();
    }

    @Step("Копирует сгенерированную ссылку в буфер обмена и проверяет наличие всплывающего окна")
    public void copyClipBoard() {
        buttonCopyToClipboard.click();
        popupCopyClipBoard.shouldBe(Condition.visible);
    }

    @Step("Заполняет поле 2000 символов")
    public void fillForm2000chars() {
        userFirstName.val(DataHelper.generateText(2000, alphabet));
        userLastName.val(DataHelper.generateText(2000, alphabet));
        userPatronymic.val(DataHelper.generateText(2000, alphabet));
        buttonGenerateLink.click();
        linkForCandidate.shouldBe(Condition.visible);
    }

    @Step("Открывает ссылку, ждет ошибку о истечении времени ссылки")
    public void openExpiredLink() {
        openGenerateLink();
        openExpiredLink.shouldBe(Condition.visible);
    }


}
