import javax.swing.*;
import java.awt.*;

public class JBasicFrame1 {

    private JFrame frame;

    public JBasicFrame1() {
        frame = new JFrame("사원 등록");

        buildGUI();

        frame.setSize(350, 420);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buildGUI() {

        // 이름, 성별
        JLabel nameLabel = new JLabel("성                명");
        JTextField nameField = new JTextField(8);
        JLabel genderLabel = new JLabel("성        별");
        JTextField genderField = new JTextField(3);
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(nameLabel);
        p1.add(nameField);
        p1.add(genderLabel);
        p1.add(genderField);

        // 주민등록번호
        JLabel num = new JLabel("주민등록번호");
        JTextField numField1 = new JTextField(6);
        JLabel h = new JLabel(" - ");
        JTextField numField2 = new JTextField(7);
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(num);
        p2.add(numField1);
        p2.add(h);
        p2.add(numField2);

        // 주소
        JLabel addressLabel = new JLabel("주                소");
        JTextField addressField = new JTextField(22);
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(addressLabel);
        p3.add(addressField);

        // 부서명
        JLabel departmentLabel = new JLabel("부       서       명");
        JTextField departmentField = new JTextField(8);
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(departmentLabel);
        p4.add(departmentField);

        // 취미
        JLabel hobbyLabel = new JLabel("취                미");
        JTextField hobbyField = new JTextField(22);
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p5.add(hobbyLabel);
        p5.add(hobbyField);

        // 자기소개
        JLabel introduceLabel = new JLabel("자    기    소    개");
        JTextArea introduceText = new JTextArea(9, 22);
        JPanel p6 = new JPanel(new BorderLayout());
        p6.add(introduceLabel, BorderLayout.NORTH);
        p6.add(introduceText, BorderLayout.CENTER);

        // 버튼
        JButton save = new JButton("저장");
        JButton exit = new JButton("종료");
        JPanel p7 = new JPanel(new FlowLayout());
        p7.add(save);
        p7.add(exit);

        // North
        JPanel northPanel = new JPanel(new GridLayout(5, 1));
        northPanel.add(p1);
        northPanel.add(p2);
        northPanel.add(p3);
        northPanel.add(p4);
        northPanel.add(p5);

        // 배치
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(p6, BorderLayout.CENTER);
        frame.add(p7, BorderLayout.SOUTH);

    }
}
