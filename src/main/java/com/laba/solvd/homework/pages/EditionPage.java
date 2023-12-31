package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditionPage extends AbstractPage {
    @FindBy(xpath = "//article[@class=\"lightbox editions-mgmt js-bloomed\"]//iframe")
    private ExtendedWebElement iframe;
    @FindBy(xpath = "//div[@class=\"lightbox-container\"]//article//iframe")
    private ExtendedWebElement mobileIFrame;

    public EditionPage(WebDriver driver) {
        super(driver);
    }

    public void switchEdition(String input) {
        String selector = "//span[text()=\"%s\"]";
        WebElement edition = driver.findElement(By.xpath(String.format(selector, input)));
        edition.click();
    }

    public void switchToIFrame() {
        driver.switchTo().frame(iframe.getElement());
    }

    public void switchToMobileIFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(80)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(mobileIFrame.getElement()));
    }
}
