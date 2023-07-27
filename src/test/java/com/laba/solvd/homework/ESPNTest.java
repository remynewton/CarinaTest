package com.laba.solvd.homework;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.laba.solvd.homework.pages.HomePageBase;
import org.testng.asserts.SoftAssert;

public class ESPNTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "jnewton")
    public void selectTeams() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        SoftAssert softAssert = new SoftAssert();
    }

    @Test(dataProvider = "login", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testLogin(String email, String password) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.login(email, password), "Logout link not found, login was unsuccessful.");
    }
}
