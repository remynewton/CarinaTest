package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath="//iframe[@id=\"oneid-iframe\"]")
    private ExtendedWebElement iframe;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void click() {
        driver.switchTo().frame(iframe.getElement());
    }
}
