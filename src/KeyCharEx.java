import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Flow;

import javax.swing.*;
import javax.swing.event.MenuKeyListener;

public class KeyCharEx extends JFrame {
    private JLabel la = 
        new JLabel("<Enter>키로 배경색이 바뀝니다");
    public KeyCharEx() {
        super("KeyListener의 문자 키 입력 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout((new FlowLayout()));
        c.add(la);
        c.addKeyListener(new MyKeyListener());
        setSize(250, 150);
        setVisible(true);
        c.setFocusable(true);
        c.requestFocus();
    }

    class MenuKeyListener extends KeyAdapter {
        public void 
    }
}
