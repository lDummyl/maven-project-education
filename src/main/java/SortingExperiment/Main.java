package SortingExperiment;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReadExperiment readExperiment = new ReadExperiment();
        Showene showene = new Showene();
        RemovePoint removePoint = new RemovePoint();
        ArrayList arrayList = readExperiment.readExp("C:\\Users\\Sakro\\Documents\\Java\\maven-project-education\\src\\main\\java\\SortingExperiment\\test");

        System.out.println(arrayList.size());
        arrayList = removePoint.removeBadPoints(arrayList, showene.makeShoweneTest(arrayList));
        System.out.println(arrayList.size());
    }
}
