package com.example.m8_hibernate_homework.zad1.infrastructure;

import com.example.m8_hibernate_homework.zad1.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather,Long> {
}
