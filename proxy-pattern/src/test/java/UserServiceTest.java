import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class UserServiceTest {

    private UserService userService;
    private final User user = new User("flash");

    @Test
    void dynamicProxy() {
        userService = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, new InvocationHandler() {
            UserService userService = new DefaultUserService();

            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("join")) {  //join() 에만 proxy 적용
                    System.out.println("dynamic proxy start");
                    Object invoke = method.invoke(userService, args);
                    System.out.println("dynamic proxy end");
                    return invoke;
                }

                return method.invoke(userService, args);    //나머지 메소드는 proxy 적용 안됨
            }
        });

        userService.join(user);
        userService.terminate(user);
    }


    @Test
    void proxyUserTerminate() {
        userService = new ProxyUserService();
        userService.terminate(user);
    }

    @Test
    void defaultUserService() {
        userService = new DefaultUserService();
        userService.join(user);
        //user from DefaultUSerService = User@6b943504
    }

    @Test
    void proxyUserService() {
        userService = new ProxyUserService();
        userService.join(user);
        //proxy start
        //user from DefaultUSerService = User@1a13a1be
        //proxy end
    }
}
