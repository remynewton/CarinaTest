package com.laba.solvd.homework.pages.Mobile;

import com.laba.solvd.homework.pages.NFLPageBase;
import com.laba.solvd.homework.pages.TeamsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NFLPageBase.class)
public class NFLPage extends NFLPageBase {
    public NFLPage(WebDriver driver) {
        super(driver);
        setPageURL("/nfl");
    }
}
