import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RegMember extends JFrame {

    public RegMember() {
        super("회원가입");

        buildGUI();

        this.setBounds(100,200,350,420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void buildGUI() {
        this.add(createPinkPanel(), BorderLayout.NORTH);
        this.add(createIntroPanel(), BorderLayout.CENTER);
    }

    private JPanel createPinkPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(createNamePanel());
        panel.add(createNumPanel());
        panel.add(createAddressPanel());
        panel.add(createDepartmentPanel());
        panel.add(createHobbyPanel());

        return panel;
    }

    private JPanel createNamePanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel nameLabel = new JLabel("성              명");
        JTextField nameText = new JTextField(8);
        JLabel genderLabel = new JLabel("성              별");
        JRadioButton genderMale = new JRadioButton("남");
        JRadioButton genderFemale = new JRadioButton("여");
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(genderMale);
        genderButtonGroup.add(genderFemale);

        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(genderLabel);
        panel.add(genderMale);
        panel.add(genderFemale);

        return panel;
    }

    private JPanel createNumPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel num = new JLabel("주민등록번호");
        JTextField numField1 = new JTextField(6);
        JLabel h = new JLabel(" - ");
        JTextField numField2 = new JTextField(7);

        panel.add(num);
        panel.add(numField1);
        panel.add(h);
        panel.add(numField2);

        return panel;
    }

    private JPanel createAddressPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel addressLabel = new JLabel("주              소");
        JTextField addressText = new JTextField(22);

        panel.add(addressLabel);
        panel.add(addressText);

        return panel;
    }

    private JPanel createDepartmentPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel departmentLabel = new JLabel("부     서     명");
        JTextField departmentField = new JTextField(8);

        panel.add(departmentLabel);
        panel.add(departmentField);

        return panel;
    }

    private JPanel createHobbyPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel hobbyLabel = new JLabel("취              미");
        JCheckBox MovieCheckBox = new JCheckBox("영화",false);
        JCheckBox MusicCheckBox = new JCheckBox("음악감상",false);
        JCheckBox PhotoCheckBox = new JCheckBox("사진",false);
        JCheckBox ExerciseCheckBox = new JCheckBox("운동",false);

        panel.add(hobbyLabel);
        panel.add(MovieCheckBox);
        panel.add(MusicCheckBox);
        panel.add(PhotoCheckBox);
        panel.add(ExerciseCheckBox);

        return panel;
    }

    private JPanel createIntroPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel introduceLabel = new JLabel("자   기   소   개");
        JTextArea introduceText = new JTextArea(9, 22);

        panel.add(introduceLabel, BorderLayout.NORTH);
        panel.add(introduceText, BorderLayout.CENTER);

        return panel;
    }

}
