package com.shopdi.automation.base.service.impl;

import com.shopdi.automation.base.service.InputService;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class TextService implements InputService {

    @Override
    public void setValue(WebElement webElement, Object value) {
        webElement.sendKeys((CharSequence) value);
    }
}
