package com.laba.solvd.homework.pages.Mobile;


import com.laba.solvd.homework.pages.EditionPage;
import com.laba.solvd.homework.pages.HomePageBase;
import com.laba.solvd.homework.pages.NFLPageBase;
import com.laba.solvd.homework.pages.TeamsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Override
    public boolean checkEdition(String test) {
        getHeader().clickMobileNavTrigger();
        getHeader().clickMobileMoreMenu();
        String selector2 = "//*[@id=\"global-nav-mobile\"]//span[text()=\"%s\"]";
        WebElement editionText = driver.findElement(By.xpath(String.format(selector2, test)));
        return editionText.isDisplayed();
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
}