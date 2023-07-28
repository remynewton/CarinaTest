package com.laba.solvd.homework;

import com.laba.solvd.homework.pages.TeamsPageBase;
import com.laba.solvd.homework.pages.WatchPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;
import com.laba.solvd.homework.pages.HomePageBase;
import org.testng.asserts.SoftAssert;

public class ESPNTest implements IAbstractTest {
    @Test
    @MethodOwner(owner = "jnewton")
    public void selectTeams() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        TeamsPageBase teamsInfoPage = homePage.selectTeam();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamsInfoPage.getNames("Buffalo Bills"), "Team name not found, selectTeam was unsuccessful.");
        softAssert.assertAll();
    }

    @Test(dataProvider = "login", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testLogin(String email, String password) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.login(email, password), "Logout link not found, login was unsuccessful.");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "jnewton")
    public void playVideo() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        WatchPageBase watchInfoPage = homePage.playVideo();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(watchInfoPage.watchVideo(), "Video playback not found, playVideo was unsuccessful");
    }
}
