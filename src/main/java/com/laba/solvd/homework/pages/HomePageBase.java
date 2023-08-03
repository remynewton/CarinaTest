package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractESPNPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public void open() {
        super.open();
    }
}
