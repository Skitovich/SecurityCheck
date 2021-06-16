package com.gsmserver.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.data.DataHelper;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.gsmserver.data.DataHelper.generateText;
import static com.gsmserver.data.DataHelper.getRandomWord;


public class ValidationPage {
    private static final SelenideElement userLastName = $x("//input[@id='userInfo_lastName']");
    private static final SelenideElement userFirstName = $x("//input[@id='userInfo_firstName']");
    private static final SelenideElement userPatronymic = $x("//input[@id='userInfo_patronymic']");
    private static final SelenideElement buttonGenerateLink = $x("//button[contains(@class,'generateBtn')]");
    private static final SelenideElement buttonCopyToClipboard = $x("//button[contains(@class,'copyBtn')]");
    private static final SelenideElement buttonClearForm = $x("//button[contains(@class,'clearBtn')]");
    private static final SelenideElement linkForCandidate = $x("//div[contains(text(),'http')]");
    private static final SelenideElement popupCopyClipBoard = $x("//span[text()='Ссылка скопирована']");


    public ValidationPage() {
    }


    @Step
    public void openGenerateLink() {
        String link = linkForCandidate.getText();
        open(link);
    }

    @Step
    public void fillFormAndGenerateLink(DataHelper.FullName fullName) {
        fullName.generateFullName();
        userFirstName.val(DataHelper.FullName.getFirstname());
        userLastName.val(DataHelper.FullName.getLastname());
        userPatronymic.val(DataHelper.FullName.getPatronymic());
        buttonGenerateLink.click();
        linkForCandidate.shouldBe(Condition.visible);
    }

    @Step
    public void openLink(DataHelper.FullName fullName) {
        fillFormAndGenerateLink(fullName);
        openGenerateLink();
    }

    @Step
    public void copyClipBoard() {
        buttonCopyToClipboard.click();
        popupCopyClipBoard.shouldBe(Condition.visible);
    }

    @Step
    public void fillForm2000chars() {
        userFirstName.val(getRandomWord(2001,"абв"));
        userLastName.val(getRandomWord(2001,"абв"));
        userPatronymic.val(getRandomWord(2001,"абв"));
        buttonGenerateLink.click();
        linkForCandidate.shouldBe(Condition.visible);
    }

}
