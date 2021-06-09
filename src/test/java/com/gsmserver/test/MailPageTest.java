package com.gsmserver.test;

import com.gsmserver.page.MailPage;
import org.junit.jupiter.api.Test;

public class MailPageTest {

    @Test
    void shouldEnterYandexMailTest() {
        MailPage mailPage = new MailPage();
        mailPage.goToYandexMail();
        mailPage.loginYandexMail();
        mailPage.openMailByTitle();
    }
}

