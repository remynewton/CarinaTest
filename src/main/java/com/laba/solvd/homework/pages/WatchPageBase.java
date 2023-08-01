package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class WatchPageBase extends AbstractESPNPage {
    @FindBy(how= How.XPATH, using="//a[@data-track-tileplacement=\"home:row8:Top Videos:slot1\"]")
    private ExtendedWebElement videoLink;
    @FindBy(how=How.XPATH, using="//div[@id='vjs_video_3']")
    private WebElement videoplayback;
    @FindBy(how=How.XPATH, using="")
    private ExtendedWebElement closePopUp;
    public WatchPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean watchVideo() {
        videoLink.click();
        VideoPage video = new VideoPage(driver);
        video.switchToIFrame();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (Boolean) jsExecutor.executeScript("return arguments[0].paused;", videoplayback);
    }
}
