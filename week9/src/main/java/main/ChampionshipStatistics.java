package main;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ChampionshipStatistics {
    public static double calculateAveragePoints(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).average().orElse(0.0);
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver d : drivers) {
            countryPoints.put(d.getCountry(), countryPoints.getOrDefault(d.getCountry(), 0) + d.getTotalPoints());
        }
        return countryPoints.entrySet().stream()
            .max((a, b) -> a.getValue() - b.getValue())
            .map(Map.Entry::getKey)
            .orElse("N/A");
    }
}

