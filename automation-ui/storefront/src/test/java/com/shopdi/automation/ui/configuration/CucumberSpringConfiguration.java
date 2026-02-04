package com.shopdi.automation.ui.configuration;

import com.shopdi.automation.ui.AutomationUiApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = AutomationUiApplication.class)
public class CucumberSpringConfiguration {
}
