package simpleTasks;

public abstract class MusicalInstrument {
    String material; // из чего сделан инструмент
    double weight;  // вес
    double width;   //ширина
    double height; //высота
    double length;  //длина

    double lowerBoundOfFrequencyRange; // нижн граница частотного диапазона
    double higherBoundOfFrequencyRange;  //верх граница частотного диапазона

    String brandName;
    String color;


    public abstract Sound play();
}
