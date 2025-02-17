package com.pageObjects;

import com.annotations.ATFPage;
import com.annotations.ATFWebElement;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

@ATFPage(pageName = "Google Page", url = "/")
public class GooglePage {

    @ATFWebElement(elementName = "Search Area")
    public SelenideElement searchArea = $x("//textarea[@class='gLFyf']");
}
