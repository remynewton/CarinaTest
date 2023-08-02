package com.laba.solvd.homework.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CustomizeItem extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(xpath=".//button[text()=\"Log In\"]")
    private ExtendedWebElement otherLoginLink;
    public CustomizeItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickLoginLink() {
        otherLoginLink.click();
    }

    public boolean checkLoginLink() {
        return otherLoginLink.isClickable();
    }
}
