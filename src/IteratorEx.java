import java.util.*;

public class IteratorEx {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        v.add(5);
        v.add(5);
        v.add(7);

        v.add(2, 100);

        Iterator<Integer> it = v.iterator();
        while(it.hasNext()) {
            int n = it.next();
            System.out.println(n);
        }
        
        //Iterator를 이용하여 모든 정수 더하기
        int sum = 0;
        it = v.iterator();      //Iterator 객체 얻기
        while(it.hasNext()) {
            int n = it.next();
            sum += n;
        }
        System.out.println("벡터에 있는 정수 합 : " + sum);
    }
}
