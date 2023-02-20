package _02_bytecode.masul3;

public class Masulsa {

    public static void main(String[] args) {
        //javaagent changes bytecode in premain()
        System.out.println(new Moja().pullOut());       //Rabbit!
    }
}
