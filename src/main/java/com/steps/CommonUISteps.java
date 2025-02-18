package com.steps;

import com.actions.CommonUIActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Keys;

@RequiredArgsConstructor
public class CommonUISteps {

    private final CommonUIActions commonUIActions;

    @Given("User navigates to {string}")
    public void userNavigatesToPage(String pageName) {
        commonUIActions.navigateToPage(pageName);
    }

    @Given("User inserts {string} in textbox: {string}")
    public void userInsertsIntoTextBox(String value, String textBoxName) {
        commonUIActions.userInsertsIntoTextBox(value, textBoxName);
    }

    @And("User pushes Enter button on textbox: {string}")
    public void userPushesEnterButtonOnTextboxSearchArea(String textBox) {
        commonUIActions.userSendKeyToWebElement(Keys.ENTER, textBox);
    }
}
