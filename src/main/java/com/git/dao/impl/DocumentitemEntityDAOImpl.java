package com.git.dao.impl;

import java.util.*;
import com.cagf.tool.util.*;

import javax.annotation.Resource;

import com.git.bean.*;
import com.git.dao.*;
import org.springframework.stereotype.Repository;
@Repository("documentitemEntityDAO")
public class DocumentitemEntityDAOImpl extends BaseDAO<DocumentitemEntity> implements DocumentitemEntityDAO
{

	//save
	public void saveDocumentitemEntity (DocumentitemEntity bean){
		storeObj(bean);
	}

	//saves
	public void saveDocumentitemEntity(List<DocumentitemEntity> beans){
		storeObjs(beans);
	}

	//remove
	public void removeDocumentitemEntity(Long id){
		removeObj(DocumentitemEntity.class,id);
	}

	public void removeDocumentitemEntity(DocumentitemEntity bean){
		removeDocumentitemEntity(bean.getId());
	}


    public void removeDocumentitemEntitys(List<Long> ids) {
        removeObjs(DocumentitemEntity.class,ids);
    }

     public void updateDocumentitemEntity(DocumentitemEntity bean) {
        updateObj(bean);
     }

     public void updateDocumentitemEntitys(List<DocumentitemEntity> beans) {
        updateObjs(beans);
     }

	public long getDocumentitemEntityCount(String queryString) {

		return retrieveObjsCount(queryString);
	}

	public long getDocumentitemEntityCount(String queryString, Map<String, Object> params)	{
		return retrieveObjsCount(queryString,params);
	}

	public long  getDocumentitemEntityCount(String queryString, String key, Object value){
		return retrieveObjsCount(queryString,key,value);
	}


	//search
	public  List<DocumentitemEntity> searchDocumentitemEntitys(String queryString) {
		return retrieveObjs(queryString);
	}

	public  List<DocumentitemEntity> searchDocumentitemEntitys(String queryString, String key, Object value){

		return retrieveObjs(queryString,key,value);
	}
	public  List<DocumentitemEntity> searchDocumentitemEntitys(String queryString, Map<String, Object> params){

		return retrieveObjs(queryString,params);
	}

	public	DocumentitemEntity	searchDocumentitemEntity(String queryString, Map<String, Object> params){
		return retrieveObj(queryString,params);
    }

    public	DocumentitemEntity	searchDocumentitemEntity(String queryString){
		return retrieveObj(queryString);
    }

    public	DocumentitemEntity	searchDocumentitemEntity(String queryString, String key, Object value){
		return retrieveObj(queryString,key,value);
    }

    public DocumentitemEntity getId(long id) {
         return retrieveObj( DocumentitemEntity.class ,id);
    }

    public  List<DocumentitemEntity> searchDocumentitemEntitys(String queryString, Map<String, Object> params, int start, int number) {
         return retrievePageObjs(queryString,params,start,number);
    }



}