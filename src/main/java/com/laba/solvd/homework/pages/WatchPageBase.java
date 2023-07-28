package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WatchPageBase extends AbstractPage {
    public WatchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean watchVideo();
}
