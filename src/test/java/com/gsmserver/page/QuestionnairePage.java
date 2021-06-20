package com.gsmserver.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.data.DataHelper;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;
import static com.gsmserver.data.DataHelper.*;


public class QuestionnairePage {
    private static final SelenideElement questionnairePage = $x("//h1[text()='Анкета']");
    private static final SelenideElement changeFullName = $x("//textarea[@id='formData_changeFullName']");
    private static final SelenideElement birthData = $x("//textarea[@id='formData_birthData']");
    private static final SelenideElement passportData = $x("//textarea[@id='formData_passport']");
    private static final SelenideElement taxpayerIdentificationNumber =
            $x("//input[@id='formData_taxpayerIdentificationNumber']");
    private static final SelenideElement contacts = $x("//textarea[@id='formData_contacts']");
    private static final SelenideElement weaponPermission =
            $x("//textarea[@id='formData_weaponPermission']");
    private static final SelenideElement maritalStatus = $x("//textarea[@id='formData_maritalStatus']");
    private static final SelenideElement citizenship = $x("//textarea[@id='formData_citizenship']");
    private static final SelenideElement education = $x("//textarea[@id='formData_education']");
    private static final SelenideElement residencePermitRequest =
            $x("//textarea[@id='formData_residencePermitRequest']");
    private static final SelenideElement travelStatus = $x("//textarea[@id='formData_travelStatus']");
    private static final SelenideElement militaryStatus = $x("//textarea[@id='formData_militaryStatus']");
    private static final SelenideElement positionAndOrganization =
            $x("//textarea[@id='positionAndOrganization']");
    private static final SelenideElement organizationContacts =
            $x("//textarea[@id='organizationContacts']");
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
    //Табличные вопросы 13,14,17
    private static final SelenideElement start = $x("//input[@id='timeStart']");
    private static final SelenideElement end = $x("//input[@id='timeEnd']");
    private static final SelenideElement insert = $x("//span[@aria-label='check']");
    private static final SelenideElement edit = $x("//*[@data-icon='edit']");
    private static final SelenideElement submit = $x("//button[@type='submit']");
    private static final SelenideElement delete = $x("//*[@data-icon='delete']");
    private static final SelenideElement deleteConfirmQuestionOK = $x("//span[text()='OK']");
    private static final SelenideElement deleteConfirmQuestion =
            $x("//div[text()='Вы уверены, что хотите удалить запись?']");

    
    private static final SelenideElement financialLiabilities =
            $x("//textarea[@id='formData_financialLiabilities']");
    private static final SelenideElement registrationAddress =
            $x("//textarea[@id='residenceAndRegistrationAddress']");
    private static final SelenideElement successful = $x("//div[text()='Данные успешно отправлены']");
    private String alphabet = "АаБбВвГгДдЕеЁёЖжЗзИиКкЛлМмНн ОоПпРрСсТУуФфЦцЮюЯяЭэХх    ";
    private int howManyLetters = 2000;


    public QuestionnairePage() {
        questionnairePage.shouldBe(Condition.visible);
    }


    @Step
    public void fillGeneratedValues() {
        changeFullName.val(generateChangeFullName());
        birthData.val(generateDateBirthData());
        passportData.val(generatePassportData());
        taxpayerIdentificationNumber.val(generateTaxPayerNumber());
        contacts.val(generateContacts());
        weaponPermission.val(generateAnswer());
        maritalStatus.val(DataHelper.generateText(20, alphabet));
        citizenship.val(DataHelper.generateText(30, alphabet));
        education.val(generateEducation());
        residencePermitRequest.val(generateAnswer());
        travelStatus.val(DataHelper.generateText(20, alphabet));
        militaryStatus.val(generateText(30,alphabet));
        financialLiabilities.val(generateAnswer());
        hobbies.val(DataHelper.generateText(20,alphabet));
    }

