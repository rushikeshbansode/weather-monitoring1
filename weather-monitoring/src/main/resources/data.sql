{\rtf1\ansi\deff0\nouicompat{\fonttbl{\f0\fnil\fcharset0 Calibri;}}
{\*\generator Riched20 10.0.22621}\viewkind4\uc1 
\pard\sa200\sl276\slmult1\f0\fs22\lang9\par
DROP TABLE IF EXISTS daily_weather_summary;\par
\par
CREATE TABLE daily_weather_summary (\par
    id BIGINT AUTO_INCREMENT PRIMARY KEY,\par
    date DATE NOT NULL,\par
    max_temp DOUBLE NOT NULL,\par
    min_temp DOUBLE NOT NULL,\par
    total_temp DOUBLE NOT NULL,\par
    count INT NOT NULL,\par
    dominant_condition VARCHAR(50) NOT NULL\par
);\par
\par
INSERT INTO daily_weather_summary (date, max_temp, min_temp, total_temp, count, dominant_condition) VALUES\par
('2024-10-20', 30.5, 22.0, 150.0, 5, 'Clear'),\par
('2024-10-21', 28.0, 20.5, 140.0, 5, 'Rain'),\par
('2024-10-22', 32.0, 21.0, 160.0, 5, 'Clouds'),\par
('2024-10-23', 35.0, 25.0, 175.0, 5, 'Clear'),\par
('2024-10-24', 33.0, 23.0, 165.0, 5, 'Thunderstorm');\par
}
 