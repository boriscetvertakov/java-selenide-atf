package com.actions;

import com.services.ui.UIService;
import com.storage.Keys;
import com.utilities.ScenarioContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommonUIActions {

    private final UIService uiService;

    public void navigateToPage(String pageName) {
        Object pageObject = uiService.navigateToPage(pageName);
        ScenarioContext.save(Keys.CURRENT_PAGE, pageObject);
    }
}
