package com.steps;

import com.actions.CommonUIActions;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;

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

    @Then("User verifies that text {string} is present in {string} field")
    public void userVerifiesThatTextHelloWorldIsPresentInSearchAreaField(String value, String fieldName) {
        SelenideElement element = commonUIActions.getWebElement(fieldName);
        element.shouldHave(value(value));
    }
}
