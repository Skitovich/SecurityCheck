package com.gsmserver.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.data.DataHelper;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class ValidationPage {
    private static SelenideElement userLastName = $x("//input[@id='userInfo_lastName']");
    private static SelenideElement userFirstName = $x("//input[@id='userInfo_firstName']");
    private static SelenideElement userPatronymic = $x("//input[@id='userInfo_patronymic']");
    private static SelenideElement buttonGenerateLink = $x("//button[contains(@class,'generateBtn')]");
    private static SelenideElement buttonCopyToClipboard = $x("//button[contains(@class,'copyBtn')]");
    private static SelenideElement buttonClearForm = $x("//button[contains(@class,'clearBtn')]");
    private static SelenideElement linkForCandidate = $x("//div[contains(text(),'http')]");


    public ValidationPage() {
    }


    @Step
    private void openGenerateLink() {
        String link = linkForCandidate.getText();
        open(link);
    }

    @Step
    private void fillFormAndGenerateLink(DataHelper.FullName fullName) {
        fullName.generateFullName();
        userFirstName.val(fullName.getFirstname());
        userLastName.val(fullName.getLastname());
        userPatronymic.val(fullName.getPatronymic());
        buttonGenerateLink.click();
        linkForCandidate.shouldBe(Condition.visible);
    }

    @Step
    public void openLink(DataHelper.FullName fullName) {
        fillFormAndGenerateLink(fullName);
        openGenerateLink();
    }

}
