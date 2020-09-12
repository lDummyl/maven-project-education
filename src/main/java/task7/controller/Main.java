package task7.controller;

/*
	Реализовать программу подбора насосов используя реализацию задачи №6
	создать 5 констант для бытовых циркуляционных насосов разной мощности
	При вводе значений расход напор, нужно подобрать самый дешевый, подходящий.

*/

import task7.model.Pump;
import task7.service.PumpCalculator;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        PumpUI ui = new PumpUI();
        ui.readData();
        PumpCalculator pc = new PumpCalculator();
        Optional<Pump> pump = pc.get(ui.getFlow(), ui.getPower());
        if (pump.isPresent())
            ui.printResult(pump.get());
        else
            System.out.println("Suitable pump hasn't been found");
    }

}
