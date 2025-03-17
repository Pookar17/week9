package main;

public class AsphaltCar extends RallyCar {
    public AsphaltCar(double horsepower) {
        super(horsepower);
    }

    @Override
    public double calculatePerformance() {
        return horsepower * 1.8;
    }
}


