package com.git.action.task;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class DeleteTaskAction extends ActionSupport{

@Resource
private TaskService taskService;

    private long id;
    private int start;
    private int range;



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setStart(int start) {
        this.start = start;
        }

    public int getStart() {
        return this.start;

        }

    public void setRange(int range) {
        this.range = range;
        }


    public int getRange() {
        return this.range;
        }


    @Override
    public void validate() {

    }


    @Override
    public  String execute() throws Exception{

       taskService.deleteTask(id);

        return SUCCESS;

    }


}