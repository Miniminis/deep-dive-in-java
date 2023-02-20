package _01_jvm;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Java");

        //native method 확인
        Thread.currentThread();

        //load -> instance -> stored in heap
        System.out.println(Flash.class);
        System.out.println(Flash.class.getSuperclass());
        System.out.println(Flash.class.getSuperclass().getSuperclass());
    }
}
