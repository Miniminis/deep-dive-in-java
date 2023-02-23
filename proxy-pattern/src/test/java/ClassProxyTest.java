import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class ClassProxyTest {

    private final User user = new User("flash");

    @Test
    void byteBuddy() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends UserClassService> proxyClass = new ByteBuddy()
                .subclass(UserClassService.class)
                .method(named("terminate"))
                .intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    UserClassService userClassService = new UserClassService();

                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        System.out.println("proxy start");
                        Object invoke = method.invoke(userClassService, args);
                        System.out.println("proxy end");

                        return invoke;
                    }
                }))
                .make()
                .load(UserClassService.class.getClassLoader())
                .getLoaded();

        UserClassService userClassService = proxyClass.getConstructor(null).newInstance();
        userClassService.join(user);
        userClassService.terminate(user);
    }

    @Test
    void cglib() {
        MethodInterceptor handler = new MethodInterceptor() {

            private final UserClassService userClassService = new UserClassService();

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                if (method.getName().equals("terminate")) {
                    System.out.println("proxy start");
                    Object invoke = method.invoke(userClassService, args);
                    System.out.println("proxy end");

                    return invoke;
                }

                return method.invoke(userClassService, args);
            }
        };

        UserClassService userClassService = (UserClassService) Enhancer.create(UserClassService.class, handler);
        userClassService.join(user);
        userClassService.terminate(user);

        //join = User@6f306067
        //proxy start
        //terminate = User@6f306067
        //proxy end
    }
}
