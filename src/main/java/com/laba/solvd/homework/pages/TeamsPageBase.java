package com.laba.solvd.homework.pages;

import com.laba.solvd.homework.components.Header;
import com.laba.solvd.homework.components.TeamItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

public abstract class TeamsPageBase extends AbstractESPNPage {
    @FindBys({@FindBy(xpath = "//section[@class='TeamLinks flex items-center']")})
    private List<TeamItem> teams;
    @FindBy(xpath="//button[@id=\"navuserbutton\"]")
    private ExtendedWebElement teamsLoginLink;
    @FindBy(xpath="//header[@class=\"db Site__Header__Wrapper sticky top-0\"]")
    private Header teamsHeader;

    public TeamsPageBase(WebDriver driver) {
        super(driver);
    }

    public List<TeamItem> getTeams() {
        return teams;
    }

    @Override
    public void hoverAccountsHelper() {
        getHeader().hoverTeamsAccounts();
    }

    @Override
    public void clickLoginLink() {
        getHeader().clickTeamsLoginLink();
    }

    @Override
    public Header getHeader() {
        return teamsHeader;
    }

    @Override
    public void switchToAdIFrame() {
        AdPage ad = new AdPage(driver);
        ad.switchToOtherIFrame();
    }

    @Override
    public void open() {
        super.open();
    }
}