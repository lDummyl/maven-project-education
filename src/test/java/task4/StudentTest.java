package task4;

import org.junit.Test;
import org.mockito.Mockito;
import task3.Academy;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void generatorQuestionsOne(){
        String s = "Как ";
        String ss = "купить ";
        String sss = "машину?";
        Student studentMock = Mockito.mock(Student.class);
        Mockito.when(studentMock.generatorQuestions().thenReturn(studentMock.keyQuestions.get(0)+" "+
                studentMock.questionContextOne.get(0)+" "+studentMock.questionContextTwo.get(0)));
        assertEquals(s+ss+sss, studentMock.generatorQuestions);
    }

}