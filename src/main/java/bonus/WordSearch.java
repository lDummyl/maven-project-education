package bonus;

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


}