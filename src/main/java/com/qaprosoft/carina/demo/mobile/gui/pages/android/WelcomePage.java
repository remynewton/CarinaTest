package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

	@FindBy(xpath = "//*[contains(@resource-id, 'title')][@text = 'Welcome to Carina World!']")
	private ExtendedWebElement title;

	@FindBy(id = "next_button")
	private ExtendedWebElement nextBtn;

	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isPageOpened() {
		return title.isElementPresent();
	}

	@Override
	public LoginPageBase clickNextBtn() {
		nextBtn.click();
		return initPage(getDriver(), LoginPageBase.class);
	}

}