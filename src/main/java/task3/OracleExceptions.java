package task3;

public class OracleExceptions extends Exception{

    public OracleExceptions(String msg, int maxPossibility){
        System.out.println(msg + maxPossibility);
    }
}
