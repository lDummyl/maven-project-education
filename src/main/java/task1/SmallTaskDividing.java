package task1;


import java.util.ArrayList;
import java.util.Random;

public class SmallTaskDividing {

    public static void main(String[] args) {
        // TODO: 2/4/20 создать 10 фигур(круг, квадрат, прямоугольник) вывести на печать порядковый номер фигуры с наибольшей площадью
        //  важно сосредоточиться на архитектурных аспектах, нежели не самой реализации
        //  в каждом методе в том чилсе main должно быть не более 10 строк кода. Можно иметь не ограниченно число методов и вспомогательных классов.
        //  Например, ShapesProvider, SquareComparator и тд

		????createObjects();
	?????deleteTwoLastElements();

    }

    public static ArrayList<Shape> createObjects() {     //создаем коллекцию объектов с рандомными значениями
        Random random = new Random();
        ArrayList<Shape> shapes = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Shape circle = new Circle(i, random.nextDouble()); //порядковый номер круга + рандомн. радиус
            Shape rectangle = new Rectangle(i + 4, random.nextDouble(), random.nextDouble());   // порядковый номер + 2 стороны рандомно
            Shape square = new Square(i + 8, random.nextDouble());   //порядк номер + сторона квадрата рандомно
            shapes.add(circle);
            shapes.add(rectangle);
            shapes.add(square);
        }
        return shapes;   // коллекция объектов
    }

    public static ArrayList<Shape> deleteTwoLastElements(ArrayList<Shape> shapes) {  // в предыдущем методе мы создали 12 объектов, удалим лишние
        shapes.remove(12);
        shapes.remove(11);
		System.out.println(shapes);
        return shapes;   //теперь у нас 10 фигур : )
    }

}

class Shape {
    double width;
    double length;
    double radius;
    int number;

    int returnNumber() { //возврат порядкового номера фигуры
        int number = 0;
        return number;
    }
}

class Circle extends Shape {


    Circle(int number, double radius) {
        this.number = number;
        this.radius = radius;
    }

	double calculateSquare() {
		final double pi = 3.14;
		double calculatedSquare = pi * radius * radius;
		return calculatedSquare;
	}

	@Override
	public String toString(){
		return "Circle{ " + number + ", " + radius + " }";
	}
}

class Rectangle extends Shape {
    Rectangle(int number, double width, double length) {
        this.number = number;
        this.length = length;
        this.width = width;
    }

	double calculateSquare() {

		double calculatedSquare = length * width;
		return calculatedSquare;
	}
	@Override
	public String toString(){
		return "Rectangle{ " + number + ", " + length + ", " + ", " + width + " }";
	}

}

class Square extends Shape {
    Square(int number, double width) {
        this.number = number;
        this.width = width;
    }

	double calculateSquare() {

		double calculatedSquare = width * width;
		return calculatedSquare;
	}

    @Override
    public String toString(){
    	return "Square{ " + number + ", " + width + " }";
	}
}