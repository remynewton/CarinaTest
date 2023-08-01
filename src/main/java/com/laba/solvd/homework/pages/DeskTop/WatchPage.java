package com.laba.solvd.homework.pages.DeskTop;

import com.laba.solvd.homework.pages.WatchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = WatchPageBase.class)
public class WatchPage extends WatchPageBase {

    public WatchPage(WebDriver driver) {
        super(driver);
    }
}
