package multithreading.task.multi;

public class Vault {
    public static int count;
    public static synchronized void increment(){
        count++;
    }
}
