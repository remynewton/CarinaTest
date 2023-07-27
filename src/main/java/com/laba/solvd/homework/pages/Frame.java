package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Frame extends AbstractPage {
    @FindBy(xpath="//iframe[@id='oneid-iframe']")
    private ExtendedWebElement iframe;
    public Frame(WebDriver driver) {
        super(driver);
    }

    public void click() {
        this.iframe.click();
    }
}
