package com.nspkSecurityCheck.test;

import com.nspkSecurityCheck.data.DataHelper;
import com.nspkSecurityCheck.page.ValidationPage;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class ValidationPageTest extends BaseTest {
    int linkLifetime = 90000;

    @BeforeEach
    void openHomePage() {
        open("");
    }

    @Test
    void fillFieldsWithValidDataAndGenerateLink() {
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
