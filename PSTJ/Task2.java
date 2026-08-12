import java.util.*;
import java.util.stream.Collectors;

class Reading {
    String sensorId;
    double temperature;

    Reading(String sensorId, double temperature) {
        this.sensorId = sensorId;
        this.temperature = temperature;
    }

    public String getSensorId() {
        return sensorId;
    }

    public double getTemperature() {
        return temperature;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Reading> readings = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String sensorId = scanner.next();
            double temperature = scanner.nextDouble();
            readings.add(new Reading(sensorId, temperature));
        }
        readings.stream()
                .filter(r -> r.getTemperature() > 50)
                .collect(Collectors.groupingBy(
                        Reading::getSensorId,
                        Collectors.averagingDouble(Reading::getTemperature)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> System.out.printf("%s %.1f%n", entry.getKey(), entry.getValue()));

        scanner.close();
    }
}