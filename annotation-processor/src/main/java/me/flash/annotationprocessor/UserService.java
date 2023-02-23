package me.flash.annotationprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    User join(User user) {
        User saved = userRepository.save(user);
        System.out.println("saved = " + saved);
        return saved;
    }

}
