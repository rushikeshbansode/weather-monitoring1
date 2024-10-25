import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class DailyWeatherSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private double maxTemp;
    private double minTemp;
    private double totalTemp;
    private int count;
    private String dominantCondition;
}