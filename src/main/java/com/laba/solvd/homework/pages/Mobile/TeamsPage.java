package com.laba.solvd.homework.pages.Mobile;

import com.laba.solvd.homework.pages.TeamsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TeamsPageBase.class)
public class TeamsPage extends TeamsPageBase {
    @FindBy(how = How.XPATH, using = "//h1[@class='headline headline__h1']")
    private ExtendedWebElement teamsHeader;

    public TeamsPage(WebDriver driver) {
        super(driver);
        setPageURL("/nfl/teams");
        setUiLoadedMarker(teamsHeader);
    }
}
