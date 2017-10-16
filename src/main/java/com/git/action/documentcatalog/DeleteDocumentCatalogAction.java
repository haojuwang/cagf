package com.git.action.documentcatalog;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class DeleteDocumentCatalogAction extends ActionSupport{

@Resource
private DocumentCatalogService documentCatalogService;

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

       documentCatalogService.deleteDocumentCatalog(id);

        return SUCCESS;

    }


}