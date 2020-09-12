package task7.controller;

import task7.model.Pump;

import java.util.Scanner;

public class PumpUI implements UserInterface<Pump> {

    private final Scanner sc;
    private Double flow;
    private Double power;

    public PumpUI() {
        this.sc = new Scanner(System.in);
    }

    public void readData() {
        System.out.println("Please enter the flow ratio below:");
        this.flow = sc.nextDouble();
        System.out.println("Please enter the power ratio below:");
        this.power = sc.nextDouble();
        sc.close();
    }

    public void printResult(Pump pump) {
        System.out.printf(
                "Here is your Pump:\n" +
                        "Art : %s\n" +
                        "Model : %s\n" +
                        "Price : %.2f Euro\n" +
                        "Flow : %.2f\n" +
                        "Pressure : %.2f\n",
                pump.getId(), pump.getModel(), pump.getPrice(), pump.getFlow(), pump.getPressure());
    }

    public Double getFlow() {
        return flow;
    }

    public Double getPower() {
        return power;
    }
}