package com.example.supportportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supportportal.Repository.TaskRepository;
import com.example.supportportal.Repository.UserRepository;
import com.example.supportportal.domain.Task;
import com.example.supportportal.domain.User;
import com.example.supportportal.service.TaskService;
import com.example.supportportal.service.UserService;

@Service
@Transactional
public class TaskServiceImpl  implements TaskService {
	
	
       private final TaskRepository taskRepository;
       
	  
	  
	    public TaskServiceImpl(TaskRepository taskRepository) {
	        this.taskRepository = taskRepository;
	    }
	
	  @Override
	    public List<Task> getTasks() {
		return taskRepository.findAll();
		    
	  }
	  
	      @Override
		public
		  List<Task> getTasksByUserName(String userName) {
		        return taskRepository.findByUser_UserName(userName);
		        
		        
		    }

		@Override
		public List<Task> getTasksByUser(User user) {
			 return taskRepository.findByUser(user);
		}

		@Override
		public Task updateTaskFini(Long id) {
			Task currentTask = taskRepository.getById(id);
			currentTask.setType("fini");
			return currentTask ;
		}
		
		
		
		 
	}


