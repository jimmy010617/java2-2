import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseClickHello extends JFrame {
    public MouseClickHello() {
        setTitle("Mouse Click Hello");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 마우스 클릭 이벤트 리스너 추가
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 프레임 내의 마우스 클릭 위치를 가져옴
                int x = e.getX();
                int y = e.getY();
                
                // 마우스 클릭 위치에 "Hello" 문자열을 출력하기 위한 Graphics 객체 얻기
                Graphics g = getGraphics();
                
                // "Hello" 문자열을 마우스 클릭 위치에 출력
                g.drawString("Hello", x, y);
                
                // Graphics 객체 해제
                g.dispose();
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MouseClickHello().setVisible(true);
            }
        });
    }
}