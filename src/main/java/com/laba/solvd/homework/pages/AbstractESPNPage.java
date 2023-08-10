package com.laba.solvd.homework.pages;

import com.laba.solvd.homework.components.CustomizeItem;
import com.laba.solvd.homework.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AbstractESPNPage extends AbstractPage {

    @FindBy(xpath = "//header[@id=\"global-header\"]")
    protected Header header;
    @FindBy(xpath = "//header[@id=\"global-header\"]//a[text()=\"Log In\" and @data-regformid=\"espn\"]")
    private ExtendedWebElement loginLink;
    @FindBy(xpath = "//article[@id=\"sideLogin-left-rail\"]")
    private CustomizeItem customizeItem;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Log Out')]")
    private ExtendedWebElement logoutLink;
    @FindBy(xpath = "//div[@class='GoogleActiveViewElement']")
    private ExtendedWebElement activeViewElement;

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

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public boolean checkLogoutLink() {
        return logoutLink.isClickable();
    }

    public boolean login(String email, String password) {
        clickLoginLink();
        LoginPage login = new LoginPage(driver);
        login.executeLogin(email, password);
        hoverAccountsHelper();
        return checkLogoutLink();
    }

    public CustomizeItem getCustomizeItem() {
        return customizeItem;
    }

    public boolean logout() {
        clickLogoutLink();
        hoverAccountsHelper();
        return checkLoginLink();
    }

    public void switchToAdIFrame() {
        AdPage ad = new AdPage(driver);
        ad.switchToIFrame();
    }

    public boolean findAd() {
        switchToAdIFrame();
        return activeViewElement.isElementPresent();
    }

    public TeamsPageBase clickTeamPageLink() {
        getHeader().hoverNFLMenu();
        getHeader().clickTeamsLink();
        return initPage(driver, TeamsPageBase.class);
    }

    public WatchPageBase clickWatchPageLink() {
        getHeader().clickWatchLink();
        return initPage(driver, WatchPageBase.class);
    }

    public Header getHeader() {
        return header;
    }

    public EditionPage clickEditionLink() {
        getHeader().hoverMoreMenu();
        getHeader().clickEditionLink();
        return new EditionPage(driver);
    }

    public boolean checkEdition(String test) {
        getHeader().hoverMoreMenu();
        String selector2 = "//*[@id=\"global-nav-mobile\"]//span[text()=\"%s\"]";
        WebElement editionText = driver.findElement(By.xpath(String.format(selector2, test)));
        return editionText.isDisplayed();
    }

    public void switchToEditionIFrame() {
        EditionPage edition = new EditionPage(driver);
        edition.switchToIFrame();
    }
}
