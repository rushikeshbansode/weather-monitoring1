import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${threshold.temperature}")
    private double temperatureThreshold;

    public String getApiKey() {
        return apiKey;
    }

    public double getTemperatureThreshold() {
        return temperatureThreshold;
    }
}