package com.laba.solvd.homework.pages.DeskTop;

import com.laba.solvd.homework.pages.WatchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = WatchPageBase.class)
public class WatchPage extends WatchPageBase {
    @FindBy(xpath = "//nav[@aria-label=\"Watch Navigation\"]")
    private ExtendedWebElement watchNav;
    public WatchPage(WebDriver driver) {
        super(driver);
        setPageURL("/watch");
        setUiLoadedMarker(watchNav);
    }
}
