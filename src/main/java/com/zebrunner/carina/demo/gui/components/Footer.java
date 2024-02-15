package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.pages.desktop.AdvancedSearchFormPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject {

    @FindBy(xpath = "//li[@class='nav item']//a[contains(text(), 'Advanced Search')]")
    private ExtendedWebElement  advancedSearchLink;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getAdvancedSearchLink() {
        return advancedSearchLink;
    }

    public AdvancedSearchFormPage clickAdvancedSearchLink(){
        advancedSearchLink.click();
        return new AdvancedSearchFormPage(getDriver());
    }
}
