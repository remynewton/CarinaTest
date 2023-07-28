package com.laba.solvd.homework.pages;

import com.zebrunner.carina.utils.IWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = TeamsPageBase.class)
public class TeamsPage extends TeamsPageBase {
    @FindBy(how = How.CSS, using = ".di.clr-gray-01.h5")
    private List<ExtendedWebElement> names;

    public TeamsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean getNames(String teamName) {
        for (IWebElement name : names) {
            if (name.getText().equalsIgnoreCase(teamName)) {
                return true;
            }
        }
        return false;
    }
}
