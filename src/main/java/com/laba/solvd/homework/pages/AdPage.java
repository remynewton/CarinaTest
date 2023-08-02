package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdPage extends AbstractESPNPage {
    @FindBy(xpath="//div[@class=\"ad-banner-wrapper\"]//iframe")
    private ExtendedWebElement iframe;
    @FindBy(xpath="//div[@class=\"Ad Ad--banner ad-slot\"]//iframe")
    private ExtendedWebElement otherIframe;

    public AdPage(WebDriver driver) {
        super(driver);
    }

    public void switchToIFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe.getElement()));
    }

    public void switchToOtherIFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(otherIframe.getElement()));
    }
}
