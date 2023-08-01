package com.laba.solvd.homework.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends AbstractPage {
    @FindBy(xpath="//iframe[@id=\"oneid-iframe\"]")
    private ExtendedWebElement iframe;
    @FindBy(xpath = "//input[@data-testid=\"InputIdentityFlowValue\"]")
    private ExtendedWebElement emailInput;
    @FindBy(how= How.CSS, using="button[type='submit']")
    private ExtendedWebElement continueButton;
    @FindBy(how=How.XPATH, using="//input[@data-testid=\"InputPassword\"]")
    private ExtendedWebElement passwordInput;
    @FindBy(how=How.CSS, using="button[type='submit']")
    private ExtendedWebElement loginButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void executeLogin(String email, String password) {
        driver.switchTo().frame(iframe.getElement());
        emailInput.type(email);
        continueButton.click();
        passwordInput.type(password);
        loginButton.click();
    }
}
