package task6;

public class Point {

	float x;
	float y;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		if (x > 0) {
			this.x = x;
		} else {
			System.out.println("X не может быть отрицательным числом");
		}
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		if (y > 0) {
			this.y = y;
		} else {
			System.out.println("Y не может быть отрицательным числом");
		}
	}

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
