package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.AdvancedSearchPage;
import com.zebrunner.carina.demo.gui.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject {

    @FindBy(xpath = "//footer[@class='page-footer']//a[contains(text(), 'Notes')]")
    private ExtendedWebElement notesLink;

    @FindBy(xpath = "//footer[@class='page-footer']//a[contains(text(), 'Write for us')]")
    private ExtendedWebElement  writeForUsLink;

    @FindBy(xpath = "//footer[@class='page-footer']//a[contains(text(), 'Subscribe to our mailing list')]")
    private ExtendedWebElement  subscribeLink;

    @FindBy(xpath = "//footer[@class='page-footer']//a[contains(text(), 'Contact us')]")
    private ExtendedWebElement  contactUsLink;

    @FindBy(xpath = "//footer[@class='page-footer']//a[contains(text(), 'Hire a Sofware Testing/QA Company')]")
    private ExtendedWebElement  hireCompanyLink;

    @FindBy(xpath = "//footer[@class='page-footer']//a[contains(text(), 'Search Terms')]")
    private ExtendedWebElement  searchTermsLink;

    @FindBy(xpath = "//footer[@class='page-footer']//a[contains(text(), 'Privacy and Cookie Policy')]")
    private ExtendedWebElement  privacyPolicyLink;

    @FindBy(xpath = "//footer[@class='page-footer']//a[contains(text(), 'Advanced Search')]")
    private ExtendedWebElement  advancedSearchLink;

    @FindBy(xpath = "//footer[@class='page-footer']//a[contains(text(), 'Orders and Returns')]")
    private ExtendedWebElement  ordersAndReturnsLink;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public ExtendedWebElement getAdvancedSearchLink() {
        return advancedSearchLink;
    }

    public AdvancedSearchPage clickAdvancedSearchLink(){
        advancedSearchLink.click();
        return new AdvancedSearchPage(getDriver());
    }
}
