package SortingExperiment;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReadExperiment readExperiment = new ReadExperiment();
        ArrayList arrayList = readExperiment.readExp("C:\\Users\\Sakro\\Documents\\Java\\maven-project-education\\src\\main\\java\\SortingExperiment\\test");
        System.out.println(arrayList);
    }
}
