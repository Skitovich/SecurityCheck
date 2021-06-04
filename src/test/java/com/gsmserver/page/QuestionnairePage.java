package com.gsmserver.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.elements;
import static com.gsmserver.data.DataHelper.*;


public class QuestionnairePage {
    private static final SelenideElement questionnairePage = $x("//h1[text()='Анкета']");
    private static final SelenideElement changeFullName = $x("//textarea[@id='formData_changeFullName']");
    private static final SelenideElement birthData = $x("//textarea[@id='formData_birthData']");
    private static final SelenideElement passportData = $x("//textarea[@id='formData_passport']");
    private static final SelenideElement taxpayerIdentificationNumber =
            $x("//input[@id='formData_taxpayerIdentificationNumber']");
    private static final SelenideElement contacts = $x("//textarea[@id='formData_contacts']");
    private static final SelenideElement weaponPermission = $x("//textarea[@id='formData_weaponPermission']");
    private static final SelenideElement maritalStatus = $x("//textarea[@id='formData_maritalStatus']");
    private static final SelenideElement citizenship = $x("//textarea[@id='formData_citizenship']");
    private static final SelenideElement education = $x("//textarea[@id='formData_education']");
    private static final SelenideElement residencePermitRequest =
            $x("//textarea[@id='formData_residencePermitRequest']");
    private static final SelenideElement travelStatus = $x("//textarea[@id='formData_travelStatus']");
    private static final SelenideElement militaryStatus = $x("//textarea[@id='formData_militaryStatus']");
    private static final SelenideElement positionAndOrganization = $x("//textarea[@id='positionAndOrganization']");
    private static final SelenideElement organizationContacts = $x("//textarea[@id='organizationContacts']");
    private static final SelenideElement relationDegree = $x("//textarea[@id='relationDegree']");
    private static final SelenideElement fullNameRelative = $x("//textarea[@id='fullName']");
    private static final SelenideElement yearOfBirthRelative = $x("//input[@id='yearOfBirth']");
    private static final SelenideElement candidateRegistrationAddress =
            $x("//textarea[@id='residenceAndRegistrationAddress']");
    private static final SelenideElement candidateFinancialLiabilities =
            $x("//textarea[@id='formData_financialLiabilities']");
    private static final SelenideElement hobbies = $x("//textarea[@id='formData_hobbies']");
    private static final SelenideElement buttonFileUpload = $x("//input[@type='file']");
    private static final SelenideElement checkbox = $x("//input[@type='checkbox']");
    private static final SelenideElement attachmentCheck = $x("//span[@class='ant-upload-list-item-name']");
    private static final List<SelenideElement> start = elements("#timeStart");
    private static final List<SelenideElement> end = elements("#timeEnd");
    private static final SelenideElement insert = $x("//span[@aria-label='check']");


    public QuestionnairePage() {
        questionnairePage.shouldBe(Condition.visible);
    }

    @Step
    private void fillValues() {
        changeFullName.val(generateChangeFullName());
        birthData.val(generateDateBirthData());
        passportData.val(generatePassportData());
        taxpayerIdentificationNumber.val(generateTaxPayerNumber());
        contacts.val(generateContacts());
        weaponPermission.val(generateAnswer());
        maritalStatus.val(generateWords(1));
        citizenship.val(generateWords(10));
        education.val(generateEducation());
        residencePermitRequest.val(generateAnswer());
        travelStatus.val(generateSentence(5));
        militaryStatus.val(generateWords(1));
    }

    //Метод поиска локатора для кнопки "Добавить запись" для вопросов 13, 14, 17. Параметр номер вопроса.
    @Step
    private void getButtonAddValue(String numberOfQuestion) {
        $x("//label[contains(text(),'" + numberOfQuestion + "')]" +
                "/parent::div/following-sibling::div/div/div/div/button").click();
    }

    @Step("был выбран ответ {answer}")
    private void radioButtonRelativesInOurOrganization(String answer) {
        $x("//div[@id='relativesInOurOrganization']/label/span[text()='" + answer + "']").click();
    }

    @Step("был выбран ответ {answer}")
    private void radioButtonRelativesPermanentlyAbroad(String answer) {
        $x("//div[@id='relativesPermanentlyAbroad']/label/span[text()='" + answer + "']").click();
    }

    @Step
    private void uploadFile(String fileName) {
        buttonFileUpload.uploadFile(new File("src/test/resources/" + fileName));
        attachmentCheck.shouldHave(Condition.text(fileName)).shouldHave(Condition.visible);
    }

    @Step
    private void checkboxClick() {
        checkbox.click();
    }

    @Step
    public void fillQuestion(String numQuestion, String dateStart, String dateEnd) {
        getButtonAddValue(numQuestion);
        start.get(1).val(dateStart);
        end.get(1).val(dateEnd);
        positionAndOrganization.val(generateSentence(1));
        organizationContacts.val(generateContacts());

    }

    @Step
    public void fillForm() {
     fillValues();
     getButtonAddValue("13");
     radioButtonRelativesInOurOrganization("Да");
     radioButtonRelativesPermanentlyAbroad("Нет");
     uploadFile("Attachments.pdf");
     checkboxClick();
    }
}
