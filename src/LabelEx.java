import java.awt.*;
import javax.swing.*;

public class LabelEx extends JFrame {
    public LabelEx() {
        setTitle("레이블 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel textLabel = new JLabel("제임스 고블링 입니다!");

        ImageIcon img = new ImageIcon();
        JLabel imageLabel = new JLabel(img);

        ImageIcon icon = new ImageIcon();
        JLabel label = new JLabel("그냥 그렇다고", icon, SwingConstants.CENTER);

        c.add(textLabel);
        c.add(imageLabel);
        c.add(label);
    }

    public static void main(String[] args) {
        new LabelEx();
    }
}
