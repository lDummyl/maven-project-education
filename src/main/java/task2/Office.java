package task2;


import task1.PersonProvider;

public class Office {


    String companyName;

    public Secretary secretary;

    // TODO: 6/3/20 один директор, пойми разницу между классом и объектом
    public Director director;

//    public Director amazonDirector;

    public Hr hr;

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат
    // TODO: 5/22/20

    void invitePeople(Object human) {

        couldSomebodySendMyMail(director);
        couldSomebodySendMyMail((MailSender) new PersonProvider().getPersons(1));

    }
    // TODO: 5/15/20 офис не создает секретарей, это работа для вселенной, бога или колледжа, офис только принимает
    //  и отбирает их
    // TODO: 5/15/20 не забываем дженерики для интерфейса и даймонд оператор для конструктора


    public static void main(String[] args) throws Exception {
        // TODO: 5/15/20 в классе Main уже есть метод, лучше в него перенести создание
        // TODO: 5/21/20 ну что ж сделаем так что офисов теперь у нас будет 2, в них работают разные директора, причем с разным поведением




    }

    private  void couldSomebodySendMyMail(MailSender mailSender) {
        mailSender.sendMail(new Mail("на деревню дедушке"));
    }


}
