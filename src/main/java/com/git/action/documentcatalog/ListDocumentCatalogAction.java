package com.git.action.documentcatalog;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;
import com.cagf.tool.util.* ;
import org.apache.struts2.ServletActionContext;

public class ListDocumentCatalogAction extends ActionSupport{

@Resource
private DocumentCatalogService documentCatalogService;

    private int start;
    private int range;
    private String pageInfo;


    private List<DocumentCatalog> list;

    public void setList(List<DocumentCatalog> list) {
        this.list = list;

     }

     public List<DocumentCatalog> getList(){

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


        long count = this.documentCatalogService.getDocumentCatalogCount();
        this.pageInfo = Page.getPage(ServletActionContext.getRequest(),"",start,range,count);
        this.list = this.documentCatalogService.listDocumentCatalogs(this.start,this.range);

        return SUCCESS;

    }


}