import java.util.Scanner;

public class Pizza {
    int radius;
    String name;

    public Pizza() {
        radius = 1; name = "";
    }
    public Pizza(int r, String n) {
        radius = r; name = n;
    }
    public double getArea() {
        return 3.14*radius*radius;
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza(10, "자바피자");
        double area = pizza.getArea();
    }
}
