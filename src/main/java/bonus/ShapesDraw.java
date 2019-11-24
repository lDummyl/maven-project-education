package bonus;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class ShapesDraw {

    public static void main(String[] args) {

        Runnable r = () -> {
            LineComponent lineComponent = new LineComponent(400, 400);
            lineComponent.addLines();
            JOptionPane.showMessageDialog(null, lineComponent);
        };
        SwingUtilities.invokeLater(r);
    }
}

class MyPoint {
    double a;
    double b;

    public MyPoint(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public MyPoint plus(double a, double b) {
        return new MyPoint(a + this.a, b + this.b);
    }
}


class LineComponent extends JComponent {

    ArrayList<Line2D.Double> lines;

    LineComponent(int width, int height) {
        super();
        setPreferredSize(new Dimension(width, height));
        lines = new ArrayList<>();
    }

    public void addLines() {

        MyPoint startPoint = new MyPoint(200, 100);
        int n = 6;
        double anglePart = 360. / n;
        double length = 100.;
        MyPoint myPoint = startPoint;
        for (int i = 1; i <= n; i++) {
            myPoint = addLine(myPoint, anglePart * i, length);
        }
        repaint();
    }

    private MyPoint addLine(MyPoint startPoint, double angle, double length) {
        double radians = Math.toRadians(angle);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double x = cos * length;
        double y = sin * length;
        MyPoint endPoint = startPoint.plus(x, y);
        Line2D.Double line = new Line2D.Double(
                startPoint.a,
                startPoint.b,
                endPoint.a,
                endPoint.b);
        lines.add(line);
        return endPoint;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
        g.setColor(Color.black);
        for (Line2D.Double line : lines) {
            g.drawLine(
                    (int) line.getX1(),
                    (int) line.getY1(),
                    (int) line.getX2(),
                    (int) line.getY2()
            );
        }
    }
}