package com.laba.solvd.homework.pages;

import com.laba.solvd.homework.components.Header;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AbstractESPNPage extends AbstractPage {
    @FindBy(how= How.CSS, using="a[data-regformid=\"espn\"]")
    private ExtendedWebElement loginLink;
    @FindBy(how=How.XPATH, using="//section[@class=\"col-one\"]//button[text()=\"Log In\"]")
    private ExtendedWebElement otherLoginLink;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Log Out')]")
    private ExtendedWebElement logoutLink;
    @FindBy(how=How.XPATH, using="//div[@class='GoogleActiveViewElement']")
    private ExtendedWebElement activeViewElement;
    @FindBy(how=How.XPATH, using="//header[@id=\"global-header\" or @class=\"db Site__Header__Wrapper sticky top-0\"]")
    private Header header;
    @FindBy(how=How.XPATH, using="//a[@name='&lpos=sitenavdefault+sitenav_watch']")
    private ExtendedWebElement watchLink;
    public AbstractESPNPage(WebDriver driver) {
        super(driver);
    }

    public void hoverAccountsHelper() {
        if (this instanceof HomePageBase) {
            header.hoverAccounts();
        } else {
            header.hoverTeamsAccounts();
        }
    }
    public boolean login(String email, String password) {
        hoverAccountsHelper();
        loginLink.click();
        LoginPage login = new LoginPage(driver);
        login.executeLogin(email, password);
        hoverAccountsHelper();
        return logoutLink.isElementPresent();
    }

    public boolean loginAnotherWay(String email, String password) {
        otherLoginLink.click();
        LoginPage login = new LoginPage(driver);
        login.executeLogin(email, password);
        hoverAccountsHelper();
        return logoutLink.isElementPresent();
    }
    public boolean logout() {
        logoutLink.click();
        hoverAccountsHelper();
        return loginLink.isElementPresent();
    }

    public boolean findAd() {
        AdPage ad = new AdPage(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ad.switchToIFrame();
        return activeViewElement.isElementPresent();
    }

    public TeamsPageBase clickTeamPageLink() {
        header.hoverNFLMenu();
        header.clickTeamsLink();
        return initPage(driver, TeamsPageBase.class);
    }

    public Header getHeader() {
        return header;
    }

    public WatchPageBase playVideo() {
        watchLink.click();
        return initPage(driver, WatchPageBase.class);
    }

    public boolean changeEdition(String input, String test) {
        header.hoverMoreMenu();
        header.clickEditionLink();
        EditionPage edition = new EditionPage(driver);
        return edition.switchEdition(input, test);
    }

    @Override
    public void open() {
        super.open();
    }
}
