package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

interface QuestionReader {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

     String readQuestion() throws IOException;


}
