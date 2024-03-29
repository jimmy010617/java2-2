import java.util.Scanner;
public class Switch {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("월(1~12)을 입력하시오 : ");
        int month = scanner.nextInt();
        
        if (3 <= month && month <= 5) {
            System.err.println("봄 입니다.");
        } 
        else if (6 <= month && month <= 8) {
            System.err.println("여름 입니다.");
        }
        else if (9 <= month && month <= 11) {
            System.err.println("가을 입니다.");
        }
        else {
            System.err.println("겨울 입니다.");
        }
        scanner.close();
    }
}
