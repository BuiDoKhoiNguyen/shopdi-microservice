package com.shopdi.automation.ui.pages;

import com.shopdi.automation.base.hook.WebDriverFactory;
import com.shopdi.automation.base.page.BasePage;
import com.shopdi.automation.base.util.WebElementUtil;
import static com.shopdi.automation.base.util.WebElementUtil.getWebElementBy;
import static com.shopdi.automation.base.util.WebElementUtil.waitElement;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class CategoryItemDetailPage extends BasePage {
    private final WebDriverFactory webDriverFactory;

    public CategoryItemDetailPage(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
        this.webDriverFactory = webDriverFactory;
    }

    public boolean existedButtonAddToCart() {
        waitElement(webDriverFactory.getChromeDriver(), How.XPATH, "//button[span[text()='Add to cart']]", 1);
        return WebElementUtil.isElementPresent(webDriverFactory.getChromeDriver(), How.XPATH, "//button[span[text()='Add to cart']]");
    }

    public void clickAddToCart() {
        WebElement btnAddToCart = getWebElementBy(webDriverFactory.getChromeDriver(), How.XPATH, "//button[span[text()='Add to cart']]");
        btnAddToCart.click();
    }

    public void clickObBasket() {
        this.wait(Duration.ofSeconds(2)); // hidden layer add successfully
        WebElement btnBasket = getWebElementBy(webDriverFactory.getChromeDriver(), How.CLASS_NAME, "header-cart");
        btnBasket.click();
    }

    public String getProductName() {
        WebElement title = getWebElementBy(webDriverFactory.getChromeDriver(), How.CLASS_NAME, "title");
        return title.getText();
    }

}
