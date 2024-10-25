import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyWeatherSummaryRepository extends JpaRepository<DailyWeatherSummary, Long> {
}