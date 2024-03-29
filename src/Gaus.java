import java.util.Scanner;
public class Gaus {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요 : ");
        int foo = scanner.nextInt();
        int bar = 0;

        bar = ((foo + 1)*foo)/2;
        System.out.println(bar);

        scanner.close();
    }
}
