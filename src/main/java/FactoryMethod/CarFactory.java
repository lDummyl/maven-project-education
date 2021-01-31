package FactoryMethod;

import FactoryMethod.Cars.*;

public class CarFactory {
    public Car createCar(CarsType carType) {
        Car car = null;

        if (carType == CarsType.COUPE) {
            car = new CoupeCar();
        } else if (carType == CarsType.SUV) {
            car = new Suv();
        } else if (carType == CarsType.MINIVAN) {
            car = new Minivan();
        } else if (carType == CarsType.SEDAN) {
            car = new SedanCar();
        } else if (carType == CarsType.TRUCK) {
            car = new Truck();
        }

        return car;
    }
}
