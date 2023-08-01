package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdPage extends AbstractESPNPage {
    @FindBy(how= How.XPATH, using="//div[@class=\"ad-banner-wrapper\"]//iframe")
    private ExtendedWebElement iframe;

    public AdPage(WebDriver driver) {
        super(driver);
    }

    public void switchToIFrame() {
        driver.switchTo().frame(iframe.getElement());
    }
}
