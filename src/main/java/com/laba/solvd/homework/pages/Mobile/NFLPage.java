package com.laba.solvd.homework.pages.Mobile;

import com.laba.solvd.homework.pages.NFLPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NFLPageBase.class)
public class NFLPage extends NFLPageBase {
    public NFLPage(WebDriver driver) {
        super(driver);
        setPageURL("/nfl");
    }
}
