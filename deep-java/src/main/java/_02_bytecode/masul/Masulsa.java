package _02_bytecode.masul;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {

    public static void main(String[] args) {

        //1. Moja.class 내의 pullOut 매소드가 고정값인 Rabbit! 을 반환하도록 조작한 새로운 .class 파일로 덮어 씌우기
        try {
            new ByteBuddy()
                    .redefine(Moja.class)
                    .method(named("pullOut"))
                    .intercept(FixedValue.value("Rabbit!"))
                    .make()
                    .saveIn(new File("/Users/mhson/Documents/github-miniminis/deep-dive-in-java/deep-java/build/classes/java/main/"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. 위의 코드 실행 후 주석처리. 아래 코드 실행 -> Rabbit! 이 반환된다.
        System.out.println(new Moja().pullOut());       //Rabbit!
    }
}
