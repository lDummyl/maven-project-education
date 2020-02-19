package task1;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SmallTaskDividing {

    private static int circleNumber;
    private static int rectangleNumber;
    private static int squareNumber;

    public static void main(String[] args) {
        // TODO: 2/4/20 создать 10 фигур(круг, квадрат, прямоугольник) вывести на печать порядковый номер фигуры с наибольшей площадью
        //  важно сосредоточиться на архитектурных аспектах, нежели не самой реализации
        //  в каждом методе в том чилсе main должно быть не более 10 строк кода. Можно иметь не ограниченно число методов и вспомогательных классов.
        //  Например, ShapesProvider, SquareComparator и тд

        SmallTaskDividing smallTaskDividing = new SmallTaskDividing(); // TODO: 2/19/20 нигде не используется
        inputNumberOfShapes();

        ArrayList<Shape> listOfShapes = createListOfShapes();
        Shape shapeWithMaxSquare = findShapesWithMaxSquare(listOfShapes);
        System.out.println(shapeWithMaxSquare);

    }

    private static Shape findShapesWithMaxSquare(ArrayList<Shape> listOfShapes) {

        double maxSquare = getMaxSquare(listOfShapes);
        ArrayList<Shape> result = new ArrayList<>();
        for (Shape shape : listOfShapes) {
            if (maxSquare == shape.calculateSquare()) {
            result.add(shape);
            }
        }
        return selectShapeWithMaxSquare(result);
    }

    private static Shape selectShapeWithMaxSquare(ArrayList<Shape> result) {
        Random random = new Random();

        return result.get(random.nextInt(result.size()));
    }

    private static double getMaxSquare(ArrayList<Shape> listOfShapes) {
        double maxSquare = 0;
        for (Shape shape : listOfShapes) {
            double square = shape.calculateSquare();
            if (maxSquare < square) {
                maxSquare = square;
            }
        }
        return maxSquare;
    }

    public static void inputNumberOfShapes() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите кол-во кругов: ");
        circleNumber = input.nextInt();
        System.out.println("Введите кол-во прямоугольников: ");
        rectangleNumber = input.nextInt();
        System.out.println("Введите кол-во квадратов: ");
        squareNumber = input.nextInt();

    }

    public static ArrayList<Circle> createCircleObjects(int circleNumber) {     //создаем коллекцию кругов с рандомными значениями
        Random random = new Random();
        ArrayList<Circle> circleList = new ArrayList<>(circleNumber);

        for (int i = 0; i < circleNumber; i++) {
            Circle circle1 = new Circle(i, random.nextDouble());
            circleList.add(circle1);
        }
        return circleList;   // коллекция объектов
    }

    public static ArrayList<Rectangle> createRectangleObjects(int rectangleNumber) {     //создаем коллекцию объектов с рандомными значениями
        Random random = new Random();
        ArrayList<Rectangle> rectangleList = new ArrayList<>(rectangleNumber);

        for (int i = 0; i < rectangleNumber; i++) {
            Rectangle rectangle1 = new Rectangle(i, random.nextDouble(), random.nextDouble());
            rectangleList.add(rectangle1);
        }
        return rectangleList;   // коллекция объектов
    }

    public static ArrayList<Square> createSquareObjects(int squareNumber) {     //создаем коллекцию объектов с рандомными значениями
        Random random = new Random();
        ArrayList<Square> squareList = new ArrayList<>(squareNumber);

        for (int i = 0; i < squareNumber; i++) {
            Square square1 = new Square(i, random.nextDouble());
            squareList.add(square1);
        }
        return squareList;   // коллекция объектов
    }

    public static ArrayList<Shape> createListOfShapes() {

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.addAll(createCircleObjects(circleNumber)); // TODO: 2/19/20 если вызов внутри класса, класс указывать не обязательно
        shapes.addAll(createRectangleObjects(rectangleNumber));
        shapes.addAll(createSquareObjects(SmallTaskDividing.squareNumber));

        return shapes;
    }

    // TODO: 2/10/20 чтож приходит такой Герман Оскарович и говорит, ну что Agile же тут у нас да, давайте короче будет 20,
    //  нет 383 фигуры теперь сравниваться, да, это ведь не проблема? А еще, дайте подумать, чтобы не меньше половины были кругами, да,
    //  наравятся они мне очень в смысле наши клиенты этого хотят, это же тоже легко сделать?

}

abstract class Shape {
    double width;
    double length;

    abstract double calculateSquare();

    int orderNumber;
}


class Square extends Shape {
    Square(int orderNumber, double width) {
        this.orderNumber = orderNumber;
        this.width = width;
    }

    double calculateSquare() {

        double calculatedSquare = width * width;
        return calculatedSquare;
    }

    @Override
    public String toString() {
        return "Square{ " + orderNumber + ", " + width + " }";
    }
}


class Circle extends Shape {


    private final double radius;

    Circle(int orderNumber, double radius) {
        this.orderNumber = orderNumber;
        this.radius = radius;
    }

    double calculateSquare() {
        final double pi = 3.14;
        double calculatedSquare = pi * radius * radius;
        return calculatedSquare;
    }

    @Override
    public String toString() {
        return "Circle{ " + orderNumber + ", " + radius + " }";
    }
}

class Rectangle extends Shape {
    Rectangle(int number, double width, double length) {
        this.orderNumber = number;
        this.length = length;
        this.width = width;
    }

    double calculateSquare() {

        double calculatedSquare = length * width;
        return calculatedSquare;
    }

    @Override
    public String toString() {
        return "Rectangle{ " + orderNumber + ", " + length + ", " + ", " + width + " }";
    }

}