import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FlashContainerTest {

    @Test
    void getObject_userRepository() {
        UserRepository userRepository = FlashContainer.getObject(UserRepository.class); //reflection 을 반환
        assertNotNull(userRepository);
    }

    @Test
    void getObject_userService() {
        UserService userService = FlashContainer.getObject(UserService.class);
        assertNotNull(userService);
        assertNotNull(userService.userRepository);
    }
}
