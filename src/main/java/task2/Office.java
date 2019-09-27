package task2;

import bonus.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Office {

	Secretary secretary;
    // TODO: 9/23/19 теперь секретарей должно быть по 3 в каждом офисе, List<Acc..>
    //  и добавь еще охраннника, юриста, финансисяа, логиста.
	Accountant accountant;
	List<Accountant> accountants = new ArrayList<>();

	Financier financier;
	Lawyer lawyer;
	Logistician logistician;
	Security security;

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
        this.accountant = this.accountants.get(0);  //чтобы тест не падал:)
    }

    public List<Accountant> getAccountant(){
        return accountants;
    }

}


