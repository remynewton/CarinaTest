package com.laba.solvd.homework.pages.Mobile;


import com.laba.solvd.homework.pages.EditionPage;
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
    private ExtendedWebElement globalHeader;
    @FindBy(xpath = "//*[@id=\"global-viewport\"]/div[3]/div/ul[1]/li[8]/a")
    private ExtendedWebElement mobileLoginLink;
    @FindBy(xpath="//*[@id=\"global-viewport\"]/div[3]/div/ul[1]/li[10]/a")
    private ExtendedWebElement mobileLogoutLink;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(globalHeader);
    }

    @Override
    public void hoverAccountsHelper() {
        getHeader().clickAccounts();
    }

    public NFLPageBase getNFLPage() {
        getHeader().clickMobileNavTrigger();
        getHeader().clickNFLPage();
        return initPage(driver, NFLPageBase.class);
    }

    @Override
    public TeamsPageBase clickTeamPageLink() {
        NFLPageBase nflPage = getNFLPage();
        //getHeader().clickMoreMenuLink();
        return nflPage.clickTeamsLink();
    }

    @Override
    public EditionPage clickEditionLink() {
        getHeader().clickMobileNavTrigger();
        getHeader().clickMobileEditionLink();
        return new EditionPage(driver);
    }
    public void switchToEditionIFrame() {
        EditionPage edition = new EditionPage(driver);
        edition.switchToMobileIFrame();
    }

    @Override
    public void clickLoginLink() {
        mobileLoginLink.click();
    }

    @Override
    public boolean checkLoginLink() {
        return mobileLoginLink.isClickable();
    }

    @Override
    public void clickLogoutLink() { mobileLogoutLink.click(); }

    @Override
    public boolean checkLogoutLink() { return mobileLogoutLink.isClickable(); }


    /**
    @Override
    public void open() {
        super.open();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(globalHeader.getElement()));
    }
    **/
}