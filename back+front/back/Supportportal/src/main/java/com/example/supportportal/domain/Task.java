package com.example.supportportal.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private String type = "nonfini" ;
	
	private Date dueDate;
	
	private String description;
	
	private boolean isDone = false;
	
    private String taskImageUrl;
    
    private int priorite ;
    

    private Date dl;
    
    private Date doneTime ;
    
    

 
	
	
	public Date getDl() {
		return dl;
	}

	public void setDl(Date dl) {
		this.dl = dl;
	}

	public Date getDoneTime() {
		return doneTime;
	}

	public void setDoneTime(Date doneTime) {
		this.doneTime = doneTime;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public String getTaskImageUrl() {
		return taskImageUrl;
	}

	public void setTaskImageUrl(String taskImageUrl) {
		this.taskImageUrl = taskImageUrl;
	}

	public Task(Long id, String title, String type, Date dueDate, String description, boolean isDone,
			String taskImageUrl, int priorite, Date dl, Date doneTime, User user) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.dueDate = dueDate;
		this.description = description;
		this.isDone = isDone;
		this.taskImageUrl = taskImageUrl;
		this.priorite = priorite;
		this.dl = dl;
		this.doneTime = doneTime;
		this.user = user;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Task(Long id, String title, String type, Date dueDate, String description,boolean isDone ,String taskImageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.dueDate = dueDate;
		this.description = description;
		this.isDone =isDone ;
		this.taskImageUrl = taskImageUrl ;
		
	}
	
	public Task() {
		
	}
	
	
	
	public Task(Long id, String title, String type, Date dueDate, String description,boolean isDone ) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.dueDate = dueDate;
		this.description = description;
		this.isDone =isDone ;
	}
	
	

}
