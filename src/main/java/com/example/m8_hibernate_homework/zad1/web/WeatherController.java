package com.example.m8_hibernate_homework.zad1.web;

import com.example.m8_hibernate_homework.zad1.application.WeatherUseCase;
import com.example.m8_hibernate_homework.zad1.application.port.WeatherService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;


@Controller
@EnableScheduling
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherUseCase service) {
        this.service = service;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(cron = "0 * * * * *")
    public void init() {
        service.saveTempToDB();
    }

}
