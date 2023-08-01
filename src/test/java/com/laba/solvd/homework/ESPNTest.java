package com.laba.solvd.homework;

import com.laba.solvd.homework.components.TeamItem;
import com.laba.solvd.homework.pages.AbstractESPNPage;
import com.laba.solvd.homework.pages.HomePageBase;
import com.laba.solvd.homework.pages.TeamsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.commons.collections.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ESPNTest implements IAbstractTest {
    @Test(dataProvider = "teams", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testSelectTeams(List<String> expected) {
        AbstractESPNPage homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        TeamsPageBase teamsInfoPage = homePage.clickTeamPageLink();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamsInfoPage.isPageOpened(), "Teams page is not opened");
        List<TeamItem> teams = teamsInfoPage.getTeams();
        List<String> teamHeaders = teams.stream()
                .map(TeamItem::readHeader)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        Assert.assertFalse(CollectionUtils.isEmpty(teamHeaders), "Teams not found!");
        System.out.println(teamHeaders);
        for (int i = 0; i < expected.size(); i++) {
            softAssert.assertEquals(teamHeaders.get(i), expected.get(i), "Teams don't match expected!");
        }
        softAssert.assertAll();
    }

    @Test(dataProvider = "login", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testLogin(String email, String password) {
        AbstractESPNPage homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.login(email, password), "Logout link not found, login was unsuccessful.");
        softAssert.assertTrue(homePage.logout(), "Login link not found, logout was unsuccessful.");
        softAssert.assertAll();
    }

    @Test(dataProvider = "login", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testOtherLogin(String email, String password) {
        AbstractESPNPage homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.loginAnotherWay(email, password), "Logout link not found for other way, login was unsuccessful.");
        softAssert.assertTrue(homePage.logout(), "Login link not found, logout was unsuccessful.");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "jnewton")
    public void testAdLoaded() {
        AbstractESPNPage homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.findAd(), "Ad not found, findAd was unsuccessful.");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "jnewton")
    public void testChangeEdition() {
        AbstractESPNPage homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.changeEdition("India", "Follow ESPN India"));
        softAssert.assertAll();
    }

    /**
     @Test()
     @MethodOwner(owner = "jnewton")
     public void playVideo() {
     HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
     homePage.open();
     Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
     WatchPageBase watchInfoPage = homePage.playVideo();
     SoftAssert softAssert = new SoftAssert();
     softAssert.assertTrue(watchInfoPage.watchVideo(), "Video playback not found, playVideo was unsuccessful");
     }
     **/
}
