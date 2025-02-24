package com.actions;

import com.codeborne.selenide.SelenideElement;
import com.services.ui.UIService;
import com.storage.ScenarioKeys;
import com.utilities.ScenarioContext;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Keys;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommonUIActions {

    private final UIService uiService;

    public void navigateToPage(String pageName) {
        Object pageObject = uiService.navigateToPage(pageName);
        ScenarioContext.save(ScenarioKeys.CURRENT_PAGE, pageObject);
    }

    public void userInsertsIntoTextBox(String value, String textBoxName) {
        Object currentPage = ScenarioContext.get(ScenarioKeys.CURRENT_PAGE);
        SelenideElement textBox = uiService.retrieveWebElementByName(textBoxName, currentPage);
        textBox.sendKeys(value);
    }

    public void userSendKeyToWebElement(Keys key, String webElement) {
        Object currentPage = ScenarioContext.get(ScenarioKeys.CURRENT_PAGE);
        SelenideElement element = uiService.retrieveWebElementByName(webElement, currentPage);
        element.sendKeys(key);

    }

    public String getFieldTextContent(String fieldName) {
       return getWebElement(fieldName).text();
    }

    public SelenideElement getWebElement(String elem) {
        Object currentPage = ScenarioContext.get(ScenarioKeys.CURRENT_PAGE);
        return uiService.retrieveWebElementByName(elem, currentPage);
    }
}
