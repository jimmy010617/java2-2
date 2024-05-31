import javax.swing.*;
import java.awt.*;

public class ButtonImageEx extends JFrame {
    public ButtonImageEx() {
        setTitle("이미지 버튼 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon normalIcon = new ImageIcon();
        ImageIcon rolloverIcon = new ImageIcon();
        ImageIcon pressedIcon = new ImageIcon();

        JButton btn = new JButton("call~~", normalIcon);
        btn.setPressedIcon(pressedIcon);
        btn.setRolloverIcon(rolloverIcon);

        c.add(btn);
        setSize(250, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonImageEx();
    }
}