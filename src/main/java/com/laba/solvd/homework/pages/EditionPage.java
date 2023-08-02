package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditionPage extends AbstractPage {
    @FindBy(xpath="//article[@class=\"lightbox editions-mgmt js-bloomed\"]//iframe")
    private ExtendedWebElement iframe;

    protected EditionPage(WebDriver driver) {
        super(driver);
    }

    public boolean switchEdition(String input, String test) {
        driver.switchTo().frame(iframe.getElement());
        String selector = "//span[text()=\"%s\"]";
        WebElement edition = driver.findElement(By.xpath(String.format(selector, input)));
        edition.click();
        String selector2 = "//h2[text()=\"%s\"]";
        WebElement follow = driver.findElement(By.xpath(String.format(selector, input)));
        return follow.isDisplayed();
    }
}
