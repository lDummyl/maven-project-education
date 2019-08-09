package bonus;


// Нужно создать доску определенного размера
// чтобы на ней можно было размещать элементы
// и доставать их пользуясь данными методами


import java.util.ArrayList;
import java.util.List;

class TestOfBoard {
	public static void main(String[] args) {
		Board board = new Board(1000, 1000);
		board.put(1, 2, "X");
		Object x = board.get(1, 2);
		System.out.println("x = " + x);
	}
}


class Board {

	private final int xSize;
	private final int ySize;
	private ArrayList<ArrayList<Object>> board = new ArrayList<>();

	public Board(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		for (int i = 0; i < xSize; i++) {
			board.add(getListOfNulls());
		}
	}

	private ArrayList<Object> getListOfNulls() {
		ArrayList<Object> ys = new ArrayList<>();
		for (int j = 0; j < ySize; j++) {
			ys.add(null);
		}
		return ys;
	}

	public Object get(int x, int y) {
		return board.get(x).get(y);
	}

	public void put(int x, int y, Object toAdd) {
		List<Object> xs = board.get(x);
		if (xs == null) {
			xs = getListOfNulls();
		}
		xs.add(y, toAdd);
	}
}