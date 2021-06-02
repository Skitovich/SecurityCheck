package com.gsmserver.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.data.DataHelper;
import io.qameta.allure.Step;

import java.io.File;

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
    private static SelenideElement timeStart = $x("//input[@id='timeStart']");
    private static SelenideElement timeEnd = $x("//input[@id='timeEnd']");
    private static SelenideElement positionAndOrganization = $x("//textarea[@id='positionAndOrganization']");
    private static SelenideElement organizationContacts = $x("//textarea[@id='organizationContacts']");
    private static SelenideElement relationDegree = $x("//textarea[@id='relationDegree']");
    private static SelenideElement fullNameRelative = $x("//textarea[@id='fullName']");
    private static SelenideElement yearOfBirthRelative = $x("//input[@id='yearOfBirth']");
    private static SelenideElement candidateRegistrationAddress =
            $x("//textarea[@id='residenceAndRegistrationAddress']");
    private static SelenideElement candidateFinancialLiabilities =
            $x("//textarea[@id='formData_financialLiabilities']");
    private static SelenideElement hobbies = $x("//textarea[@id='formData_hobbies']");
    private static SelenideElement buttonFileUpload = $x("//input[@type='file']");
    private static SelenideElement checkbox = $x("//input[@type='checkbox']");
    private static SelenideElement attachmentCheck = $x("//span[@class='ant-upload-list-item-name']");




    public QuestionnairePage() {
        questionnairePage.shouldBe(Condition.visible);
    }

    @Step
    private void fill(DataHelper.Questionnaire questionnaire) {
     changeFullName.val(questionnaire.getChangeFullName());
     birthData.val(questionnaire.getDateBirthAndFullLivingPlace());
     passportData.val(questionnaire.getPassportData());
    }

    //Метод поиска локатора для кнопки "Добавить запись" для вопросов 13, 14, 17. Параметр номер вопроса.
    @Step
    private void getButtonAddValue(String numberOfQuestion) {
        $x("//label[contains(text(),'" + numberOfQuestion + "')]" +
                "/parent::div/following-sibling::div/div/div/div/button").click();
    }

    @Step("был выбран ответ {answer}")
    private void radioButtonRelativesInOurOrganization (String answer) {
        $x("//div[@id='relativesInOurOrganization']/label/span[text()='" + answer + "']").click();
    }

    @Step("был выбран ответ {answer}")
    private void radioButtonRelativesPermanentlyAbroad (String answer) {
        $x("//div[@id='relativesPermanentlyAbroad']/label/span[text()='" + answer + "']").click();
    }

    @Step
    private void uploadFile(String fileName) {
        buttonFileUpload.uploadFile(new File("src/test/resources/" + fileName));
        attachmentCheck.shouldHave(Condition.text(fileName)).shouldHave(Condition.visible);
    }


    @Step
    public void fillForm(DataHelper.Questionnaire questionnaire) {
     fill(questionnaire);
     getButtonAddValue("13");
     radioButtonRelativesInOurOrganization("Да");
     radioButtonRelativesPermanentlyAbroad("Нет");
     uploadFile("Attachments.pdf");

    }

}
