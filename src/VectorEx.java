import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(5);
        v.add(4);
        v.add(-1);

        v.add(2, 100);

        System.out.println("요서 객체의 수 :" + v.size());
        System.out.println("벡터의 용량 :" + v.capacity());

        for(int i = 0; i < v.size(); i++) {
            int n = v.get(i);
            System.out.println(n);
        }

        int sum = 0;
        for(int i = 0; i < v.size(); i++) {
            int n = v.elementAt(i);
            sum += n;
        }
        System.out.println("벡터에 있는 정수의 합: " + sum);
    }
}
