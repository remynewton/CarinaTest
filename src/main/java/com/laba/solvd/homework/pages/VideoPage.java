package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class VideoPage extends AbstractPage {
    @FindBy(xpath="//div//iframe[@allow=\"autoplay\"]")
    private ExtendedWebElement iframe;
    public VideoPage(WebDriver driver) {
        super(driver);
    }

    public void click() {
        driver.switchTo().frame(iframe.getElement());
    }
}
