package main;

public abstract class RallyCar {
    protected double horsepower;

    public RallyCar(double horsepower) {
        this.horsepower = horsepower;
    }

    public abstract double calculatePerformance();
}
