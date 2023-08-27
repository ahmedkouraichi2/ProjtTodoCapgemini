package com.example.supportportal.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.supportportal.domain.Task;
import com.example.supportportal.domain.User;
import com.example.supportportal.exception.domain.EmailExistException;
import com.example.supportportal.exception.domain.NotAnImageFileException;
import com.example.supportportal.exception.domain.UserNotFoundException;
import com.example.supportportal.exception.domain.UsernameExistException;

public interface TaskService {
	
	 List<Task> getTasks();

	 List<Task> getTasksByUserName(String userName);
	
	 List<Task> getTasksByUser(User user);
	 
	  Task updateTaskFini(Long id );

	       
	   

}
