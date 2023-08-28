package com.example.supportportal.service;

import java.util.List;


import com.example.supportportal.domain.Task;
import com.example.supportportal.domain.User;

public interface TaskService {
	
	 List<Task> getTasks();

	 List<Task> getTasksByUserName(String userName);
	
	 List<Task> getTasksByUser(User user);
	 
	 Task updateTaskFini(Long id );
	 
	 Task getTaskById(Long id);

	       
	   

}
