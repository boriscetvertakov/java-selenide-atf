package com.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.services.ui",
        "com.actions",
        "com.configs"
})
public class CompScanConfig {
}
