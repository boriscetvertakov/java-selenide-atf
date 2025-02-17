package com.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-ui.yml")
public class UIProperties {

    @Value("${browser}")
    public String browser;

    @Value("${baseURI}")
    public String baseURI;

    @Value("${headless}")
    public boolean headless;

}

