package com.laba.solvd.homework;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/data/2.5/weather?q=${city}&appid=${api_token}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/weather/response_schema.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class WeatherAPIMethodForCity extends AbstractApiMethodV2 {
    public WeatherAPIMethodForCity(String city) {
        replaceUrlPlaceholder("base_url", String.valueOf(Configuration.get("weather_api_url")));
        replaceUrlPlaceholder("api_token", String.valueOf(Configuration.get("api_token")));
        replaceUrlPlaceholder("city", city);
    }
}
