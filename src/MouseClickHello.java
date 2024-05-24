import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseClickHello extends JFrame {
    private MyPanel panel;

    public MouseClickHello() {
        setTitle("Mouse Click Hello");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MyPanel();
        add(panel);
    }

    class MyPanel extends JPanel {
        private int mouseX;
        private int mouseY;

        public MyPanel() {
            // 마우스 이벤트 리스너 추가
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // 클릭한 위치의 좌표를 가져옴
                    mouseX = e.getX();
                    mouseY = e.getY();
                    // 패널을 다시 그리기 위해 repaint 호출
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 이전에 그렸던 내용을 모두 지우고 새로 그리기
            g.clearRect(0, 0, getWidth(), getHeight());
            // 마우스의 위치에 "Hello" 문자열을 출력
            g.drawString("Hello", mouseX, mouseY);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MouseClickHello().setVisible(true);
            }
        });
    }
}