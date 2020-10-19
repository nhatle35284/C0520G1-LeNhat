package nhat.coder.casestudyspring.service.impl;

import nhat.coder.casestudyspring.model.User;
import nhat.coder.casestudyspring.repository.UserRepository;
import nhat.coder.casestudyspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User findByUserName(String name) {
        return userRepository.findByUserName(name);
    }
}
