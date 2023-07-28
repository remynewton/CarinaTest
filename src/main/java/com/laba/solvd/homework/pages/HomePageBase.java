package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean login(String email, String password);

    public abstract TeamsPageBase selectTeam();

    public abstract WatchPageBase playVideo();

    @Override
    public void open() {
        super.open();
    }
}
