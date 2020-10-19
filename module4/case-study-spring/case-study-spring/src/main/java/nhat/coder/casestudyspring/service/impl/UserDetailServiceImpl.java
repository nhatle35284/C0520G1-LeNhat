package nhat.coder.casestudyspring.service.impl;

import javafx.beans.property.SimpleListProperty;
import nhat.coder.casestudyspring.model.Role;
import nhat.coder.casestudyspring.model.User;
import nhat.coder.casestudyspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user==null){
            throw new UsernameNotFoundException("Can not Found!!");
        }
            Set<Role> roleSet = (Set<Role>) user.getRoles();
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            for (Role role:roleSet){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
                grantedAuthorityList.add(grantedAuthority);
            }
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPassword(),grantedAuthorityList);;
        return userDetails;
    }
}
