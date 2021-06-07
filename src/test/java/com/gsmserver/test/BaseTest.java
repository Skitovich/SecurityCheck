package com.gsmserver.test;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.gsmserver.page.QuestionnairePage;
import io.qameta.allure.selenide.AllureSelenide;

public abstract class BaseTest {

    static {
        Configuration.baseUrl = "localhost:5002/";
        Configuration.browser = WebDriverRunner.FIREFOX;
        Configuration.headless = false;
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.fileDownload = FileDownloadMode.HTTPGET;
        Configuration.fastSetValue = false;
        Configuration.downloadsFolder = "C:\\Users\\Ruslan\\Desktop\\Java\\SecurityCheck";
        Configuration.savePageSource = false;
        Configuration.screenshots = false;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
