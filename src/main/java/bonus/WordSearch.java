package bonus;

import java.util.ArrayList;
import java.util.List;

//найти слово во все стороны, вперед назад вверх вниз по диагонали
public class WordSearch {

    static int[][] crossword = new int[][]{
            {'f', 'd', 'e', 'r', 'l', 'k'},
            {'u', 's', 'a', 'm', 'e', 'o'},
            {'l', 'n', 'g', 'r', 'o', 'v'},
            {'m', 'l', 'p', 'r', 'r', 'h'},
            {'p', 'o', 'e', 'e', 'j', 'j'}
    };

    static String toSearch;

    static int x1;
    static int x2;

    static int y1;
    static int y2;

    public static void main(String[] args) {
        WordSearch.toSearch = "lprr";
//        detectAllWords();
        System.out.printf(" (x:%d|y:%d) - (x:%d|y:%d) ", x1, y1, x2, y2);
    }
    private static void detectAllWords() {
        for (int y = 0; y < crossword.length; y++) {
            for (int x = 0; x < crossword[y].length; x++) {
                checkAround(x, y);
            }
        }
    }

    private static void checkAround(int x, int y) {
        if (crossword[y][x] != toSearch.charAt(0)) {
            return;
        }
        checkForward(x, y);
//        checkBackward(x, y);
//        checkUp(x, y);
//        checkDown(x, y);
//        checkDiagonals(x, y); //add 4 nested methods inside
    }

    private static void checkForward(int xStart, int yStart) {
        List<Character> chars = new ArrayList<>();
        int[] line = crossword[yStart];
        for (int x = xStart; x < line.length; x++) {
            chars.add((char) line[x]);
            if (charsEqual(chars)){
                x1 = xStart;
                y1 = yStart;
                x2 = x;
                y2 = yStart;
            }
        }
    }

    private static boolean charsEqual(List<Character> chars) {
        StringBuilder stringBuilder = new StringBuilder();
        chars.forEach(stringBuilder::append);
        return toSearch.equals(stringBuilder.toString());
    }


}