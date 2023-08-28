package com.example.supportportal.resource;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supportportal.Repository.TaskRepository;
import com.example.supportportal.Repository.UserRepository;
import com.example.supportportal.domain.Task;
import com.example.supportportal.domain.User;
import com.example.supportportal.service.TaskService;
import com.example.supportportal.service.UserService;
import com.example.supportportal.service.impl.TaskServiceImpl;
import com.example.supportportal.utility.JWTTokenProvider;


@RestController
@RequestMapping(path = { "/task"})
public class TaskResource {
	
	private final UserRepository userRepository;
    private final TaskService taskService;
	
	
    @Autowired
    public TaskResource(UserRepository userRepository, TaskService taskService ) {
        this.userRepository = userRepository;
        this.taskService = taskService;
        
    }

    @GetMapping("/user/{userId}/tasks")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable String userId) {
        User  optionalUser = userRepository.findUserByUserId(userId);
        
        if (optionalUser.isActive()) {
            User user = optionalUser;
            List<Task> tasks = taskService.getTasksByUser(user);
            return ResponseEntity.ok(tasks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @PutMapping("/{id}/mark-finished")
    public boolean markTaskAsFinished(@PathVariable Long id) {
         taskService.updateTaskFini(id);
         return true ;
        
    }
    

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        // Find the task by its ID in the repository
        Task task = taskService.getTaskById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(task);
        }
    }
    
    
}


	

	
	 
	 
	 
	    