    @Step
    public void fillGeneratedValues2000char() {
        changeFullName.val(generateText(howManyLetters,alphabet));
        birthData.val(generateText(howManyLetters,alphabet));
        passportData.val(generateText(howManyLetters,alphabet));
        taxpayerIdentificationNumber.val(generateText(howManyLetters,"0123456789"));
        contacts.val(generateText(howManyLetters,alphabet));
        weaponPermission.val(generateText(howManyLetters,alphabet));
        maritalStatus.val(generateText(howManyLetters,alphabet));
        citizenship.val(generateText(howManyLetters,alphabet));
        education.val(generateText(howManyLetters,alphabet));
        residencePermitRequest.val(generateText(howManyLetters,alphabet));
        travelStatus.val(generateText(howManyLetters,alphabet));
        militaryStatus.val(generateText(howManyLetters,alphabet));
        financialLiabilities.val(generateText(howManyLetters,alphabet));
        hobbies.val(generateText(howManyLetters,alphabet));
    }

    //Метод поиска локатора для кнопки "Добавить запись" для вопросов 13, 14, 17. Параметр номер вопроса.
    @Step
    private void getButtonAddValue(String numberOfQuestion) {
        $x("//label[contains(text(),'" + numberOfQuestion + "')]" +
                "/parent::div/following-sibling::div/div/div/div/button").click();
    }

    @Step("был выбран ответ {}")
    public void radioButtonRelativesInOurOrganization() {
        $x("//div[@id='relativesInOurOrganization']/" +
                "label/span[text()='" + DataHelper.generateAnswer() + "']").click();
    }

    @Step("был выбран ответ {}")
    public void radioButtonRelativesPermanentlyAbroad() {
        $x("//div[@id='relativesPermanentlyAbroad']/" +
                "label/span[text()='" + DataHelper.generateAnswer() + "']").click();
    }

    @Step
    public void uploadFile(String fileName) {
        buttonFileUpload.uploadFile(new File("src/test/resources/" + fileName));
        attachmentCheck.shouldHave(Condition.text(fileName)).shouldHave(Condition.visible);
    }

    @Step
    public void checkboxClick() {
        checkbox.click();
    }

    @Step
    private void fillDateStart(int minusYearsFromNow, String dateFormat) {
        start.click();
        start.val(generateDate(minusYearsFromNow, dateFormat)).pressEnter();
    }

    @Step
    private void fillEnd(int minusYearsFromNow, String dateFormat) {
        end.click();
        end.val(generateDate(minusYearsFromNow, dateFormat)).pressEnter();
    }


    @Step("Заполнение 13 вопроса")
    public void fillQuestionNum13(int minusYearsFromNow, String dateFormat) {
        getButtonAddValue("13");
        fillDateStart(minusYearsFromNow, dateFormat);
        fillEnd(minusYearsFromNow - 1, dateFormat);
        positionAndOrganization.val(generateText(15, alphabet));
        organizationContacts.val(generateText(30,alphabet));
        insert.click();
        edit.shouldBe(Condition.visible);
    }

    @Step("Заполнение 14 вопроса")
    public void fillQuestionNum14(int minusYearsFromNow, String dateFormat) {
        getButtonAddValue("14");
        yearOfBirthRelative.click();
        yearOfBirthRelative.val(generateDate(minusYearsFromNow, dateFormat));
        relationDegree.val(generateText(10,alphabet));
        fullNameRelative.val(generateChangeFullName());
        insert.click();
        edit.shouldBe(Condition.visible);
    }

    @Step("Заполнение 17 вопроса")
    public void fillQuestion17(int minusYearsFromNow, String dateFormat) {
        getButtonAddValue("17");
        fillDateStart(minusYearsFromNow, dateFormat);
        fillEnd(minusYearsFromNow - 1, dateFormat);
        registrationAddress.val(generateContacts());
        insert.click();
        edit.shouldBe(Condition.visible);
    }

    @Step
    public void submitClick() {
        submit.click();
        successful.waitUntil(Condition.visible, 10000);
    }

    @Step
    public void deleteLine() {
        delete.click();
        deleteConfirmQuestion.shouldBe(Condition.visible);
        deleteConfirmQuestionOK.click();
    }


}
