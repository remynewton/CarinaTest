package com.laba.solvd.homework;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherAPITest implements IAbstractTest {

    @Test(dataProvider = "coord", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testGetWeatherInfo(String latitude, String longitude, String city) {
        var api = new WeatherAPIMethod(latitude, longitude);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/_get/response_schema.json");
    }

    @Test
    @MethodOwner(owner = "jnewton")
    public void testGetWeatherInfoWithWrongToken() {
        var api2 = new WeatherAPIMethod("1234");
        var response = api2.callAPI();
        Assert.assertEquals(response.getStatusCode(), 401,
                "Expected HTTP 401 Unauthorized status code, but got " + response.getStatusCode());
    }

    @Test
    @MethodOwner(owner = "jnewton")
    public void testInvalidLatitude() {
        var api3 = new WeatherAPIMethod(null, "1000");
        var response3 = api3.callAPI();
        Assert.assertEquals(response3.getStatusCode(), 400,
                "Expected HTTP 400 Bad Request status code, but got " + response3.getStatusCode());
    }

    @Test(invocationCount = 50, threadPoolSize = 10, timeOut = 30000)
    @MethodOwner(owner = "jnewton")
    public void loadTestGetWeatherInfo() {
        var api = new WeatherAPIMethod();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
    }

    @Test(dataProvider = "coord", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testGetWeatherInfoByCity(String latitude, String longitude, String city) {
        var api = new WeatherAPIMethodForCity(city);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponseAgainstSchema("api/weather/_get/response_schema.json");
    }
}