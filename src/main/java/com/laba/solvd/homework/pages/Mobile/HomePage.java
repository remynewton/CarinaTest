package com.laba.solvd.homework.pages.Mobile;


import com.laba.solvd.homework.pages.HomePageBase;
import com.laba.solvd.homework.pages.NFLPageBase;
import com.laba.solvd.homework.pages.TeamsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//header[@id=\"global-header\"]")
    public ExtendedWebElement globalHeader;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(globalHeader);
    }

    public NFLPageBase getNFLPage() {
        getHeader().clickNFLPage();
        return initPage(driver, NFLPageBase.class);
    }

    @Override
    public TeamsPageBase clickTeamPageLink() {
        NFLPageBase nflPage = getNFLPage();
        return nflPage.clickTeamsLink();
    }

    /**
    @Override
    public void open() {
        super.open();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(globalHeader.getElement()));
    }
    **/
}