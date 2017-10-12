package com.git.action.documentcatalog;

import java.util.*;

import com.git.bean.*;
import com.git.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class UpdateDocumentCatalogAction extends ActionSupport{

@Resource
private DocumentCatalogService documentCatalogService;



	private Long id ;

	private String name ;

	private Date date ;

	private boolean flag ;

	private Long authorId ;

	private String authorName ;

	private Integer type ;

	private String content ;

	private Integer order ;

	private String address ;

	private Set children ;

	private Set items ;

	private DocumentCatalog parent ;


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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	public Set getItems() {
		return items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

	public DocumentCatalog getParent() {
		return parent;
	}

	public void setParent(DocumentCatalog parent) {
		this.parent = parent;
	}


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        DocumentCatalog bean = documentCatalogService.getDocumentCatalog( id);

        bean.setId(id) ;
		bean.setName(name) ;
		bean.setDate(date) ;
		bean.setFlag(flag) ;
		bean.setAuthorId(authorId) ;
		bean.setAuthorName(authorName) ;
		bean.setType(type) ;
		bean.setContent(content) ;
		bean.setOrder(order) ;
		bean.setAddress(address) ;
		bean.setChildren(children) ;
		bean.setItems(items) ;
		bean.setParent(parent) ;
		

        documentCatalogService.updateDocumentCatalog(bean);

        return SUCCESS;

    }


}