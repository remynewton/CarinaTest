package com.laba.solvd.homework;

import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.utils.config.Configuration;
import org.testng.annotations.DataProvider;

public class DP implements IAbstractDataProvider {

    @DataProvider(name="login")
    public Object[][] espnMethod() {
        return new Object[][]{
                {Configuration.get("email").get(), Configuration.get("password").get()}
        };
    }

    @DataProvider(name = "coord")
    public Object[][] weatherMethod() {
        return new Object[][]{
                {"53.9006", "27.5590", "Minsk City"},
                {"6.5244", "3.3792", "Shogunle"},
                {"12.0464", "77.0428", "Yelandūr"}
        };
    }
}
