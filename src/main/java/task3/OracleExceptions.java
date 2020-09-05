package task3;

// TODO: 9/5/20 наследуй свои эксепшены от RuntimeException догадайся почему
public class OracleExceptions extends Exception{

    public OracleExceptions(String msg, int maxPossibility){
        System.out.println(msg + maxPossibility);
    }
}
