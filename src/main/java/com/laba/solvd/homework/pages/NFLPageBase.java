package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class NFLPageBase extends AbstractESPNPage {

    @FindBy(xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[7]/a")
    private ExtendedWebElement teamsLink;

    public NFLPageBase(WebDriver driver) {
        super(driver);
    }

    public TeamsPageBase clickTeamsLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", teamsLink.getElement());
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(teamsLink.getElement()));
        teamsLink.click();
        return initPage(driver, TeamsPageBase.class);
    }
}
