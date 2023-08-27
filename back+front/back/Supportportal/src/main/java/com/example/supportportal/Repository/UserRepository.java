package com.example.supportportal.Repository;

import com.example.supportportal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long> {

    User findUserByUserName(String username);
    User findUserByEmail(String email);
    
    User findUserByUserId(String userId);

}
