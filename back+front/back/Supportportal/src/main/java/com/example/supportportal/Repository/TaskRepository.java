package com.example.supportportal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supportportal.domain.Task;
import com.example.supportportal.domain.User;

public interface TaskRepository extends JpaRepository <Task,Long> {

    List<Task> findByUser_UserName(String userName);
   // List<Task> findByUser_UserId(long userId);
    List<Task> findByUser_Id(Long userId);
    
    List<Task> findByUser(User user);
	
}
