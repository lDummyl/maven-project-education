package bonus;


// Нужно создать доску определенного размера
// чтобы на ней можно было размещать элементы
// и доставать их пользуясь данными методами


class TestOfBoard {
    public static void main(String[] args) {
        Board board = new Board(1000, 1000);
        board.put(1, 2, "X");
        Object x = board.get(1, 2);
        System.out.println("x = " + x);
    }
}

class Board {

    private final Object[][] board;

    public Board(int xSize, int ySize) {
        board = new Object[xSize][ySize];
    }

    public Object get(int x, int y) {
        return board[x][y];
    }

    public void put(int x, int y, Object toAdd) {
        board[x][y] = toAdd;
    }
}