package com.laba.solvd.homework;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

import java.util.Random;

@Endpoint(url = "${base_url}/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=${api_token}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/weather/response_schema.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class WeatherAPIMethod extends AbstractApiMethodV2 {
    Random rand = new Random();
    double latitude = 24.396308 + rand.nextDouble() * (24.98805);
    double longitude = -125.000000 + rand.nextDouble() * (191.93457);
    public WeatherAPIMethod() {
        replaceUrlPlaceholder("base_url", String.valueOf(Configuration.get("weather_api_url").get()));
        replaceUrlPlaceholder("api_token", String.valueOf(Configuration.get("api_token").get()));
        replaceUrlPlaceholder("latitude", String.valueOf(latitude));
        replaceUrlPlaceholder("longitude", String.valueOf(longitude));
    }

    public WeatherAPIMethod(String lat, String lon) {
        lat = (lat == null) ? String.valueOf(latitude) : lat;
        lon = (lon == null) ? String.valueOf(longitude) : lon;
        replaceUrlPlaceholder("base_url", String.valueOf(Configuration.get("weather_api_url").get()));
        replaceUrlPlaceholder("api_token", String.valueOf(Configuration.get("api_token").get()));
        replaceUrlPlaceholder("latitude", lat);
        replaceUrlPlaceholder("longitude", lon);
    }

    public WeatherAPIMethod(String token) {
        token = (token == null) ? String.valueOf(Configuration.get("api_token")) : token;
        replaceUrlPlaceholder("base_url", String.valueOf(Configuration.get("weather_api_url").get()));
        replaceUrlPlaceholder("api_token", token);
        replaceUrlPlaceholder("latitude", String.valueOf(latitude));
        replaceUrlPlaceholder("longitude", String.valueOf(longitude));
    }
}
