package FactoryMethod;

import FactoryMethod.Cars.Car;
import FactoryMethod.Cars.CarsType;

public class Main {
    public static void main(String[] args) {
        CarStore carStore = new CarStore();

        Car car = carStore.lookCars(CarsType.MINIVAN);

        System.out.println(car);
    }
}
