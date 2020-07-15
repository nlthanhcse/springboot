package com.springbootjap.springbootjpa.service;

import com.springbootjap.springbootjpa.model.User;
import com.springbootjap.springbootjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = userRepository.findByUserName(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
                userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));
        UserDetails userDetails = (UserDetails) user;
        return userDetails;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<User> getAll() {
        return  this.userRepository.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    public User getById(Integer id) {
        return this.userRepository.findById(id).get();
    }

    @Secured({"ROLE_ADMIN"})
    public User addUser(User user) {
        return this.userRepository.save(user);
    }
}
