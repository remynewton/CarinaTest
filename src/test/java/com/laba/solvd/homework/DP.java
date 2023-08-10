package com.laba.solvd.homework;

import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DP implements IAbstractDataProvider {

    @DataProvider(name = "coord")
    public Object[][] weatherMethod() {
        return new Object[][]{
                {"53.9006", "27.5590", "Minsk City"},
                {"6.5244", "3.3792", "Shogunle"},
                {"12.0464", "77.0428", "Yelandūr"}
        };
    }

    @DataProvider(name = "teams")
    public static Object[][] espnMethod() {
        return new Object[][]{
                {Arrays.asList("Arizona Cardinals",
                        "Atlanta Falcons",
                        "Baltimore Ravens",
                        "Buffalo Bills",
                        "Carolina Panthers",
                        "Chicago Bears",
                        "Cincinnati Bengals",
                        "Cleveland Browns",
                        "Dallas Cowboys",
                        "Denver Broncos",
                        "Detroit Lions",
                        "Green Bay Packers",
                        "Houston Texans",
                        "Indianapolis Colts",
                        "Jacksonville Jaguars",
                        "Kansas City Chiefs",
                        "Las Vegas Raiders",
                        "Los Angeles Chargers",
                        "Los Angeles Rams",
                        "Miami Dolphins",
                        "Minnesota Vikings",
                        "New England Patriots",
                        "New Orleans Saints",
                        "New York Giants",
                        "New York Jets",
                        "Philadelphia Eagles",
                        "Pittsburgh Steelers",
                        "San Francisco 49ers",
                        "Seattle Seahawks",
                        "Tampa Bay Buccaneers",
                        "Tennessee Titans",
                        "Washington Commanders")}
        };
    }
}
