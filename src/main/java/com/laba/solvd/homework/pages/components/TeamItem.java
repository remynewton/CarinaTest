package com.laba.solvd.homework.pages.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public class TeamItem extends AbstractUIObject implements ICustomTypePageFactory {
    protected TeamItem(WebDriver driver) {
        super(driver);
    }
}
