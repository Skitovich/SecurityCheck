package com.gsmserver.test;


import com.gsmserver.data.DataHelper;
import com.gsmserver.page.ValidationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("");
    }

    @Test
    void shouldCopy() {
        new ValidationPage().
                jumpNewTab(DataHelper.getRequiredFields());
    }


}
