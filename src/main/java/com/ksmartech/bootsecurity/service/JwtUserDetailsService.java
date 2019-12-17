package com.ksmartech.bootsecurity.service;

import com.ksmartech.bootsecurity.cmn.BaseComponent;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService extends BaseComponent implements UserDetailsService {

    public UserDetails loadUserByUsername(String username) {

        if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            logger.warn("User not found with username: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
