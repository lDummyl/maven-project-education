package simpleTasks;

public class Orchestra {
    public static void main(String[] args) {
        MusicalInstrument stradivariViolin = new Violin("Stradivari");
        Sound play = stradivariViolin.play();
        System.out.println(play);
    }

}
