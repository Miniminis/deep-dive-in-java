public class DefaultUserService implements UserService {
    @Override
    public void join(User user) {
        System.out.println("user join = " + user);
    }

    @Override
    public void terminate(User user) {
        System.out.println("user terminate = " + user);
    }
}
