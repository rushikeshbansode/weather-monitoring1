package com.example.weathermonitoring.controller;

import com.example.weathermonitoring.model.DailyWeatherSummary;
import com.example.weathermonitoring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Endpoint to fetch today's weather summary
    @GetMapping("/weather/today")
    public DailyWeatherSummary getTodayWeatherSummary() {
        return weatherService.getTodayWeatherSummary();
    }

    // Endpoint to fetch weather summary for a specific date
    @GetMapping("/weather/date")
    public DailyWeatherSummary getWeatherSummaryByDate(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        return weatherService.getWeatherSummaryByDate(localDate);
    }

    // Endpoint to fetch alerts
    @GetMapping("/weather/alerts")
    public List<String> getAlerts() {
        return weatherService.getAlerts();
    }
}