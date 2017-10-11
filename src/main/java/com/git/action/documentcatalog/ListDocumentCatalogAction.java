package com.git.action.documentcatalog;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class ListDocumentCatalogAction extends ActionSupport{

@Resource
private DocumentCatalogService documentCatalogService;

    private List<DocumentCatalog> list;

    public void setList(List<DocumentCatalog> list) {
        this.list = list;

     }

     public List<DocumentCatalog> getList(){

        return this.list;
     }

    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        this.list = this.documentCatalogService.listDocumentCatalogs(0,10);

        return SUCCESS;

    }


}