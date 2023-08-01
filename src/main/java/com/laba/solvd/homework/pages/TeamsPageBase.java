package com.laba.solvd.homework.pages;

import com.laba.solvd.homework.components.TeamItem;
import com.zebrunner.carina.utils.IWebElement;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class TeamsPageBase extends AbstractESPNPage {
    @FindBys({@FindBy(how = How.XPATH, using = "//section[@class='TeamLinks flex items-center']")})
    private List<TeamItem> teams;

    public TeamsPageBase(WebDriver driver) {
        super(driver);
    }

    public List<TeamItem> getTeams() {
        return teams;
    }
}