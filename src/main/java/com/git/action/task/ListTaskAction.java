package com.git.action.task;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;
import com.cagf.tool.util.* ;
import org.apache.struts2.ServletActionContext;

public class ListTaskAction extends ActionSupport{

@Resource
private TaskService taskService;

    private int start;
    private int range;
    private String pageInfo;


    private List<Task> list;

    public void setList(List<Task> list) {
        this.list = list;

     }

     public List<Task> getList(){

        return this.list;
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

    public String getPageInfo() {
        return this.pageInfo;

        }



    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        if(0 == this.range) {
            this.range =10;
        }


        long count = this.taskService.getTaskCount();
        this.pageInfo = Page.getPage(ServletActionContext.getRequest(),"",start,range,count);
        this.list = this.taskService.listTasks(this.start,this.range);

        return SUCCESS;

    }


}