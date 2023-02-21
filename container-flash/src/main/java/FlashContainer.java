import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class FlashContainer {

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType); //생성자 방식으로 클래스 타입에 대한 객체 생성

        Arrays.stream(classType.getDeclaredFields()).forEach(field -> {     //클래스에 정의된 필드들 중, Inject type 어노테이션이 붙어있는 필드 조회
            if (field.getAnnotation(Inject.class) != null) {
                Object injectedInstance = createInstance(field.getType());  //해당 필드에 대해서 객체를 만들고
                field.setAccessible(true);      //접근 제어자를 해제해준 뒤,
                try {
                    field.set(instance, injectedInstance);      //인스턴스에 해당 필드 타입의 인스턴스를 주입시켜준다.
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
