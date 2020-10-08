package nhat.coder.blogpro.repository;

import nhat.coder.blogpro.controller.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String accountName);
}
