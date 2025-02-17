package com.steps;

import com.actions.CommonUIActions;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommonUISteps {

    private final CommonUIActions commonUIActions;

    @Given("user navigates to {string}")
    public void userNavigatesToPage(String pageName) {
        commonUIActions.navigateToPage(pageName);
    }

}
