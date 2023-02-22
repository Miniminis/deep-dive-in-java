import org.junit.jupiter.api.Test;

class UserServiceTest {

    private UserService userService;

    @Test
    void defaultUserService() {
        userService = new DefaultUserService();
        userService.join(new User("flash"));
        //user from DefaultUSerService = User@6b943504
    }

    @Test
    void proxyUserService() {
        userService = new ProxyUserService();
        userService.join(new User("flash"));
        //proxy start
        //user from DefaultUSerService = User@1a13a1be
        //proxy end
    }
}
