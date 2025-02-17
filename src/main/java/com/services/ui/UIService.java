package com.services.ui;

import com.codeborne.selenide.Selenide;
import com.configs.UIProperties;
import com.utilities.ReflectionUtilityPO;
import com.utilities.ScenarioContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.storage.Keys.CURRENT_PAGE;

@Service
@RequiredArgsConstructor
public class UIService {

    public final UIProperties uiProperties;

    public Object retrievePageObjectByName(String pageName) {
        Object pageObject = ReflectionUtilityPO.getPageObjectByBusinessName(pageName);
        return pageObject;
    }

    public String retrievePageUriByName(String pageName) {
        Object pageObject = retrievePageObjectByName(pageName);
        String pageUri = ReflectionUtilityPO.getUriFromPO(pageObject);
        return uiProperties.baseURI + pageUri;
    }

    public String retrievePageUriFromPageObj(Object pageObject) {
        return ReflectionUtilityPO.getUriFromPO(pageObject);
    }
    
    public Object navigateToPage(String pageName) {
        Object pageObject = retrievePageObjectByName(pageName);
        String uri = uiProperties.baseURI + ReflectionUtilityPO.getUriFromPO(pageObject);
        Selenide.open(uri);
        return pageObject;
    }
}
