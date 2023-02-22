public class ProxyUserService implements UserService {

    private final UserService userService = new DefaultUserService();

    @Override
    public void join(User user) {
        System.out.println("proxy start");
        userService.join(user);
        System.out.println("proxy end");
    }

    @Override
    public void terminate(User user) {
        System.out.println("proxy start");
        userService.terminate(user);
        System.out.println("proxy end");
    }
}
