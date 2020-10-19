package nhat.coder.casestudyspring.service;

import nhat.coder.casestudyspring.model.User;

public interface UserService {
    User findByUserName(String name);
}
