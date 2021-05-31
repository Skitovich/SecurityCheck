package com.gsmserver.data;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.Value;

import java.util.*;

public class DataHelper {
    private DataHelper() {
    }

    // Методы и поля для страницы валидации
    private static String generateCandidateLastName() {
        return new Faker(new Locale("ru_RU")).name().lastName();
    }

    private static String generateCandidateFirstName() {
        return new Faker(new Locale("ru_RU")).name().firstName();
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
  // Методы и поля для анкеты
    @Step
    private static String generateChangeFullName() {
        return new Faker(new Locale("ru_RU")).name().nameWithMiddle();
    }

    @Step
    private static String generateDateBirthAndFullLivingPlace() {
        return new Faker(new Locale("ru_RU")).name().nameWithMiddle() + "" +
        new Faker(new Locale("ru_RU")).address().fullAddress();
    }

    @Step
    private static String generatePassportData() {
        Faker faker = new Faker(new Locale("ru_RU"));
        String startPassportCode = faker.code().imei().substring(0, 4);
        String endPassportCode = faker.code().imei().substring(0, 6);
        String city = faker.address().fullAddress();
        Date date = faker.date().birthday();

        return "Серия:" + startPassportCode + " №" + endPassportCode + " Выдан ОВД г." + city + " дата выдачи:" + date;
    }
    @Value
    public static class Questionnaire {
        String changeFullName;
        String dateBirthAndFullLivingPlace;
        String passportData;
    }

    @Step
    public static Questionnaire generateDataCandidate() {
        return new Questionnaire(generateChangeFullName(),generateDateBirthAndFullLivingPlace(),generateDateBirthAndFullLivingPlace());
    }

}
