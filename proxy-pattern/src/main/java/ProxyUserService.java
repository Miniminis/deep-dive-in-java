public class ProxyUserService implements UserService {

    private final UserService userService = new DefaultUserService();

    @Override
    public void join(User user) {
        System.out.println("proxy start");
        userService.join(user);
        System.out.println("proxy end");
    }
}
