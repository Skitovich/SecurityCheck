package com.gsmserver.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.data.DataHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class ValidationPage {
    private static SelenideElement userLastName = $x("//input[@id='userInfo_lastName']");
    private static SelenideElement userFirstName = $x("//input[@id='userInfo_firstName']");
    private static SelenideElement userPatronymic = $x("//input[@id='userInfo_patronymic']");
    private static SelenideElement buttonGenerateLink = $x("//button[contains(@class,'generateBtn')]");
    private static SelenideElement buttonCopyToClipboard = $x("//button[contains(@class,'copyBtn')]");
    private static SelenideElement buttonClearForm = $x("//button[contains(@class,'clearBtn')]");
    private static SelenideElement linkForCandidate = $x("//div[contains(text(),'http')]");

    private static SelenideElement anceta = $x("//h1[text()='Анкета']");

    public ValidationPage() {
    }

    @Step
    private void openLink () {
        String link = linkForCandidate.getText();
        open(link);
    }

    @Step
    private void request (DataHelper.RequiredFields fields) {
        userFirstName.val(fields.getFirstName());
        userLastName.val(fields.getLastName());
        userPatronymic.val(fields.getPatronymic());
        buttonGenerateLink.click();
        linkForCandidate.shouldBe(Condition.visible);
        openLink();
        anceta.shouldBe(Condition.visible);
    }


    @Step
    public void jumpNewTab(DataHelper.RequiredFields fields) {
        request(fields);
        
    }

}
