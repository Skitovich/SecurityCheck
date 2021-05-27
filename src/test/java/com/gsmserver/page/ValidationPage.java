package com.gsmserver.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ValidationPage {
    private static SelenideElement userLastName = $x("//input[@id='userInfo_lastName']");
    private static SelenideElement userFirstName = $x("//input[@id='userInfo_firstName']");
    private static SelenideElement userPatronymic = $x("//input[@id='userInfo_patronymic']");
    private static SelenideElement buttonGenerateLink = $x("//button[contains(@class,'generateBtn')]");
    private static SelenideElement buttonCopyToClipboard = $x("//button[contains(@class,'copyBtn')]");
    private static SelenideElement buttonClearForm = $x("//button[contains(@class,'clearBtn')]");
    private static SelenideElement linkForCandidate = $x("//div[contains(text(),'http')]");


}
