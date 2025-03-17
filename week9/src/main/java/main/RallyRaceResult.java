package main;

import java.util.*;

public class RallyRaceResult {
    private String raceName;
    private Map<Driver, Integer> results = new LinkedHashMap<>();

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
    }

    public void recordResult(Driver driver, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    public void displayResults() {
        System.out.println("Race: " + raceName);
        int position = 1;
        for (Map.Entry<Driver, Integer> entry : results.entrySet()) {
            System.out.println(" Position " + position++ + ": " + entry.getKey().getName() + " - " + entry.getValue() + " points");
        }
        System.out.println();
    }
}
