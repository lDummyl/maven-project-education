package customPackage.interaction;

public class MainThree {
    public static void main(String[] args) {
        Integer lclState = 0;
        changeState(lclState);
        System.out.println(lclState);
    }

    static void changeState(Integer lclState) {
        lclState = new Integer(-1);
    }

}
