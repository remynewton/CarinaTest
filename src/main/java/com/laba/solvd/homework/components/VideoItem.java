package com.laba.solvd.homework.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VideoItem extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(xpath = "//video[@class=\"vjs-tech\"]")
    private ExtendedWebElement video;

    public VideoItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean pauseVideoAndCheck() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].pause();", video.getElement());
        return (boolean) js.executeScript("return arguments[0].paused;", video.getElement());
    }

    public boolean checkVideoPlaying() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(video.getElement()));
        return !(boolean) js.executeScript("return arguments[0].paused;", video.getElement());
    }
}
