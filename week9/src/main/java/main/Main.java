package main;

public class Main {
    public static void main(String[] args) {
        ChampionshipManager championship = ChampionshipManager.getInstance();

      
        Driver driver1 = new Driver("Sébastien Ogier", "France");
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland");
        Driver driver3 = new Driver("Ott Tänak", "Estonia");
        Driver driver4 = new Driver("Thierry Neuville", "Belgium");

        
        championship.registerDriver(driver1);
        championship.registerDriver(driver2);
        championship.registerDriver(driver3);
        championship.registerDriver(driver4);

        
        RallyRaceResult race1 = new RallyRaceResult("==== Rally Finland (Jyväskylä) ====");
        race1.recordResult(driver1, 25);
        race1.recordResult(driver3, 18);
        race1.recordResult(driver2, 15);
        race1.recordResult(driver4, 12);
        championship.addRace(race1);

        RallyRaceResult race2 = new RallyRaceResult("==== Monte Carlo Rally (Monaco) ====");
        race2.recordResult(driver2, 25);
        race2.recordResult(driver4, 18);
        race2.recordResult(driver1, 15);
        race2.recordResult(driver3, 12);
        championship.addRace(race2);

        
        championship.displayStandings();
        championship.displayChampion();
        championship.displayStatistics();

        System.out.println("==== THE RESULTS IS ====");
        race1.displayResults();
        race2.displayResults();

       
        GravelCar gravelCar = new GravelCar(282.33);
        AsphaltCar asphaltCar = new AsphaltCar(262.2);

        System.out.println("||||CAR PERFORMANCE RATINGS||||");
        System.out.printf("Gravel Car Performance: %.1f\n", gravelCar.calculatePerformance());
        System.out.printf("Asphalt Car Performance: %.1f\n", asphaltCar.calculatePerformance());
    }
}
