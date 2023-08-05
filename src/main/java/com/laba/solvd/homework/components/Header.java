package com.laba.solvd.homework.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Header extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(how= How.CSS, using="li.sports.menu-nfl")
    private ExtendedWebElement nflMenu;
    @FindBy(xpath="//a[@href='/nfl/teams']")
    private ExtendedWebElement teamsLink;
    @FindBy(xpath="//li[@class=\"pillar more-espn\"]")
    private ExtendedWebElement moreMenu;
    @FindBy(xpath="//a[@id=\"global-user-trigger\"]")
    private ExtendedWebElement accountsTrigger;
    @FindBy(xpath="//button[@id=\"navuserbutton\"]")
    private ExtendedWebElement accountsTeamsTrigger;
    @FindBy(xpath="//header[@id=\"global-header\" or @class=\"db Site__Header__Wrapper sticky top-0\"]//span[@class=\"Editions__Item__Title\"]")
    private ExtendedWebElement editionLink;
    @FindBy(xpath="//*[@id=\"global-nav-mobile\"]/ul/li[7]/a")
    public ExtendedWebElement mobileMoreLink;
    @FindBy(xpath="//*[@id=\"global-nav-mobile\"]/ul/li[7]/ul/li[13]/div/div[2]/span[2]")
    public ExtendedWebElement mobileEditionLink;
    @FindBy(xpath="//a[@name=\"&lpos=sitenavmobile+sports+nfl\"]")
    public ExtendedWebElement nflPageLink;
    @FindBy(xpath="//a[@id=\"global-nav-mobile-trigger\"]")
    public ExtendedWebElement mobileNavTrigger;
    @FindBy(xpath="//li[@class=\"has-sub \"]//span[text()=\"More\"]")
    public ExtendedWebElement moreMenuLink;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hoverNFLMenu() {
        nflMenu.hover();
    }

    public void clickTeamsLink() {
        teamsLink.click();
    }

    public void hoverAccounts() {
        accountsTrigger.hover();
    }

    public void clickAccounts() {accountsTrigger.click();}

    public void hoverTeamsAccounts() {
        accountsTeamsTrigger.hover();
    }

    public void clickTeamsLoginLink() {
        accountsTeamsTrigger.click();
    }

    public void hoverMoreMenu() {
        moreMenu.hover();
    }

    public void clickEditionLink() {
        editionLink.click();
    }

    public void clickMobileNavTrigger() {
        mobileNavTrigger.click();
    }
    public void clickNFLPage() {
        nflPageLink.click();
    }

    public void clickMoreMenuLink() {
        if (moreMenuLink.isElementPresent()) {
            moreMenuLink.click();
        }
    }

    public void clickMobileEditionLink() {
        mobileMoreLink.click();
        mobileEditionLink.click();
    }
}
