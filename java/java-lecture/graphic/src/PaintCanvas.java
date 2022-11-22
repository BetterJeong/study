import javax.swing.*;
import java.awt.*;

public class PaintCanvas extends JFrame {
    CirclePanel p1;

    PaintCanvas() {
        setSize(400, 400);
        setTitle("Paint EX");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        p1 = new CirclePanel();
        add(p1, BorderLayout.CENTER);

        setVisible(true);
    }

}
