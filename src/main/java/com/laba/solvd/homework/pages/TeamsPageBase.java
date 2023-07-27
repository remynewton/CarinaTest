package com.laba.solvd.homework.pages;

import com.laba.solvd.homework.pages.components.TeamItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import java.util.List;

public abstract class TeamsPageBase extends AbstractPage {

    protected TeamsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<TeamItem> getTeams();
}
