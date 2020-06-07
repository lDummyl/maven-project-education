package task2;

import task1.Person;

public class Security extends OfficeWorker{

    public OfficeWorker pal;

    private Person person;

    public Security(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void talkAboutLife(){
        System.out.println("Life is shit, the salary is small");
    }

    public void seduceASecretary(){
        System.out.println("Let's go to my house");
    }

    public void bump(Object human){
        System.out.println("Bam, bam!");
    }

    public void speakWithSomeone(Object pal){
        if(pal instanceof Security){
            talkAboutLife();
        }else if(pal instanceof Secretary){
            seduceASecretary();
        }else if(pal instanceof OfficeWorker){
            System.out.println("");
        }else{
            bump(pal);
        }
    }

    @Override
    public String toString() {
        return "Security{" +
                person +
                '}';
    }



    }

