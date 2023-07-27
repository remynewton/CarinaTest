package com.laba.solvd.homework.pages;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(id="global-user-trigger")
    private ExtendedWebElement userTrigger;
    @FindBy(how=How.CSS, using="a[data-regformid=\"espn\"]")
    private ExtendedWebElement loginLink;
    @FindBy(how=How.CSS, using="input[type='email']")
    private ExtendedWebElement emailInput;

    @FindBy(how=How.CSS, using="button[type='submit']")
    private ExtendedWebElement continueButton;

    @FindBy(how=How.XPATH, using="//input[@type='email']")
    private ExtendedWebElement passwordInput;
    @FindBy(how=How.CSS, using="button[type='submit']")
    private ExtendedWebElement loginButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Log Out')]")
    private ExtendedWebElement logoutLink;

    @FindBy(css = ".site-logo")
    public ExtendedWebElement pageLogo;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageLogo);
    }

    @Override
    public boolean login(String email, String password) {
        userTrigger.click();
        loginLink.click();
        assertElementPresent(emailInput);
        emailInput.type(email,10,ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("input[type='email']")));
        continueButton.click();
        assertElementPresent(passwordInput);
        passwordInput.type(password);
        loginButton.click();
        return logoutLink.isElementPresent();
    }
}
