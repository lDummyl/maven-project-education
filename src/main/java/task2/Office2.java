package task2;

// TODO: 5/21/20 то же самое
public class Office2 {
    static void invitePeople(Object human) {
        if (human == null) {
            System.out.println("DIRECTOR2: Everyone get out!!! No one I need!");
        } else {
            System.out.println("DIRECTOR2: You are the most experience person!\n" +
                    "and you've graduated university, so You Are Welcome " + human);
        }
    }

    public static void main(String[] args) {
        Office.invitePeople(Director.finalChoose());
        Office2.invitePeople(new Director2().finalChoose());
    }
}
