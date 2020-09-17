package task4;

/*
	Создать эмулятор страждущего до ответов оракула
	чтобы его протестировать и сформировать внушительный
	отчет не менее чем на 1000 строк
*/


public class Main {

    public static void main(String[] args) {
        Student student = new Student(1);
        student.initAll();
        System.out.println(student.generatorQuestionOne());

    }

}
