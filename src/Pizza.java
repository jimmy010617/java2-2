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
        System.out.println(pizza.name + "의 면적은 " + area);

        Pizza donut = new Pizza();
        donut.name = "도넛피자";
        area = donut.getArea();
        System.out.println(donut.name + "의 면적은 " + area);
    }
}
