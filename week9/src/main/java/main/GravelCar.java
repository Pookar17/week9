package main;

public class GravelCar extends RallyCar {
    public GravelCar(double horsepower) {
        super(horsepower);
    }

    @Override
    public double calculatePerformance() {
        return horsepower * 1.5;
    }
}


