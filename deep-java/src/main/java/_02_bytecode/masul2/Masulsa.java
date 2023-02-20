package _02_bytecode.masul2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {

    public static void main(String[] args) {

        //1. 클래스 파일을 로드하지 않고 클래스 파일을 변경
        ClassLoader classLoader = Masulsa.class.getClassLoader();
        TypePool typePool = TypePool.Default.of(classLoader);

        try {
            new ByteBuddy()
                    .redefine(typePool.describe("_02_bytecode.masul2.Moja").resolve(), ClassFileLocator.ForClassLoader.of(classLoader))
                    .method(named("pullOut"))
                    .intercept(FixedValue.value("Rabbit!"))
                    .make()
                    .saveIn(new File("/Users/mhson/Documents/github-miniminis/deep-dive-in-java/deep-java/build/classes/java/main/"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. 변경된 클래스 파일을 로드 후 실행 : Rabbit 반환
        System.out.println(new Moja().pullOut());       //Rabbit!
    }
}
