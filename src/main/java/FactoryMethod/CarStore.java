package FactoryMethod;

import FactoryMethod.Cars.Car;
import FactoryMethod.Cars.CarsType;

public class CarStore {
    private final CarFactory factory;

    public CarStore() {
        this.factory = new CarFactory();
    }

    public Car lookCars(CarsType carType){
        Car car = factory.createCar(carType);

        return car;
    }
}
