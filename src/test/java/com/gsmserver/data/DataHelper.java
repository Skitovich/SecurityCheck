package com.gsmserver.data;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }


    private static String getCandidateLastName() {
      return new Faker(new Locale("ru_RU")).name().lastName();
    }

    private static String getCandidateFirstName() {
        return new Faker(new Locale("ru_RU")).name().firstName();
    }

    private static String getCandidatePatronymic() {
        return new Faker(new Locale("ru_RU")).name().firstName();
    }


    @Value
    public static class RequiredFields {
        String firstName;
        String lastName;
        String patronymic;
    }
    @Step
    public static RequiredFields getRequiredFields() {
        return new RequiredFields(getCandidateFirstName(),getCandidateLastName(),getCandidatePatronymic());
    }

}
