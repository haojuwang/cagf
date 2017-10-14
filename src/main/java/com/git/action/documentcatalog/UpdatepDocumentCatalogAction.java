package com.git.action.documentcatalog;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;



public class UpdatepDocumentCatalogAction extends ActionSupport{

@Resource
private DocumentCatalogService documentCatalogService;

    private long id;


    private DocumentCatalog documentCatalog;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DocumentCatalog getDocumentCatalog() {

        return this.documentCatalog;
     }

    public void setDocumentCatalog(DocumentCatalog documentCatalog) {
        this.documentCatalog = documentCatalog;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        documentCatalog = documentCatalogService.getDocumentCatalog(id);

        return SUCCESS;

    }


}