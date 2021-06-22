package com.nspkSecurityCheck.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.nspkSecurityCheck.data.DataHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.elements;
import static com.nspkSecurityCheck.data.DataHelper.*;

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
    private static final SelenideElement hobbies = $x("//textarea[@id='formData_hobbies']");
    private static final SelenideElement buttonFileUpload = $x("//input[@type='file']");
    private static final SelenideElement checkbox = $x("//input[@type='checkbox']");
    private static final SelenideElement start = $x("//input[@id='timeStart']");
    private static final SelenideElement end = $x("//input[@id='timeEnd']");
    private static final SelenideElement insert = $x("//span[@aria-label='check']");
    private static final SelenideElement edit = $x("//*[@data-icon='edit']");
    private static final SelenideElement submit = $x("//button[@type='submit']");
    private static final ElementsCollection deleteButtonCollection = elements(By.xpath("//*[@data-icon='delete']"));
    private static final SelenideElement deleteConfirmQuestionOK = $x("//span[text()='OK']");
    private static final SelenideElement deleteConfirmQuestion =
            $x("//div[text()='Вы уверены, что хотите удалить запись?']");
    private static final SelenideElement financialLiabilities =
            $x("//textarea[@id='formData_financialLiabilities']");
    private static final SelenideElement registrationAddress =
            $x("//textarea[@id='residenceAndRegistrationAddress']");
    private static final SelenideElement successful = $x("//div[text()='Данные успешно отправлены']");
    private static final SelenideElement declinedLinkIsDeath =
            $x("//span[text()='Данная ссылка некорректна или неактуальна']");
    private final String alphabet = "АаБбВвГгДдЕеЁёЖжЗзИиКкЛлМмНн ОоПпРрСсТУуФфЦцЮюЯяЭэХх    ";


    public QuestionnairePage() {
        questionnairePage.shouldBe(Condition.visible);
    }


    @Step("Генерация значений для всех текстовых полей")
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
        militaryStatus.val(generateText(30, alphabet));
        financialLiabilities.val(generateAnswer());
        hobbies.val(DataHelper.generateText(20, alphabet));
    }

    @Step("Генерация 2000 символов для всех текстовых полей")
    public void fillGeneratedValues2000char() {
        int howManyLetters = 2000;
        changeFullName.val(generateText(howManyLetters, alphabet));
        birthData.val(generateText(howManyLetters, alphabet));
        passportData.val(generateText(howManyLetters, alphabet));
        taxpayerIdentificationNumber.val(generateText(howManyLetters, "0123456789"));
        contacts.val(generateText(howManyLetters, alphabet));
        weaponPermission.val(generateText(howManyLetters, alphabet));
        maritalStatus.val(generateText(howManyLetters, alphabet));
        citizenship.val(generateText(howManyLetters, alphabet));
        education.val(generateText(howManyLetters, alphabet));
        residencePermitRequest.val(generateText(howManyLetters, alphabet));
        travelStatus.val(generateText(howManyLetters, alphabet));
        militaryStatus.val(generateText(howManyLetters, alphabet));
        financialLiabilities.val(generateText(howManyLetters, alphabet));
        hobbies.val(generateText(howManyLetters, alphabet));
    }


    @Step("метод принимает на вход номер вопроса 13,14,17 и нажимает на кнопку Добавить запись")
    private void getButtonAddValue(String numberOfQuestion) {
        $x("//label[contains(text(),'" + numberOfQuestion + "')]" +
                "/parent::div/following-sibling::div/div/div/div/button").click();
    }

    @Step("Радиокнопка, ответ: Да или Нет генерируется")
    public void radioButtonRelativesInOurOrganization() {
        $x("//div[@id='relativesInOurOrganization']/" +
                "label/span[text()='" + DataHelper.generateAnswer() + "']").click();
    }

    @Step("был выбран ответ {}")
    public void radioButtonRelativesPermanentlyAbroad() {
        $x("//div[@id='relativesPermanentlyAbroad']/" +
                "label/span[text()='" + DataHelper.generateAnswer() + "']").click();
    }

    @Step("Загружает файл и проверяет, что он отображается")
    public void uploadFile(String extension) {
        buttonFileUpload.uploadFile(new File("src/test/resources/Attachments." + extension));
        checkAttachmentExtension(extension);
    }

    @Step("Проверяет по расширению загруженный файл")
    public void checkAttachmentExtension(String extension) {
        $x("//span[contains(text(),'" + extension + "')]").shouldBe(Condition.visible);
    }

    @Step("Загружает несколько вложений и проверяет что они отображаются")
    public void uploadAllExtensions(String attachPdf,
                                    String attachJpg,
                                    String attachDocx,
                                    String attachPng,
                                    String attachXlsx) {
        buttonFileUpload.uploadFile(new File("src/test/resources/Attachments." + attachPdf));
        buttonFileUpload.uploadFile(new File("src/test/resources/Attachments." + attachDocx));
        buttonFileUpload.uploadFile(new File("src/test/resources/Attachments." + attachJpg));
        buttonFileUpload.uploadFile(new File("src/test/resources/Attachments." + attachPng));
        buttonFileUpload.uploadFile(new File("src/test/resources/Attachments." + attachXlsx));
        checkAttachmentExtension(attachPdf);
        checkAttachmentExtension(attachXlsx);
        checkAttachmentExtension(attachJpg);
        checkAttachmentExtension(attachPng);
        checkAttachmentExtension(attachXlsx);
    }

    @Step("Клик по чекбоксу")
    public void checkboxClick() {
        checkbox.click();
    }

    @Step("Заполняет в 13 и 17 запросе поле Дата начала")
    private void fillDateStart(int minusYearsFromNow, String dateFormat) {
        start.click();
        start.val(generateDate(minusYearsFromNow, dateFormat)).pressEnter();
    }

    @Step("Заполняет в 13 и 17 запросе поле Дата окончания")
    private void fillEnd(int minusYearsFromNow, String dateFormat) {
        end.click();
        end.val(generateDate(minusYearsFromNow, dateFormat)).pressEnter();
    }


    @Step("Заполнение 13 вопроса")
    public void fillQuestion13(int minusYearsFromNow, String dateFormat) {
        getButtonAddValue("13");
        fillDateStart(minusYearsFromNow, dateFormat);
        fillEnd(minusYearsFromNow - 1, dateFormat);
        positionAndOrganization.val(generateText(15, alphabet));
        organizationContacts.val(generateText(30, alphabet));
        insert.click();
        edit.shouldBe(Condition.visible);
    }

    @Step("Заполнение 14 вопроса")
    public void fillQuestion14(int minusYearsFromNow, String dateFormat) {
        getButtonAddValue("14");
        yearOfBirthRelative.click();
        yearOfBirthRelative.val(generateDate(minusYearsFromNow, dateFormat));
        relationDegree.val(generateText(10, alphabet));
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

    @Step("Заполнение 17 вопроса, редактирование, сохранение")
    public void fill17QuestionAndEdit(int minusYearsFromNow, String dateFormat) {
        fillQuestion17(minusYearsFromNow, dateFormat);
        edit.click();
        fillDateStart(minusYearsFromNow, dateFormat);
        fillEnd(minusYearsFromNow - 1, dateFormat);
        registrationAddress.val(generateContacts());
        insert.click();
        edit.shouldBe(Condition.visible);
    }

    @Step("Заполнение 14 вопроса, редактирование, сохранение")
    public void fill14QuestionAndEdit(int minusYearsFromNow, String dateFormat) {
        fillQuestion14(minusYearsFromNow, dateFormat);
        edit.click();
        yearOfBirthRelative.click();
        yearOfBirthRelative.val(generateDate(minusYearsFromNow, dateFormat));
        relationDegree.val(generateText(10, alphabet));
        fullNameRelative.val(generateChangeFullName());
        insert.click();
        edit.shouldBe(Condition.visible);
    }

    @Step("Заполнение 13 вопроса, редактирование, сохранение")
    public void fill13QuestionAndEdit(int minusYearsFromNow, String dateFormat) {
        fillQuestion13(minusYearsFromNow, dateFormat);
        edit.click();
        fillDateStart(minusYearsFromNow, dateFormat);
        fillEnd(minusYearsFromNow - 1, dateFormat);
        positionAndOrganization.val(generateText(15, alphabet));
        organizationContacts.val(generateText(30, alphabet));
        insert.click();
        edit.shouldBe(Condition.visible);
    }

    @Step("Заполнение 13 вопроса {maxRows} раз")
    public void fill13QuestionManyTimes(int minusYearsFromNow, String dateFormat) {
        int maxRows = 10;
        while (maxRows >= 0) {
            fillQuestion13(minusYearsFromNow + maxRows, dateFormat);
            maxRows--;
        }
    }

    @Step("Заполнение 14 вопроса {maxRows} раз")
    public void fill14QuestionManyTimes(int minusYearsFromNow, String dateFormat) {
        int maxRows = 10;
        while (maxRows >= 0) {
            fillQuestion14(minusYearsFromNow + maxRows, dateFormat);
            maxRows--;
        }
    }

    @Step("Заполнение 17 вопроса {maxRows} раз")
    public void fill17QuestionManyTimes(int minusYearsFromNow, String dateFormat) {
        int maxRows = 10;
        while (maxRows >= 0) {
            fillQuestion17(minusYearsFromNow + maxRows, dateFormat);
            maxRows--;
        }
    }

    @Step("Отправить анкету на почту, проверка об успешности")
    public void submitClick() {
        submit.click();
        successful.waitUntil(Condition.visible, 10000);
    }

    @Step("Отправить анкету на проверку, ссылка мертвая, проверка на то что ссылка умерла")
    public void submitClickByDeadLink() {
        submit.click();
        declinedLinkIsDeath.shouldBe(Condition.visible);
    }


    @Step("Удаляет случаную строку из таблицы и проверяет количество строк")
    public void randomRowDelete() {
        Random random = new Random();
        int size = deleteButtonCollection.size();
        int num = random.nextInt(size - 1);
        deleteButtonCollection.get(num).click();
        deleteConfirmQuestion.shouldBe(Condition.visible);
        deleteConfirmQuestionOK.click();
        deleteButtonCollection.shouldHaveSize(size - 1);
    }

}
