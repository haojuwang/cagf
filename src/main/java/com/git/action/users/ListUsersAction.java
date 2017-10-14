package com.git.action.users;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class ListUsersAction extends ActionSupport{

@Resource
private UsersService usersService;

    private List<Users> list;

    public void setList(List<Users> list) {
        this.list = list;

     }

     public List<Users> getList(){

        return this.list;
     }

    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        this.list = this.usersService.listUserss(0,10);

        return SUCCESS;

    }


}