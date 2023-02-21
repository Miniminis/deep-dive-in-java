package me.flash;

public class ClassModification {

    public static String A = "A";

    private String b = "B";

    private void c() {
        System.out.println("C");
    }

    public int d (int num1, Integer num2) {
        return num1 + num2;
    }

    public ClassModification() {
    }
    public ClassModification(String b) {
        this.b = b;
    }
}
