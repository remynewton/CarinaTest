package com.laba.solvd.homework.pages;

import com.laba.solvd.homework.components.VideoItem;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.naming.ldap.ExtendedRequest;

public abstract class WatchPageBase extends AbstractESPNPage {
    @FindBy(xpath = "//a[@data-track-tileplacement=\"home:row8:Top Videos:slot1\"]")
    private ExtendedWebElement videoLink;
    @FindBy(xpath = "//*[@id=\"fittPageContainer\"]/div[contains(@class, \"Watch\")]")
    private VideoItem video;
    @FindBy(xpath = "//*[@id=\"fittPortal_0\"]//header//button")
    private ExtendedWebElement closeButton;
    public WatchPageBase(WebDriver driver) {
        super(driver);
    }

    public VideoItem getVideoItem() {
        videoLink.click();
        return video;
    }

    public void closePopUp() {
        closeButton.click();
    }

    @Override
    public void open() {
        super.openURL(Configuration.get("watch").get());
    }
}
