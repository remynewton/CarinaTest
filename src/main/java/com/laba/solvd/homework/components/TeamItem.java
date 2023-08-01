package com.laba.solvd.homework.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TeamItem extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(xpath = ".//h2")
    public ExtendedWebElement headerLink;

    public TeamItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readHeader() {
        return headerLink.getText();
    }
}
