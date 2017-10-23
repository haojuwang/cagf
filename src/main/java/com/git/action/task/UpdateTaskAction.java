package com.git.action.task;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class UpdateTaskAction extends ActionSupport{

@Resource
private TaskService taskService;



	private Long id ;

	private String name ;

	private String description ;

	private Date plannedStartDate ;

	private Date plannedEndDate ;

	private Set children ;

	private Task parent ;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(Date plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public Date getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(Date plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	public Task getParent() {
		return parent;
	}

	public void setParent(Task parent) {
		this.parent = parent;
	}


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        Task bean = taskService.getTask( id);

        bean.setId(id) ;
		bean.setName(name) ;
		bean.setDescription(description) ;
		bean.setPlannedStartDate(plannedStartDate) ;
		bean.setPlannedEndDate(plannedEndDate) ;
		bean.setChildren(children) ;
		bean.setParent(parent) ;
		

        taskService.updateTask(bean);

        return SUCCESS;

    }


}