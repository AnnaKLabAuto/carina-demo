package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.components.common.FooterBase;
import com.zebrunner.carina.demo.gui.pages.desktop.AdvancedSearchFormPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends FooterBase {

    @FindBy(xpath = "//li[@class='nav item']//a[contains(text(), 'Advanced Search')]")
    private ExtendedWebElement  advancedSearchLink;

    public Footer(WebDriver driver) {
        super(driver);
    }

    @Override
    public AdvancedSearchFormPage clickAdvancedSearchLink() {
        advancedSearchLink.click();
        return new AdvancedSearchFormPage(getDriver());
    }

}
