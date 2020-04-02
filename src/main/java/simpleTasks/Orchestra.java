package simpleTasks;

public class Orchestra {
    public static void main(String[] args) {
        Violin stradivariViolin = new Violin("Stradivari");
        Sound play = stradivariViolin.play();
        System.out.println(play);

    }
}
