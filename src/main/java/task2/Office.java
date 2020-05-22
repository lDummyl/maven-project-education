package task2;

public class Office {

    public static Person firstHiredHuman = Director.firstFinalChoose();
    public static Person secondHiredHuman = new Director().secondFinalChoose();
	/*
	Secretary secretary;

	Director director;

	Hr hr;
	*/

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат
    // TODO: 5/22/20  
    static void invitePeople(Object human) {
        if (human.equals(firstHiredHuman)) {
            System.out.println("DIRECTOR1: You are welcome, " + human);
        }

        if (secondHiredHuman == null && human.equals(secondHiredHuman)) {
            System.out.println("DIRECTOR2: Everyone get out!!! No one I need!");
        } else if (secondHiredHuman != null && human.equals(secondHiredHuman)){
            System.out.println("DIRECTOR2: You are the most experience person!\n" +
                    "and you've graduated university, so You Are Welcome " + human);
        }
        // TODO: 5/15/20 офис не создает секретарей, это работа для вселенной, бога или колледжа, офис только принимает
        //  и отбирает их
        // TODO: 5/15/20 не забываем дженерики для интерфейса и даймонд оператор для конструктора

    }

    public static void main(String[] args) {
        // TODO: 5/15/20 в классе Main уже есть метод, лучше в него перенести создание
        // TODO: 5/21/20 ну что ж сделаем так что офисов теперь у нас будет 2, в них работают разные директора, причем с разным поведением

        invitePeople(firstHiredHuman);
        invitePeople(secondHiredHuman);

    }
}
