package nhat.coder.blogpro.service;

import nhat.coder.blogpro.model.Account;
import nhat.coder.blogpro.controller.MyAccountDetail;
import nhat.coder.blogpro.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findByUserName(username);
        if(account == null){
            throw  new UsernameNotFoundException("Account not found: "+username);
        }
        System.out.println(account);
        return new MyAccountDetail(account);
    }
}
