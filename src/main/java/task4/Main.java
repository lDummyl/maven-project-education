package task4;

/*
	Создать эмулятор страждущего до ответов оракула
	чтобы его протестировать и сформировать внушительный
	отчет не менее чем на 1000 строк
*/


import task3.Oracle;

public class Main {
    public static void main(String[] args) {
        Seeker seeker = new Seeker();
        Oracle oracle = new Oracle();
        String question = seeker.generateQuestion();
        oracle.addressToOracle(question);
    }
}
