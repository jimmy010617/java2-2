import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
    public BorderLayoutEx() {
        setTitle("BorderLayout 예제");                   //프레임 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();             //컨텐트팬 알아내기
         
        //컨탠트팬에 BorderLayout 배치관리자 성정
        contentPane.setLayout(new BorderLayout(30, 20));             

        contentPane.add(new JButton("CENTER"), BorderLayout.CENTER);              
        contentPane.add(new JButton("NORTH"), BorderLayout.NORTH);      
        contentPane.add(new JButton("SOUTH"), BorderLayout.SOUTH); 
        contentPane.add(new JButton("EAST"), BorderLayout.EAST); 
        contentPane.add(new JButton("WEST"), BorderLayout.WEST);         

        setSize(300, 200);                       //프레임 크기 300x200 설정
        setVisible(true);                                   //화면에 프레임 출력
    }

    public static void main(String[] args) {
        new BorderLayoutEx();
    }
}