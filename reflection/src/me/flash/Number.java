package me.flash;

@FlashAnnotation
public class Number {

    private String one = "1";

    private static String two = "two";

    private static final String three = "three";

    public String four = "four";

    protected String five = "five";

    public Number() { }

    public Number(String one, String four, String five) {
        this.one = one;
        this.four = four;
        this.five = five;
    }

    private void six() {
        System.out.println(6);
    }

    protected void seven() {
        System.out.println(7);
    }

    public void eight() {
        System.out.println(8);
    }
}
