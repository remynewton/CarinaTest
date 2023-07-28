package com.laba.solvd.homework.pages;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(id="global-user-trigger")
    private ExtendedWebElement userTrigger;
    @FindBy(how=How.CSS, using="a[data-regformid=\"espn\"]")
    private ExtendedWebElement loginLink;
    @FindBy(xpath = "//input[@data-testid=\"InputIdentityFlowValue\"]")
    private ExtendedWebElement emailInput;
    @FindBy(how=How.CSS, using="button[type='submit']")
    private ExtendedWebElement continueButton;
    @FindBy(how=How.XPATH, using="//input[@data-testid=\"InputPassword\"]")
    private ExtendedWebElement passwordInput;
    @FindBy(how=How.CSS, using="button[type='submit']")
    private ExtendedWebElement loginButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Log Out')]")
    private ExtendedWebElement logoutLink;
    @FindBy(css = ".site-logo")
    public ExtendedWebElement pageLogo;
    @FindBy(how=How.CSS, using="li.sports.menu-nfl")
    private ExtendedWebElement nflMenu;
    @FindBy(how=How.XPATH, using="//a[@href='/nfl/teams']")
    private ExtendedWebElement teamsLink;
    @FindBy(how=How.XPATH, using="//a[@name='&lpos=sitenavdefault+sitenav_watch']")
    private ExtendedWebElement watchLink;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageLogo);
    }

    @Override
    public boolean login(String email, String password) {
        userTrigger.hover();
        loginLink.click();
        LoginPage login = new LoginPage(driver);
        login.click();
        emailInput.type(email);
        continueButton.click();
        passwordInput.type(password);
        loginButton.click();
        return logoutLink.isElementPresent();
    }

    @Override
    public TeamsPageBase selectTeam() {
        nflMenu.hover();
        teamsLink.click();
        return initPage(driver, TeamsPageBase.class);
    }

    @Override
    public WatchPageBase playVideo() {
        watchLink.click();
        return initPage(driver, WatchPageBase.class);
    }
}