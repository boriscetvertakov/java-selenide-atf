package hooks;

import com.codeborne.selenide.Configuration;
import com.configs.UIProperties;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class UIHooks {

    @Autowired
    UIProperties uiProperties;

    @Before(value = "@UI")
    public void initDriver() {
        Configuration.browser = uiProperties.browser;
        Configuration.remote = uiProperties.baseURI;
    }
}
