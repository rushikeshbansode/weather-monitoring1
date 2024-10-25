import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {
    private static final String[] CITIES = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};
    private final RestTemplate restTemplate = new RestTemplate();
    private final AppConfig appConfig;
    private final Map<String, DailyWeatherSummary> dailySummaries = new HashMap<>();

    @Autowired
    public WeatherService(AppConfig appConfig) {
        this.appConfig = appConfig;
        scheduleWeatherUpdates();
    }

  public DailyWeatherSummary getTodayWeatherSummary() {
        LocalDate today = LocalDate.now();
        return dailySummaries.get(today);
    }

    // Method to get weather summary by date
    public DailyWeatherSummary getWeatherSummaryByDate(LocalDate date) {
        return dailySummaries.get(date);
    }

    // Method to get triggered alerts
    public List<String> getAlerts() {
        // Return a list of alerts (you can modify this based on your alert logic)
        List<String> alerts = new ArrayList<>();
        for (String city : CITIES) {
            // Check if there are alerts for each city
            if (alertCount.get(city) > 0) {
                alerts.add("Alert: " + city + " temperature exceeded threshold.");
            }
        }
        return alerts;
    }

    @Scheduled(fixedRate = 300000) // Every 5 minutes
    public void fetchWeatherUpdates() {
        for (String city : CITIES) {
            String weatherData = fetchWeather(city);
            processWeatherData(city, weatherData);
        }
    }

    private String fetchWeather(String city) {
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, appConfig.getApiKey());
        return restTemplate.getForObject(url, String.class);
    }

    private void processWeatherData(String city, String weatherData) {
        JSONObject json = new JSONObject(weatherData);
        double tempKelvin = json.getJSONObject("main").getDouble("temp");
        double tempCelsius = tempKelvin - 273.15;

        updateDailySummary(city, tempCelsius, json.getJSONArray("weather").getJSONObject(0).getString("main"));
        checkAlerts(city, tempCelsius);
    }

    private void updateDailySummary(String city, double tempCelsius, String condition) {
       
    }

    private void checkAlerts(String city, double tempCelsius) {
        if (tempCelsius > appConfig.getTemperatureThreshold()) {
            System.out.println("Alert: " + city + " temperature exceeded " + appConfig.getTemperatureThreshold() + "°C");
        }
    }
}