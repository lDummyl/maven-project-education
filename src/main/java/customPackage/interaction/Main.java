package customPackage.interaction;

public class Main {
    public static void main(String[] args) {
        // Changed 1st time
        Stateful myStateful = new Stateful();
        myStateful.state = 0;
        changeState(myStateful);
        System.out.println(myStateful.state);
    }

    static void changeState(Stateful myStateful) {
        myStateful.state = -1;
    }

//    static void changeState(int a){
//       a = -2;
//    }


}

class Stateful {
    int state;
}


