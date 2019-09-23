package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Office {

	Secretary secretary;
	Accountant accountant;;

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

    public void setAccountant(Accountant accountant){
        this.accountant = accountant;
    }

    /*
    public Secretary getSecretary(){
        return secretary;
    }

    public Accountant getAccountant(){
        return accountant;
    }

     */

}


