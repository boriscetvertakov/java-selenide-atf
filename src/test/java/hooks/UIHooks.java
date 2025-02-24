package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.configs.UIProperties;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class UIHooks {

    @Autowired
    UIProperties uiProperties;

    @Before(value = "@UI")
    public void initDriver() {
        Configuration.browser = uiProperties.browser;
        Configuration.baseUrl = uiProperties.baseURI;
        Configuration.timeout = uiProperties.timeout * 1000;
//        Configuration.pageLoadStrategy = "eager";
        Selenide.open(uiProperties.baseURI);
    }
}
