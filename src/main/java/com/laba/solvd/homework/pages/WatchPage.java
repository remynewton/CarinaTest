package com.laba.solvd.homework.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = WatchPageBase.class)
public class WatchPage extends WatchPageBase {
    @FindBy(how= How.XPATH, using="//a[@data-track-tileplacement=\"home:row8:Top Videos:slot1\"]")
    private ExtendedWebElement videoLink;

    @FindBy(how=How.XPATH, using="//div[@id='vjs_video_3']")
    private WebElement videoplayback;
    @FindBy(how=How.XPATH, using="")
    private ExtendedWebElement closePopUp;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean watchVideo() {
        videoLink.click();
        VideoPage video = new VideoPage(driver);
        video.click();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (Boolean) jsExecutor.executeScript("return arguments[0].paused;", videoplayback);
    }
}
