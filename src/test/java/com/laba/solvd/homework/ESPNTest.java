package com.laba.solvd.homework;

import com.laba.solvd.homework.components.CustomizeItem;
import com.laba.solvd.homework.components.TeamItem;
import com.laba.solvd.homework.pages.AbstractESPNPage;
import com.laba.solvd.homework.pages.EditionPage;
import com.laba.solvd.homework.pages.HomePageBase;
import com.laba.solvd.homework.pages.TeamsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.apache.commons.collections.CollectionUtils;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ESPNTest implements IAbstractTest, IMobileUtils {
    @Test(dataProvider = "teams", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testSelectTeams(@NotNull List<String> expected) {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
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
        homePage.hoverAccountsHelper();
        softAssert.assertTrue(homePage.checkLoginLink(), "Login link not clickable, checkLoginLink was unsuccessful.");
        softAssert.assertTrue(homePage.login(email, password), "Logout link not found, login was unsuccessful.");
        softAssert.assertTrue(homePage.logout(), "Login link not found, logout was unsuccessful.");
        softAssert.assertAll();
    }

    @Test(dataProvider = "login", dataProviderClass = DP.class, groups = {"desktop"})
    @MethodOwner(owner = "jnewton")
    public void testOtherLogin(String email, String password) {
        AbstractESPNPage homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SoftAssert softAssert = new SoftAssert();
        CustomizeItem customizeItem = homePage.getCustomizeItem();
        softAssert.assertTrue(customizeItem.checkLoginLink(), "Login link not clickable, checkLoginLink failed.");
        customizeItem.clickLoginLink();
        softAssert.assertTrue(homePage.login(email, password), "Logout link not found for other way, login was unsuccessful.");
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
        TeamsPageBase teamsInfoPage = homePage.clickTeamPageLink();
        softAssert.assertTrue(teamsInfoPage.isPageOpened(), "Teams page is not opened");
        softAssert.assertTrue(teamsInfoPage.findAd(), "Ad not found on Teams page, findAd was unsuccessful.");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "jnewton")
    public void testChangeEdition() {
        AbstractESPNPage homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        SoftAssert softAssert = new SoftAssert();
        EditionPage edition = homePage.clickEditionLink();
        homePage.switchToEditionIFrame();
        edition.switchEdition("UK");
        softAssert.assertTrue(homePage.checkEdition("UK"));
        softAssert.assertAll();
    }
}
