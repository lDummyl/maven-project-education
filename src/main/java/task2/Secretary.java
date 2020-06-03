package task2;

import task1.BirthDate;
import task1.Name;
import task1.Person;

// TODO: 5/21/20 все эти классы в отдельные фаилы, это легко сделать добавив модификатор public и через alt+Enter
public class Secretary extends Person implements MailSender {

    public Secretary(Name name, BirthDate age) {
        super(name, age);
    }

    @Override
    public void sendMail(Mail mail) {
        System.out.println(mail + "Sent!");
    }

    // TODO: 5/21/20 подобные статические методы это не очень хорошо.


}

