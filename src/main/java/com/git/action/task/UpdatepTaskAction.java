package com.git.action.task;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;



public class UpdatepTaskAction extends ActionSupport{

@Resource
private TaskService taskService;

    private long id;


    private Task task;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Task getTask() {

        return this.task;
     }

    public void setTask(Task task) {
        this.task = task;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        task = taskService.getTask(id);

        return SUCCESS;

    }


}