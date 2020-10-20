package customPackage.interaction;

import static java.lang.System.exit;

public class MyExceptionPractice03 {
    public void newMethod(){
        RuntimeException f = new RuntimeException();
        try {
            throw f;
        } catch (RuntimeException runtimeException) {
            System.out.println("another catch");
        }
        System.out.println("This is a runtime exception");
    }
    public static void main(String[] args){
        NullPointerException e = new NullPointerException();
        try{
            throw e;
        } catch (NullPointerException nullPointerException) {
            System.out.println("catch");
        }
        System.out.println("What about this?");

        MyExceptionPractice03 mep = new MyExceptionPractice03();
        mep.newMethod();

    }
}
