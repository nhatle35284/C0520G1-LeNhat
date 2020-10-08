package nhat.coder.blogpro.service;

import nhat.coder.blogpro.controller.Account;
import nhat.coder.blogpro.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
