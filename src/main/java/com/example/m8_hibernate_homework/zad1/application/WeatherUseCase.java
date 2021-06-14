package com.example.m8_hibernate_homework.zad1.application;

import com.example.m8_hibernate_homework.zad1.application.port.WeatherService;
import com.example.m8_hibernate_homework.zad1.domain.Weather;
import com.example.m8_hibernate_homework.zad1.infrastructure.WeatherRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

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

@Slf4j
@Service
public class WeatherUseCase implements WeatherService {

    private RestTemplate restTemplate;
    private WeatherRepository repository;

    private final static String LOCATION_URL = "https://www.metaweather.com/api/location/";
    private final static String WEATHER_URL = "https://www.metaweather.com/api/location/search/?query=";
    private final static String CITY = "warsaw";


    public WeatherUseCase(WeatherRepository repository) {
        this.restTemplate = new RestTemplate();
        this.repository = repository;
    }

    @Override
    public void saveTempToDB() {
        String timeStamp = new Date().toString();

        Double temperature = getTemperature();

        BigDecimal bd = new BigDecimal(temperature);
        bd = bd.setScale(1, RoundingMode.HALF_UP);

        Weather weather = new Weather(timeStamp, bd.doubleValue());

        repository.save(weather);
        log.info("Saved : " + weather);
    }

    private Double getTemperature() {
        Double temperature = null;
        try {
            int woeid = getWoeidFromRestApi(WEATHER_URL, CITY).orElseThrow(() -> new RestApiGetException("No location"));
            temperature = getTemparatureFromRestApi(LOCATION_URL, woeid).orElseThrow(() -> new RestApiGetException("No temperature"));
        } catch (RestApiGetException e) {
            log.error("RestAPI NOK : " + e.getMessage());
        }
        return temperature;
    }

    private Optional<Double> getTemparatureFromRestApi(String url, int woeid) {
        Optional<JsonNode> jsonNode = Stream.of(restTemplate.getForObject(url.concat(String.valueOf(woeid)), JsonNode.class)).findFirst();
        return jsonNode.map(node -> node.get("consolidated_weather").get(0).get("the_temp").asDouble());
    }

    private Optional<Integer> getWoeidFromRestApi(String url, String city) {
        Optional<JsonNode> jsonNode = Stream.of(restTemplate.getForObject(url.concat(city), JsonNode[].class)).findFirst();
        return jsonNode.map(node -> node.get("woeid").asInt());
    }
}
