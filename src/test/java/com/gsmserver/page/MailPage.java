package com.gsmserver.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.gsmserver.data.DataHelper;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MailPage {
    private static SelenideElement refresh = $x("//span[@data-click-action='mailbox.check']");



    public MailPage() {
    }

    @Step
    public void refresh() {
        refresh.waitUntil(Condition.visible,7000 ).click();
    }

    @Step
    public void generateTitle(DataHelper.FullName fullName) {
        $x("//span[contains(text(),'"+ fullName.getLastName() +" "+fullName.getPatronymic()+"']").
                shouldBe(Condition.visible).click();
    }
}
