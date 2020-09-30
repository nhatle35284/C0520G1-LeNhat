package nhat.coder.userform.repository;

import nhat.coder.userform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
