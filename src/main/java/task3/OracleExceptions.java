package task3;

// TODO: 9/5/20 наследуй свои эксепшены от RuntimeException догадайся почему
/*Видимо, чтобы не городить огород из блоков try/catch и оставляем это все на откуп пользователю,
который будет создавать объект Оракула. И я так понял, что можно было обойтись встроенным IllegalArgumentException
 */
public class OracleExceptions extends RuntimeException{

    public OracleExceptions(String msg, int maxPossibility){
        System.out.println(msg + maxPossibility);
    }
}
