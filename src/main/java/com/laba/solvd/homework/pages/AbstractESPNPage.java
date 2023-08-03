package com.laba.solvd.homework.pages;

import com.laba.solvd.homework.components.CustomizeItem;
import com.laba.solvd.homework.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractESPNPage extends AbstractPage {
    @FindBy(xpath="/html/body/div[5]/div[3]/div/ul[1]/li[8]/a")
    private ExtendedWebElement loginLink;
    @FindBy(xpath="//article[@id=\"sideLogin-left-rail\"]")
    private CustomizeItem customizeItem;
    @FindBy(how = How.XPATH, using = "//*[@id=\"global-viewport\"]//div[3]//div//ul[1]//li[10]//a")
    private ExtendedWebElement logoutLink;
    @FindBy(xpath="//div[@class='GoogleActiveViewElement']")
    private ExtendedWebElement activeViewElement;
    @FindBy(xpath="//div")
    private ExtendedWebElement theDiv;
    @FindBy(xpath="//header[@id=\"global-header\"]")
    protected Header header;
    @FindBy(xpath="//a[@name='&lpos=sitenavdefault+sitenav_watch']")
    private ExtendedWebElement watchLink;
    public AbstractESPNPage(WebDriver driver) {
        super(driver);
    }

    public void hoverAccountsHelper() {
        getHeader().hoverAccounts();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public boolean checkLoginLink() {
        return loginLink.isClickable();
    }

    public boolean login(String email, String password) {
        LoginPage login = new LoginPage(driver);
        login.executeLogin(email, password);
        hoverAccountsHelper();
        return logoutLink.isElementPresent();
    }

    public CustomizeItem getCustomizeItem() {
        return customizeItem;
    }

    public boolean logout() {
        logoutLink.click();
        hoverAccountsHelper();
        return loginLink.isElementPresent();
    }

    public void switchToAdIFrame() {
        AdPage ad = new AdPage(driver);
        ad.switchToIFrame();
    }

    public boolean findAd() {
        switchToAdIFrame();
        return activeViewElement.isElementPresent();
    }

    public boolean findOtherAd() {
        AdPage ad = new AdPage(driver);
        ad.switchToOtherIFrame();
        return theDiv.isElementPresent();
    }

    public TeamsPageBase clickTeamPageLink() {
        getHeader().hoverNFLMenu();
        getHeader().clickTeamsLink();
        return initPage(driver, TeamsPageBase.class);
    }

    public Header getHeader() {
        return header;
    }

    public WatchPageBase playVideo() {
        watchLink.click();
        return initPage(driver, WatchPageBase.class);
    }

    public EditionPage clickEditionLink() {
        getHeader().hoverMoreMenu();
        getHeader().clickEditionLink();
        return new EditionPage(driver);
    }

    public void switchToEditionIFrame() {
        EditionPage edition = new EditionPage(driver);
        edition.switchToIFrame();
    }
}
