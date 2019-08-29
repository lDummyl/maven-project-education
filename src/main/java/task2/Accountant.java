package task2;

class Accountant implements WantAWork {

    String name;

    public Accountant(String name){this.name = name;}

    @Override
    public String toString(){return "Бухгалтер " + name;}

    @Override
    public boolean passInterview() {
        return true;
    }
}

