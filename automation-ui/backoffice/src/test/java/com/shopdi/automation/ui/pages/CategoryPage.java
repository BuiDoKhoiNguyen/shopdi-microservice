package com.shopdi.automation.ui.pages;

import com.shopdi.automation.base.hook.WebDriverFactory;
import com.shopdi.automation.base.page.BasePage;
import com.shopdi.automation.base.service.InputDelegateService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class CategoryPage extends BasePage {
    private final WebDriverFactory webDriverFactory;

    private final InputDelegateService inputDelegateService;

    public CategoryPage(WebDriverFactory webDriverFactory,
                        InputDelegateService inputDelegateService) {
        super(webDriverFactory);
        this.webDriverFactory = webDriverFactory;
        this.inputDelegateService = inputDelegateService;
    }

    public void clickCreateCategoryButton() {
        WebElement createCategoryButton = webDriverFactory.getChromeDriver().findElement(By.cssSelector("a[href='/catalog/categories/create'] button"));
        createCategoryButton.click();
    }
}
