public class Novel {
    String title;
    String author;

    public Novel() {    //생성자
        this("해리포터", "조앤롤링");
        //title = "해리포터"; author = "조앤 K 롤링";
        System.out.println("this 생성자 호출");
    }
    public Novel(String title) {
        this(title, "작자미상");
        //title = t; author = "작자미상";
    }

    public Novel(String title, String author) { //생성자
        this.title = title;
        this.author = author;
        //title = t; author = a;
    }

    public static void main(String[] args) {
        Novel foo = new Novel();
        Novel loveStory = new Novel("춘향전");
        Novel littlePrince = new Novel("어린왕자", "생텍쥐페리");
        System.out.println(foo.title + " " + foo.author);
        System.out.println(loveStory.title + " " + loveStory.author);
        System.out.println(littlePrince.title + " " + littlePrince.author);
    }
}