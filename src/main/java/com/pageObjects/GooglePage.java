package com.pageObjects;

import com.annotations.ATFPage;
import com.annotations.ATFWebElement;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@ATFPage(pageName = "Google Page", url = "/")
public class GooglePage {

    @ATFWebElement(elementName = "Search Area")
    @FindBy(xpath = "//input[@class='gLFyf']")
    public SelenideElement searchArea;

    @ATFWebElement(elementName = "Search Area kakat")
    @FindBy(xpath = "//input[@class='gLFyf']")
    public SelenideElement searchAreaSelenideeq = $x("//input[@class='gLFyf']");
}
