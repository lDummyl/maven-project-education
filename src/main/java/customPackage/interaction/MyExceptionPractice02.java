package customPackage.interaction;

public class MyExceptionPractice02 {
    public MyExceptionPractice02(String txt){
        txt = "Let us create a new exception!";
    }
    public void methodOne(){
       if (true) {
            try {
            } catch (NullPointerException e) {
                System.out.println("Not Good at all!");
                System.exit(-1);
            } catch (RuntimeException e) {
                System.out.println("Exception has been caught");
            }
        }
    }
    public static void main(String[] args) {
        MyExceptionPractice02 me = new MyExceptionPractice02("This is method one");
        me.methodOne();
    }
}

//    public static void main(String[] args) {
//        System.out.println("Program start");
//        if (true) {
//            try {
//                Egg egg = provideEgg();
//                egg.growUp();
//            } catch (NullPointerException e) {
//                System.out.println("Not Good at all!");
//                System.exit(-1);
//            } catch (RuntimeException e) {
//                System.out.println("Exception has been caught");
//            }
//        }
//        System.out.println("Program stop");
//    }
//
