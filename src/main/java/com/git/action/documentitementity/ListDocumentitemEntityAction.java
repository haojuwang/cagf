package com.git.action.documentitementity;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class ListDocumentitemEntityAction extends ActionSupport{

@Resource
private DocumentitemEntityService documentitemEntityService;

    private List<DocumentitemEntity> list;

    public void setList(List<DocumentitemEntity> list) {
        this.list = list;

     }

     public List<DocumentitemEntity> getList(){

        return this.list;
     }

    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        this.list = this.documentitemEntityService.listDocumentitemEntitys(0,10);

        return SUCCESS;

    }


}