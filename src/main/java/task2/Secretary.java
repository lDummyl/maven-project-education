package task2;
class Secretary implements WantAWork {  //implements это ключевое слово, предназначенное для реализации интерфейса

    String name;
	Office office;
    boolean hired = false;

    public Secretary(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Секретарь " + name;
    }

    @Override
    public boolean passInterview() {
        return true;
    }

    @Override
    public boolean isHired() {
        return hired;
    }
}
