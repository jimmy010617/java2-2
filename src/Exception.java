import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int divided;
        int divisor;

        System.out.print("나뉨수를 입력하시오 : ");
        divided = scanner.nextInt(); //나뉨수 입력
        System.out.print("나눗수를 입력하시오 : ");
        divisor = scanner.nextInt(); //나눗수 입력
        try {
            System.out.println(divided+"를 " + divisor + "로 나누면 몫은 " + divided/divisor + "입니다.");
        }
        catch(ArithmeticException e){   //ArithmeticException예외처리코드
            System.out.println("0으로 나눌 수 없습니다!");
        }
        finally {
            scanner.close();    //정상적이든 예외가 발생하든 최종적으로 scanner를 닫는다
        }
    }
}
