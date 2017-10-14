package com.git.action.users;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class DeleteUsersAction extends ActionSupport{

@Resource
private UsersService usersService;

    private long id;



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

       usersService.deleteUsers(id);

        return SUCCESS;

    }


}