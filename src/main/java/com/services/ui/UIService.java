package com.services.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.configs.UIProperties;
import com.utilities.ReflectionUtilityPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UIService {

    private final UIProperties uiProperties;

    public String retrievePageUriByName(String pageName) {
        Object pageObject = retrievePageObjectByName(pageName);
        String pageUri = ReflectionUtilityPO.getUriFromPO(pageObject);
        return uiProperties.baseURI + pageUri;
    }

    public String retrievePageUriFromPageObj(Object pageObject) {
        return ReflectionUtilityPO.getUriFromPO(pageObject);
    }

    public SelenideElement retrieveWebElementByName(String elementName, Object pageObject) {
        SelenideElement webElement = ReflectionUtilityPO.getWebElementFromPO(elementName, pageObject);
        return webElement;
    }

    public Object navigateToPage(String pageName) {
        Object pageObject = retrievePageObjectByName(pageName);
        String uriPath = ReflectionUtilityPO.getUriFromPO(pageObject);
        Selenide.open(uriPath);
        return pageObject;
    }

    private static Object retrievePageObjectByName(String pageName) {
        return ReflectionUtilityPO.getPageObjectByBusinessName(pageName);
    }

}
