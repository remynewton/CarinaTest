package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class NFLPageBase extends AbstractESPNPage {

    @FindBy(xpath="//a[contains(@name, \"nfl_teams\")]")
    private ExtendedWebElement teamsLink;
    public NFLPageBase(WebDriver driver) {
        super(driver);
    }

    public TeamsPageBase clickTeamsLink() {
        teamsLink.click();
        return initPage(driver, TeamsPageBase.class);
    }
}
