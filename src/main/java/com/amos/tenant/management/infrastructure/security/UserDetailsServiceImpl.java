package com.amos.tenant.management.infrastructure.security;

import com.amos.tenant.management.infrastructure.persistence.Impl.AccountService;
import com.amos.tenant.management.infrastructure.persistence.entities.AccountDbEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    private static Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("NOW STARTING AUTHENTICATION AT USER DETAILS SERVICE");

        logger.info("DONE WITH AUTHENTICATION AT USER DETAILS SERVICE");
        List<String> privileges=new ArrayList<>();
       Optional<AccountDbEntity> account = Optional.ofNullable(accountService.getAccount(email));
       if(!account.isPresent()){
           throw new UsernameNotFoundException("User not Found");
       }
        privileges.add(account.get().getPrivilege().getName().toUpperCase());
        if(account == null){
        	throw new UsernameNotFoundException("Email not found");
        }
        return new User(account.get().getEmail(), account.get().getPassword(), getGrantedAuthorities(privileges));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String privilege : privileges)
            authorities.add(new SimpleGrantedAuthority(privilege));

        return authorities;
    }

}