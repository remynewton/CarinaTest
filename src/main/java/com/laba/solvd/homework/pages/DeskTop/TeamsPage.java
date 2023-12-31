package com.laba.solvd.homework.pages.DeskTop;

import com.laba.solvd.homework.pages.TeamsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = TeamsPageBase.class)
public class TeamsPage extends TeamsPageBase {
    @FindBy(xpath = "//h1[@class='headline headline__h1']")
    private ExtendedWebElement teamsHeader;

    public TeamsPage(WebDriver driver) {
        super(driver);
        setPageURL("/nfl/teams");
        setUiLoadedMarker(teamsHeader);
    }
}
