package com.nspkSecurityCheck.data;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataHelper {

    public DataHelper() {
    }

    public static FullName getFullNameInfo() {
        return new FullName();
    }

    //------------------------------ Методы для страницы валидации-------------------------------------
    @Step("Генерирует фамилию")
    private static String generateCandidateLastName() {
        return new Faker(new Locale("ru_RU")).name().lastName();
    }

    @Step("Генерирует имя")
    private static String generateCandidateFirstName() {
        return new Faker(new Locale("ru_RU")).name().firstName();
    }

    @Step("Генерирует отчество")
    public static String generateCandidatePatronymic() {
        ArrayList<String> patronymic = new ArrayList<>(Arrays.
                asList("Александрович", "Андреевич", "Васильевич", "Валентинович", "Сергеевич", "Проклович"));
        Collections.shuffle(patronymic);
        return patronymic.get(1);
    }

    @Step("Генерирует текст")
    public static String generateText(int length, String alphabet) {
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(Math.max(length, 16));
        for (int i = 0; i < length; i++) {
            int len = alphabet.length();
            int random = rnd.nextInt(len);
            char c = alphabet.charAt(random);
            sb.append(c);
        }
        return sb.toString();
    }

    //    -------------------------------- Методы для анкеты*/----------------------------------------------
    @Step("Генерирует ФИО")
    public static String generateChangeFullName() {
        return new Faker(new Locale("ru")).name().nameWithMiddle();
    }

    @Step("Генерирует дату рождения и ФИО")
    public static String generateDateBirthData() {
        return new Faker(new Locale("ru")).name().nameWithMiddle() + " " +
                new Faker(new Locale("ru")).address().city();
    }

    @Step("Генерирует паспортные данные, город и дату")
    public static String generatePassportData() {
        Faker faker = new Faker(new Locale("ru"));
        String startPassportCode = faker.code().imei().substring(0, 4);
        String endPassportCode = faker.random().nextInt(1, 1000000).toString();
        String city = faker.address().cityName();
        Date date = faker.date().birthday(20, 30);
        return "Серия: " + startPassportCode + " №" + endPassportCode + " Выдан ОВД г." + city + " дата выдачи:" + date;
    }

    @Step("Генерирует налоговый ID")
    public static String generateTaxPayerNumber() {
        return new Faker(new Locale("ru")).code().imei().substring(0, 11);
    }

    @Step("Генерирует почтовый ящик")
    public static String generateContacts() {
        return new Faker().internet().emailAddress();
    }

    @Step("Генерирует Да или Нет")
    public static String generateAnswer() {
        ArrayList<String> answer = new ArrayList<>(Arrays.asList("Да", "Нет"));
        Collections.shuffle(answer);
        return answer.get(0);
    }

    @Step("Генерирует учебное заведение")
    public static String generateEducation() {
        return new Faker(new Locale("ru")).educator().university();
    }

    @Step("Генерирует дату")
    public static String generateDate(int minusYearsFromNow, String dateFormat) {
        LocalDate dayDeliveryCard = LocalDate.now().minusYears(minusYearsFromNow);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return dayDeliveryCard.format(formatter);
    }

    //------------------------------------------Поля и конструкторы-------------------------------------------
    public static class FullName {
        private static String firstname;
        private static String lastname;
        private static String patronymic;

        public static String getLastname() {
            return lastname;
        }

        public static String getPatronymic() {
            return patronymic;
        }

        public static String getFirstname() {
            return firstname;
        }

        public void generateFullName() {
            firstname = generateCandidateFirstName();
            lastname = generateCandidateLastName();
            patronymic = generateCandidatePatronymic();
        }
    }

}
