package task2;
public class HR extends Manager{
    String phrase1 = "HR: \"Manager A, look at the list of employee and fill up their KPI\" ";
    String phrase2 = "HR: \"Thank you, Manager A, I'll prepare this information to the Director.\"";
    String phrase3 = "HR: \"Mr Director, check this table with employee's KPI: \"";

    //HR(Manager KPI1, Manager KPI2, Manager KPI3) {
    //    super(KPI1, KPI2, KPI3);
 //   }

    public void createTable() {
        System.out.println("+------------------+---------+");
        System.out.println("|      Name        +   KPI   +");
        System.out.println("+------------------+---------+");

    }
}
