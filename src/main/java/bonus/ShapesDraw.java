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


class LineComponent extends JComponent {

    ArrayList<Line2D.Double> lines;

    LineComponent(int width, int height) {
        super();
        setPreferredSize(new Dimension(width, height));
        lines = new ArrayList<>();
    }

    public void addLines() {

        addLine();
        repaint();
    }

    private void addLine() {
        Line2D.Double line = new Line2D.Double(
                10,
                20,
                40,
                50);
        lines.add(line);
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