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

//	private final int xSize;
//	private final int ySize;

	public Board(int xSize, int ySize) {

	}

	public Object get(int x, int y) {
		return null;
	}

	public void put(int x, int y, Object toAdd) {

	}
}