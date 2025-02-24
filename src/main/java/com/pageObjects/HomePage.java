package com.pageObjects;

import com.annotations.ATFPage;
import com.annotations.ATFWebElement;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

@ATFPage(pageName = "Home Page", url = "/")
public class HomePage {

    @ATFWebElement(elementName = "Search Area")
    public SelenideElement searchArea = $x("//input[@data-test-id='search-input']");
}