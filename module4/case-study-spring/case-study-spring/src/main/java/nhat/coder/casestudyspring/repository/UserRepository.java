package nhat.coder.casestudyspring.repository;

import nhat.coder.casestudyspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String name);
}
