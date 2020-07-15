package com.springbootjap.springbootjpa.repository;

import com.springbootjap.springbootjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName (String username);

}
