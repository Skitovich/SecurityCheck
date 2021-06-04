package com.gsmserver.data;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.Value;

import java.util.*;

public class DataHelper {
    private DataHelper() {
    }


    // Методы и поля для страницы валидации
    private static String generateCandidateLastName() {
        return new Faker(new Locale("ru_RU")).name().firstName();
    }

    private static String generateCandidateFirstName() {
        return new Faker(new Locale("ru_RU")).name().lastName();
    }

    public static String generateCandidatePatronymic() {
        ArrayList<String> patronymic = new ArrayList<>(Arrays.
                asList("Александрович", "Андреевич", "Васильевич", "Валентинович", "Сергеевич", "Проклович"));
        Collections.shuffle(patronymic);
        return patronymic.get(1);
    }

    @Value
    public static class FullName {
        String firstName;
        String lastName;
        String patronymic;
    }

    @Step
    public static FullName generateFullName() {
        return new FullName(generateCandidateFirstName(), generateCandidateLastName(), generateCandidatePatronymic());
    }
  // Методы для анкеты

    public static String generateChangeFullName() {
        return new Faker(new Locale("ru_RU")).name().nameWithMiddle();
    }
    
    public static String generateDateBirthData() {
        return new Faker(new Locale("ru_RU")).name().nameWithMiddle() + "" +
        new Faker(new Locale("ru_RU")).address().fullAddress();
    }


    public static String generatePassportData() {
        Faker faker = new Faker(new Locale("ru_RU"));
        String startPassportCode = faker.code().imei().substring(0, 4);
        String endPassportCode = faker.code().imei().substring(0, 6);
        String city = faker.address().fullAddress();
        Date date = faker.date().birthday(20,30);

        return "Серия:" + startPassportCode + " №" + endPassportCode + " Выдан ОВД г." + city + " дата выдачи:" + date;
    }

    public static String generateTaxPayerNumber() {
        return new Faker(new Locale("ru_RU")).code().imei().substring(0,11);
    }

    public static String generateContacts() {
        return new Faker(new Locale("ru_RU")).phoneNumber() + " " +
                new Faker(new Locale("ru_RU")).internet().emailAddress();
    }

    public static String generateText(int numLetters) {
      return new Faker(new Locale("ru_RU")).lorem().fixedString(numLetters);
    }

    public static String generateWords(int numOfWords) {
        return new Faker(new Locale("ru_RU")).lorem().words(numOfWords).toString();
    }

    public static String generateAnswer() {
        ArrayList<String> answer = new ArrayList<>(Arrays.
                asList("Да", "Нет"));
        Collections.shuffle(answer);
        return answer.get(0);
    }

    public static String generateSentence (int numSentence) {
        return new Faker(new Locale("ru_RU")).lorem().sentences(numSentence).toString();
    }


    public static String generateEducation() {
        return new Faker(new Locale("ru_RU")).educator().university();
    }

    public static String generateDate(int minAge,int maxAge) {
        return new Faker(new Locale("ru_RU")).date().birthday(minAge,maxAge).toString().substring(4,9);
    }

}
