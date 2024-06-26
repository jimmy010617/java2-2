import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame {
    public FlowLayoutEx() {
        setTitle("FlowLayout 예제");                    //프레임 타이틀 달기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();             //컨텐트팬 알아내기
         
        //왼쪽 정렬로, 수평간격을 30, 수직 간격을 40 픽셀로 배치
        //FlowLayout 생성 
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 40));              //컨텐트팬에 FlowLatout 배치관리자 달기

        contentPane.add(new JButton("add-Calculate"));              
        contentPane.add(new JButton("Sub-Calculate"));      
        contentPane.add(new JButton("mul")); 
        contentPane.add(new JButton("div")); 
        contentPane.add(new JButton("Calculate"));         

        setSize(300, 200);                       //프레임 크기 300x200 설정
        setVisible(true);                                   //화면에 프레임 출력
    }

    public static void main(String[] args) {
        new FlowLayoutEx();
    }
}