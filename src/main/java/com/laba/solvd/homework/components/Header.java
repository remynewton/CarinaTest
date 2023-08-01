package com.laba.solvd.homework.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.zebrunner.carina.utils.config.Configuration;

public class Header extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(how= How.CSS, using="li.sports.menu-nfl")
    private ExtendedWebElement nflMenu;
    @FindBy(how=How.XPATH, using="//a[@href='/nfl/teams']")
    private ExtendedWebElement teamsLink;
    @FindBy(how=How.XPATH, using="//li[@class=\"pillar more-espn\"]")
    private ExtendedWebElement moreMenu;
    @FindBy(how=How.XPATH, using="//a[@id=\"global-user-trigger\"]")
    private ExtendedWebElement accountsTrigger;
    @FindBy(how=How.XPATH, using="//button[@id=\"navuserbutton\"]")
    private ExtendedWebElement accountsTeamsTrigger;
    @FindBy(how=How.XPATH, using="//header[@id=\"global-header\" or @class=\"db Site__Header__Wrapper sticky top-0\"]//span[@class=\"Editions__Item__Title\"]")
    private ExtendedWebElement editionLink;

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

    public void hoverTeamsAccounts() {
        accountsTeamsTrigger.hover();
    }

    public void hoverMoreMenu() {
        moreMenu.hover();
    }

    public void clickEditionLink() {
        editionLink.click();
    }
}
