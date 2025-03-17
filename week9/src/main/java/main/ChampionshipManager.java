package main;

import java.util.*;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRace(RallyRaceResult race) {
        races.add(race);
    }

    public void displayStandings() {
        drivers.sort((a, b) -> b.getTotalPoints() - a.getTotalPoints());
        System.out.println("1. " + drivers.get(0).getName() + " (" + drivers.get(0).getCountry() + "): " + drivers.get(0).getTotalPoints() + " points");
        for (int i = 1; i < drivers.size(); i++) {
            System.out.println((i + 1) + ". " + drivers.get(i).getName() + " (" + drivers.get(i).getCountry() + "): " + drivers.get(i).getTotalPoints() + " points");
        }
        System.out.println();
    }

    public void displayChampion() {
        System.out.println("===== CHAMPIONSHIP LEADER =====");
        System.out.println(drivers.get(0).getName() + " with " + drivers.get(0).getTotalPoints() + " points");
        System.out.println();
    }

    public void displayStatistics() {
        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + drivers.size());
        System.out.println("Total Races: " + races.size());
        double avgPoints = drivers.stream().mapToInt(Driver::getTotalPoints).average().orElse(0.0);
        System.out.printf("Average Points Per Driver: %.2f\n", avgPoints);
        
        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver driver : drivers) {
            countryPoints.put(driver.getCountry(), countryPoints.getOrDefault(driver.getCountry(), 0) + driver.getTotalPoints());
        }

        String topCountry = Collections.max(countryPoints.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most Successful Country: " + topCountry);
        System.out.println("Total Championship Points: " + drivers.stream().mapToInt(Driver::getTotalPoints).sum());
        System.out.println();
    }
}
