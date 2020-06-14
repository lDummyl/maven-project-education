package task2;

public class BankAccount {

    private int sum;

    public BankAccount(int sum){
        this.sum = sum;
    }

    public void add(int money){
        sum = sum + money;
    }

    public void remove(int money){
        if(money < sum){
            sum = sum - money;
        }else {
            throw new RuntimeException("Not enough money");
        }
    }

    public int getSum(){return sum;}

}
