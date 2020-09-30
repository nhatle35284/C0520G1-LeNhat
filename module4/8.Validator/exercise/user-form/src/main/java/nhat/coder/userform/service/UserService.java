package nhat.coder.userform.service;

import nhat.coder.userform.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> getAll();
    Page<User> findAll(Pageable pageable);
    public User findById(Long id);
    public void update( User user);
    void remove(User user);
}
