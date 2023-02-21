package me.flash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ClassModificationTest {

    @DisplayName("class instance 만들기")
    @Test
    void createInstance() throws InstantiationException, IllegalAccessException {
        /**
         * 주의 : ClassModification.class.newInstance(); 는 Deprecated 되었으므로 사용하지 않도록 한다.
         * */
        ClassModification classModification = ClassModification.class.newInstance();
        System.out.println(classModification);      //me.flash.ClassModification@2f4948e4
    }

    @DisplayName("생성자로 인스턴스 만들기")
    @Test
    void constructorInstance() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("me.flash.ClassModification");
        Constructor<?> constructor = clazz.getConstructor(null);
        ClassModification classModification = (ClassModification) constructor.newInstance();

        System.out.println(classModification);      //me.flash.ClassModification@2f4948e4
    }

    @DisplayName("static 필드 접근하기, 수정하기")
    @Test
    void editStaticFields() throws NoSuchFieldException, IllegalAccessException {
        Field a = ClassModification.class.getDeclaredField("A");
        System.out.println(a.get(null));        //Static 필드를 가져올 때는 object가 없어도 되니까 null

        a.set("A", "hey");
        System.out.println(a.get(null));
    }

    @DisplayName("instance 필드 접근하기, 수정하기")
    @Test
    void editInstanceFields() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        Class<?> aClass = Class.forName("me.flash.ClassModification");
        Constructor<?> constructor = aClass.getConstructor(String.class);

        ClassModification instance = (ClassModification) constructor.newInstance("hello");

        Field b = ClassModification.class.getDeclaredField("b");
        b.setAccessible(true);
        System.out.println(b.get(instance));

        b.set(instance, "bye");     //set(instance, value);
        System.out.println(b.get(instance));
    }

    @DisplayName("메소드 실행하기 : Object Method.invoke(object, params)")
    @Test
    void methodExecution() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("me.flash.ClassModification");
        Constructor<?> constructor = aClass.getConstructor(String.class);

        ClassModification instance = (ClassModification) constructor.newInstance("hello");

        Method c = ClassModification.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(instance);

        Method d = ClassModification.class.getDeclaredMethod("d", int.class, Integer.class);
        System.out.println(d.invoke(instance, 1, 2));;
    }

}
