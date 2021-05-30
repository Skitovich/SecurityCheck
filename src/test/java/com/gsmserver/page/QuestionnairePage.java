package com.gsmserver.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;


public class QuestionnairePage {
    private static SelenideElement questionnairePage = $x("//h1[text()='Анкета']");
    private static SelenideElement userLastName = $x("//input[@id='userInfo_lastName']");
    private static SelenideElement userFirstName = $x("//input[@id='userInfo_firstName']");
    private static SelenideElement userPatronymic = $x("//input[@id='userInfo_patronymic']");
    private static SelenideElement changeFullName = $x("//textarea[@id='formData_changeFullName']");
    private static SelenideElement birthData = $x("//textarea[@id='formData_birthData']");
    private static SelenideElement passportData = $x("//textarea[@id='formData_passport']");
    private static SelenideElement taxpayerIdentificationNumber =
            $x("//input[@id='formData_taxpayerIdentificationNumber']");
    private static SelenideElement contacts = $x("//textarea[@id='formData_contacts']");
    private static SelenideElement weaponPermission = $x("//textarea[@id='formData_weaponPermission']");
    private static SelenideElement maritalStatus = $x("//textarea[@id='formData_maritalStatus']");
    private static SelenideElement citizenship = $x("//textarea[@id='formData_citizenship']");

    private static SelenideElement education = $x("//textarea[@id='formData_education']");
    private static SelenideElement residencePermitRequest =
            $x("//textarea[@id='formData_residencePermitRequest']");
    private static SelenideElement travelStatus = $x("//textarea[@id='formData_travelStatus']");
    private static SelenideElement militaryStatus = $x("//textarea[@id='formData_militaryStatus']");
    

    

    public QuestionnairePage() {
        questionnairePage.shouldBe(Condition.visible);
    }

    //Метод поиска локатора для кнопки "Добавить запись" для вопросов 13, 14, 17. Параметр номер вопроса.
    @Step
    public SelenideElement getButtonAddValue(String numberOfQuestion) {
        return $x("//label[contains(text(),'" + numberOfQuestion + "')]/parent::div/following-sibling::div/div/div/div/button");
    }

    @Step
    public SelenideElement radioButtonRelativesInOurOrganization (boolean trueOrFalse) {
        if (trueOrFalse)
        return $x("//div[@id='relativesInOurOrganization']/label/span/input");
        else return $x("//div[@id='relativesInOurOrganization']/label/following::label/span/input");
    }

    @Step
    public SelenideElement radioButtonRelativesPermanentlyAbroad (boolean trueOrFalse) {
        if (trueOrFalse)
            return $x("//div[@id='relativesPermanentlyAbroad']/label/span/input");
        else return $x("//div[@id='relativesPermanentlyAbroad']/label/following::label/span/input");
    }

}
