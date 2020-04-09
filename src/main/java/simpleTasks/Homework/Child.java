package simpleTasks.Homework;

public class Child extends Person {
    public void openMathBook(int numberOfTask) {

    }

    public String askHelp(Checker checker) throws Exception{
        if (checker.getClass() == Father.class){
           return "Ask mother";
        }
        if (checker.getClass() == Mother.class){
            return "Try harder. You should do your best";
        }
//        throw new Exception("Don't know you mr " +  checker.getClass().getName()); // TODO: 4/10/20 делай эксепшены более информативными
        throw new Exception("?");
    }
}

