//1. final 로 상속을 막은 경우
//public final class UserClassService {
public class UserClassService {

    //2. private 생성자로 상속을 막은 경우
    //private UserClassService() { }

    void join(User user) {
        System.out.println("join = " + user);
    }

    void terminate(User user) {
        System.out.println("terminate = " + user);
    }

}
