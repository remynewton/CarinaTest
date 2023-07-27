package com.laba.solvd.homework.pages;

import com.laba.solvd.homework.pages.components.TeamItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class TeamsPage extends TeamsPageBase {
    @FindBy(how=How.XPATH, using="//div[@class='ContentList mt4 ContentList--NoBorder']//div[@class='ContentList__Item']")
    private List<TeamItem> teams;

    protected TeamsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<TeamItem> getTeams() {
        return teams;
    }
}
