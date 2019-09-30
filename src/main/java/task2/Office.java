package task2;

import bonus.Lambda;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Office {

	Secretary secretary;
	Accountant accountant;
	List<Accountant> accountants = new ArrayList<>();

//	Financier financier;
//	Lawyer lawyer;
//	Logistician logistician;
//	Security security;

    String nameOffice;

	Director director = new Director(this);
	Hr hr = new Hr("Аделаида Марковна");

    public Office(){};

    public Office(String nameOffice){ this.nameOffice = nameOffice;};


	void invitePeople(Object human) {

        hr.considerAnyCandidate(human);

        director.chooseSecretary(hr.listSeekersOnSecretary);
        director.chooseAccountant(hr.listSeekersOnAccountant);
	}

    public void setSecretary(Secretary secretary){
	    this.secretary = secretary;
    }

    public void setAccountant(List<Accountant> accountants){
        this.accountants = accountants;
        // TODO: 9/27/19 гораздо полезней починить тесты, там давно пора навести порядок. Убрать копипасты, заменить цклами или стримами,
        //  выкинуть закоментированные блоки. Тогда будет наглядней и проще
        //  и напиши тест, который будет проверять новое назначние бугалтеров
    }

    public List<Accountant> getAccountant(){
        return accountants;
    }

}


