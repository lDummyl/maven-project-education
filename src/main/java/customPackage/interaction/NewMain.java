package customPackage.interaction;

public class NewMain {
    public static void main(String[] args) {
        int lclState = 0;
        changeState(lclState);
        System.out.println(lclState);
    }

    static void changeState(int lclState) {
        lclState = -1;
//        return lclState;
    }

}
