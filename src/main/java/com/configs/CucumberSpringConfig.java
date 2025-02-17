package com.configs;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = CompScanConfig.class)
public class CucumberSpringConfig {
}
