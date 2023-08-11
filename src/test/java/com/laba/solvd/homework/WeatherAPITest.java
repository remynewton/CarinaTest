package com.laba.solvd.homework;

import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherAPITest implements IAbstractTest {

    @Test(dataProvider = "coord", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testGetWeatherInfo(String latitude, String longitude) {
        var api = new WeatherAPIMethod(latitude, longitude);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        Response response = api.callAPI();
        Assert.assertEquals(latitude.substring(0,3), response.jsonPath().getString("coord.lat").substring(0,3), "Latitude doesn't match expected.");
        Assert.assertEquals(longitude.substring(0,3), response.jsonPath().getString("coord.lon").substring(0,3), "Longitude doesn't match expected.");
        api.validateResponseAgainstSchema("api/weather/response_schema.json");
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
        Response response = api.callAPI();
        double latitude = response.jsonPath().getDouble("coord.lat");
        double longitude = response.jsonPath().getDouble("coord.lon");
        Assert.assertTrue(latitude > -90 && latitude < 90, "Latitude doesn't match expected range.");
        Assert.assertTrue(longitude > -180 && longitude < 180, "Longitude doesn't match expected range.");
        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<Double>withPredicate("tempMinPredicate", tempMin -> tempMin > -50 && tempMin < 50)
                .<Double>withPredicate("tempMaxPredicate", tempMax -> tempMax > -50 && tempMax < 50)
                .<Integer>withPredicate("humidityPredicate", humidity -> humidity >= 0 && humidity <= 100);
        api.validateResponse(JSONCompareMode.LENIENT, comparatorContext);
    }

    @Test(dataProvider = "coord", dataProviderClass = DP.class)
    @MethodOwner(owner = "jnewton")
    public void testGetWeatherInfoByCity(String latitude, String longitude, String city) {
        var api = new WeatherAPIMethodForCity(city);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        Response response = api.callAPI();
        Assert.assertEquals(city, response.jsonPath().getString("name"), "City doesn't match expected.");
        api.validateResponseAgainstSchema("api/weather/response_schema.json");
    }
}