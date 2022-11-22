import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;

public class CirclePanel extends JPanel {
    LinkedList<Point> points;
    int selected;

    CirclePanel() {
        selected = -1;
        points = new LinkedList<>();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int i = 0;
        for (Point p : points) {
            g.setColor(Color.RED);
            g.drawOval(p.x - 25, p.y - 25, 25 * 2, 25 * 2);
            g.fillOval(p.x - 25, p.y - 25, 25 * 2, 25 * 2);
            i++;
        }
    }
}
