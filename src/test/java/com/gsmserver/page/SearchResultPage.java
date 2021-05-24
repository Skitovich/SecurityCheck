package com.gsmserver.page;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    public String getSearchResultTitle() {
        return $(".search-title-highlight").getText();
    }
}
