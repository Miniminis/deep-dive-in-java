public class DefaultUserService implements UserService {
    @Override
    public void join(User user) {
        System.out.println("user from DefaultUSerService = " + user);
    }
}
