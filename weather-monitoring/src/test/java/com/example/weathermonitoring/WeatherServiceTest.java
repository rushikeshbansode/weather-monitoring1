import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {
    @Test
    public void testTemperatureConversion() {
        double kelvin = 300.0;
        double celsius = kelvin - 273.15;
        assertEquals(26.85, celsius, 0.01);
    }


}