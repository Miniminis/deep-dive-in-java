package me.flash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.Arrays;

class MainTest {

    @Test
    @DisplayName("1. Class<T>에_접근하는 3가지 방법")
    void approachClass() throws ClassNotFoundException {
        //1. 모든 클래스를 로딩하고 나면, Class<T> 의 인스턴스가 생긴다. 타입.class 형태로 접근 가능하다.
        Class<Number> numberClass1 = Number.class;

        //2. 모든 인스턴스는 getClass() 메소드를 가지고 있다. 인스턴스.getClass() 로 접근할 수 있다.
        Number number = new Number();
        Class<? extends Number> numberClass2 = number.getClass();

        //3. 클래스 full qualified class name 인 문자열로 읽어오는 방법 : Class.forName("FQCN");
        //- 클래스 패스에 해당 클래스가 없다면 ClassNotFoundException 발생한다.
        Class<?> numberClass3 = Class.forName("me.flash.Number");

        System.out.println(numberClass1);
        System.out.println(numberClass2);
        System.out.println(numberClass3);
        System.out.println();

        //class me.flash.Number
        //class me.flash.Number
        //class me.flash.Number
    }

    @DisplayName("2. 필드 목록 가져오기")
    @Test
    void getFields() {
        Class<Number> numberClass = Number.class;

        Arrays.stream(numberClass.getFields()).forEach(System.out::println);   //public 필드만
        System.out.println();
        Arrays.stream(numberClass.getDeclaredFields()).forEach(System.out::println);   //모든 필드
        System.out.println();
    }

    @DisplayName("2-1. 필드 값 가져오기")
    @Test
    void getFieldsValue() {
        Class<Number> numberClass = Number.class;
        Number number = new Number();

        Arrays.stream(numberClass.getDeclaredFields()).forEach(f -> {
            f.setAccessible(true);
            System.out.println(f);
            try {
                System.out.println(f.get(number));  //instance 를 통해서 가져올 수 있다.
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    @DisplayName("2-2. 필드 접근제어자 확인하기")
    @Test
    void getFieldsModifier() {
        Class<Number> numberClass = Number.class;
        Number number = new Number();

        Arrays.stream(numberClass.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isPublic(modifiers));
        });
    }

    @DisplayName("3. 메소드 목록 가져오기")
    @Test
    void getMethods() {
        Class<Number> numberClass = Number.class;

        Arrays.stream(numberClass.getMethods()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(numberClass.getDeclaredMethods()).forEach(System.out::println);
        System.out.println();
    }

    @DisplayName("3-1. 메소드 관련 정보 가져오기")
    @Test
    void getMethodInfos() {
        Class<Number> numberClass = Number.class;

        Arrays.stream(numberClass.getDeclaredMethods()).forEach(f -> {
            System.out.println(f);
            Arrays.stream(f.getParameterTypes()).forEach(System.out::println);
            System.out.println(f.getReturnType());
        });
    }

    @DisplayName("4. 상위 클래스 가져오기")
    @Test
    void getSuperClass() {
        Class<Number> numberClass = Number.class;
        System.out.println(numberClass.getSuperclass());
    }

    @DisplayName("5. 인터페이스 목록 가져오기")
    @Test
    void getInterface() {
        Arrays.stream(MyNumber.class.getInterfaces()).forEach(System.out::println);
        //interface me.flash.NumberInterface
    }

    @DisplayName("6. 어노테이션 가져오기")
    @Test
    void getAnnotation() {
        Arrays.stream(MyNumber.class.getAnnotations()).forEach(System.out::println);
    }

    @DisplayName("7. 생성자 가져오기")
    @Test
    void getConstructor() {
        Arrays.stream(Number.class.getConstructors()).forEach(System.out::println);
        //public me.flash.Number()
        //public me.flash.Number(java.lang.String,java.lang.String,java.lang.String)
    }
}
