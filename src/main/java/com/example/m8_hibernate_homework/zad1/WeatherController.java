package com.example.m8_hibernate_homework.zad1;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


/**
 * https://www.metaweather.com/api/location/search/?query=london
 * [
 * {
 * "title": "London",
 * "location_type": "City",
 * "woeid": 44418,
 * "latt_long": "51.506321,-0.12714"
 * }
 * ]
 * <p>
 * ******************
 * https://www.metaweather.com/api/location/44418/
 * {
 * "consolidated_weather": [
 * {
 * "id": 5624837130158080,
 * "weather_state_name": "Heavy Cloud",
 * "weather_state_abbr": "hc",
 * "wind_direction_compass": "WNW",
 * "created": "2021-06-14T09:32:01.770204Z",
 * "applicable_date": "2021-06-14",
 * "min_temp": 15.510000000000002,
 */
@Controller
@EnableScheduling
public class WeatherController {

    private RestTemplate restTemplate;
    private WeatherRepository repository;

    public WeatherController(WeatherRepository repository) {
        this.restTemplate = new RestTemplate();
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(cron = "0 * * * * *")
    public void init() {
        JsonNode forObject = restTemplate.getForObject("https://www.metaweather.com/api/location/search/?query=london", JsonNode.class);
        String timeStamp = new Date().toString();

        int woeid = forObject.get(0).get("woeid").asInt();
        JsonNode forObject1 = restTemplate.getForObject("https://www.metaweather.com/api/location/" + woeid, JsonNode.class);

        Double temperature = forObject1.get("consolidated_weather").get(0).get("the_temp").asDouble();
        Weather weather = new Weather(timeStamp, temperature);

        System.out.println(weather);
        repository.save(weather);

    }


}
