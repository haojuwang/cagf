package com.git.action.documentitementity;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class UpdateDocumentitemEntityAction extends ActionSupport{

@Resource
private DocumentitemEntityService documentitemEntityService;



	private Long id ;

	private String name ;

	private Long authorId ;

	private String authorName ;

	private Date date ;

	private Integer realSize ;

	private String size ;

	private String randomName ;

	private String type ;

	private DocumentCatalog documentCatalog ;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getRealSize() {
		return realSize;
	}

	public void setRealSize(Integer realSize) {
		this.realSize = realSize;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getRandomName() {
		return randomName;
	}

	public void setRandomName(String randomName) {
		this.randomName = randomName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DocumentCatalog getDocumentCatalog() {
		return documentCatalog;
	}

	public void setDocumentCatalog(DocumentCatalog documentCatalog) {
		this.documentCatalog = documentCatalog;
	}


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        DocumentitemEntity bean = documentitemEntityService.getDocumentitemEntity( id);

        bean.setId(id) ;
		bean.setName(name) ;
		bean.setAuthorId(authorId) ;
		bean.setAuthorName(authorName) ;
		bean.setDate(date) ;
		bean.setRealSize(realSize) ;
		bean.setSize(size) ;
		bean.setRandomName(randomName) ;
		bean.setType(type) ;
		bean.setDocumentCatalog(documentCatalog) ;
		

        documentitemEntityService.updateDocumentitemEntity(bean);

        return SUCCESS;

    }


}