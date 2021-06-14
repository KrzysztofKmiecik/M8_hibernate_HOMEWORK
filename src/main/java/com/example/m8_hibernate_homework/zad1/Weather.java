package com.example.m8_hibernate_homework.zad1;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "weathers")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="time_stamp")
    private String date;
    @Column(name = "temperature")
    private Double temperature;

    public Weather( String date, Double temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public Weather() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Weather.class.getSimpleName() + "[", "]")
                .add("Id=" + Id)
                .add("date='" + date + "'")
                .add("temperature=" + temperature)
                .toString();
    }
}
