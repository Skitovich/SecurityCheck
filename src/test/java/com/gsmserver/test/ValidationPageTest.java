package com.gsmserver.test;

import com.gsmserver.data.DataHelper;
import com.gsmserver.page.ValidationPage;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class ValidationPageTest extends BaseTest {
    int linkLifetime = 360000;

    @BeforeEach
    void openHomePage() {
        open("");
    }

    @Test
    void shouldGenerateLinkTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.fillFormAndGenerateLink(getAuthInfo);
    }

    @Test
    void shouldGenerateLinkTestCopyClipboard() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.fillFormAndGenerateLink(getAuthInfo);
        validationPage.copyClipBoard();
    }

    @Test
    void shouldGenerateLinkWih2000chars() {
        val validationPage = new ValidationPage();
        validationPage.fillForm2000chars();

    }

    @Test
    void shouldGenerateLinkOpenExpiredLink() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.fillFormAndGenerateLink(getAuthInfo);
        sleep(linkLifetime);
        validationPage.openExpiredLink();
    }

}
