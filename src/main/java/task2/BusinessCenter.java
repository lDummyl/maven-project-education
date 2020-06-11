package task2;

import task1.PersonProvider;


public class BusinessCenter {

    public Office createOffice(){
        return new Office();
    }

    public Office createOffice(Director director, Hr hr){
        return new Office(director, hr);
    }

}
