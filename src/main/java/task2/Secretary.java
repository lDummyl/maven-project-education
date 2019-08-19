package task2;
class Secretary implements WantAWork {  //implements это ключевое слово, предназначенное для реализации интерфейса

    String name;
	Office office;

    public Secretary(String name) {
        this.name = name;
    }

    //  public Secretary(String name, Office office) { this.name = name; this.office = office; }

    @Override
    public String toString() {
        return "Секретарь " + name;   //делаем приписку к имени секретаря
    }

    @Override                        //для чего здесь переопределение (@Override)
    public boolean passInterview() {
        return true;
    }
}
