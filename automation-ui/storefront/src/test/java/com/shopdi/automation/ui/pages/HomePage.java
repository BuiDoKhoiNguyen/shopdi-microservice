package com.shopdi.automation.ui.pages;

import static com.shopdi.automation.base.util.WebElementUtil.getWebElementBy;

import com.shopdi.automation.base.hook.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class HomePage {
    private final WebDriverFactory webDriverFactory;

    public HomePage(WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }

    public void clickLogin() {
        WebElement loginBtn = getWebElementBy(webDriverFactory.getChromeDriver(), How.LINK_TEXT, "Login");
        loginBtn.click();
    }

    public String getUsername() {
        WebElement title = getWebElementBy(webDriverFactory.getChromeDriver(), How.ID, "user-dropdown");
        return title.getText();
    }
}
