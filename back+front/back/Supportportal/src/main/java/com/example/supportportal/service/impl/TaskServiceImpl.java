package com.example.supportportal.service.impl;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.time.LocalDateTime;
import java.util.Date;
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
       private final UserRepository userRepository;
       
	  
	  
	    public TaskServiceImpl(TaskRepository taskRepository ,UserRepository userRepository) {
	        this.taskRepository = taskRepository;
	        this.userRepository = userRepository ;
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
	        Date currentDate = new Date();		
	        currentTask.setDueDate(currentDate);
			return currentTask ;
			
		}

		@Override
		public Task getTaskById(Long id) {
			// TODO Auto-generated method stub
			return taskRepository.findById(id).get();
		}

		@Override
		public Task addNewTask(String title, String description, int priorite, Date dl, String userid) {
			 
		        Task task = new Task();
		       
		        task.setTitle(title);
		        task.setDescription(description);
		        task.setType("non-fini");
		        task.setPriorite(priorite);
		        task.setDl(dl);
		        task.setUser(userRepository.findUserByUserId(userid));
		        taskRepository.save(task);
		        return task;
		}
}
		
		
		
		