public class Book {
    String title;
    String author;

    public Book() {
        title = "해리포터"; author = "조앤 K 롤링";
    }
    public Book(String t) {
        title = t;
        author = "작자미상";
    }

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public static void main(String[] args) {
        Book foo = new Book();
        Book loveStory = new Book("춘향전");
        Book littlePrince = new Book("어린왕자", "생텍쥐페리");
        System.out.println(foo.title + " " + foo.author);
        System.out.println(loveStory.title + " " + loveStory.author);
        System.out.println(littlePrince.title + " " + littlePrince.author);
    }
}
