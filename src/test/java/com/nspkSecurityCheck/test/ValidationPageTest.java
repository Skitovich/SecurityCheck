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

    // Генерирование ссылки и отображение ее в поле "Ссылка для кандидата"
    @Test
    void fillFieldsWithValidDataAndGenerateLinkTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.fillFormAndGenerateLink(getAuthInfo);
    }

    // При нажатии на кнопку "Копировать в буфер обмена" ссылка копируется в буфер обмена
    @Test
    void shouldGenerateLinkTestCopyClipboardTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.fillFormAndGenerateLink(getAuthInfo);
        validationPage.copyClipBoard();
    }

    // Проверить длину полей - максимально по 2000 символов в каждом
    @Test
    void shouldGenerateLinkWih2000charsTest() {
        val validationPage = new ValidationPage();
        validationPage.fillForm2000chars();

    }

    /* Проверить, что при попытке пользователем открыть просроченную ссылку,
    1)  осуществляется проверка на ее актуальность (время жизни (ttl) сгенерированного UUID).
    2) кандидат не может открыть анкету, и получает соответствующее оповещение о том, что ссылка невалидна */
    @Test
    void shouldGenerateLinkOpenExpiredLinkTest() {
        val validationPage = new ValidationPage();
        val getAuthInfo = DataHelper.getFullNameInfo();
        validationPage.fillFormAndGenerateLink(getAuthInfo);
        sleep(linkLifetime);
        validationPage.openExpiredLink();
    }
}
