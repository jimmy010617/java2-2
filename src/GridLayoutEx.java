import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {
    public GridLayoutEx() {
        super("BorderLayout 예제");                       // 프레임 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();               // 컨텐트팬 알아내기
         
        //1x10의 GridLayout 배치관리자
        contentPane.setLayout(new GridLayout(4, 3));             

        for(int i=9; i>0; i--) {                                // 10개의 버튼 부착
            String text = Integer.toString(i);                  // i를 문자열로 변환               
            contentPane.add(new JButton(text));                 // 컨탠트팬에 버튼 부착
        }       

        contentPane.add(new JButton("*"));
        contentPane.add(new JButton("0"));

        setSize(300, 200);                       // 프레임 크기 300x200 설정
        setVisible(true);                                   // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new GridLayoutEx();
    }
}