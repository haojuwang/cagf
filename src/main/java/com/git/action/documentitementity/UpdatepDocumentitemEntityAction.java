package com.git.action.documentitementity;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;



public class UpdatepDocumentitemEntityAction extends ActionSupport{

@Resource
private DocumentitemEntityService documentitemEntityService;

    private long id;


    private DocumentitemEntity documentitemEntity;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DocumentitemEntity getDocumentitemEntity() {

        return this.documentitemEntity;
     }

    public void setDocumentitemEntity(DocumentitemEntity documentitemEntity) {
        this.documentitemEntity = documentitemEntity;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        DocumentitemEntity bean = documentitemEntityService.getDocumentitemEntity(id);

        return SUCCESS;

    }


}