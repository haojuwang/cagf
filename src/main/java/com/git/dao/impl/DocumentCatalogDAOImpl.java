package com.git.dao.impl;

import java.util.*;
import com.cagf.tool.util.*;

import javax.annotation.Resource;

import com.git.bean.*;
import com.git.dao.*;
import org.springframework.stereotype.Repository;
@Repository("documentCatalogDAO")
public class DocumentCatalogDAOImpl extends BaseDAO<DocumentCatalog> implements DocumentCatalogDAO
{

	//save
	public void saveDocumentCatalog (DocumentCatalog bean){
		storeObj(bean);
	}

	//saves
	public void saveDocumentCatalog(List<DocumentCatalog> beans){
		storeObjs(beans);
	}

	//remove
	public void removeDocumentCatalog(Long id){
		removeObj(DocumentCatalog.class,id);
	}

	public void removeDocumentCatalog(DocumentCatalog bean){
		removeDocumentCatalog(bean.getId());
	}


    public void removeDocumentCatalogs(List<Long> ids) {
        removeObjs(DocumentCatalog.class,ids);
    }

     public void updateDocumentCatalog(DocumentCatalog bean) {
        updateObj(bean);
     }

     public void updateDocumentCatalogs(List<DocumentCatalog> beans) {
        updateObjs(beans);
     }

	public long getDocumentCatalogCount(String queryString) {

		return retrieveObjsCount(queryString);
	}

	public long getDocumentCatalogCount(String queryString, Map<String, Object> params)	{
		return retrieveObjsCount(queryString,params);
	}

	public long  getDocumentCatalogCount(String queryString, String key, Object value){
		return retrieveObjsCount(queryString,key,value);
	}


	//search
	public  List<DocumentCatalog> searchDocumentCatalogs(String queryString) {
		return retrieveObjs(queryString);
	}

	public  List<DocumentCatalog> searchDocumentCatalogs(String queryString, String key, Object value){

		return retrieveObjs(queryString,key,value);
	}
	public  List<DocumentCatalog> searchDocumentCatalogs(String queryString, Map<String, Object> params){

		return retrieveObjs(queryString,params);
	}

	public	DocumentCatalog	searchDocumentCatalog(String queryString, Map<String, Object> params){
		return retrieveObj(queryString,params);
    }

    public	DocumentCatalog	searchDocumentCatalog(String queryString){
		return retrieveObj(queryString);
    }

    public	DocumentCatalog	searchDocumentCatalog(String queryString, String key, Object value){
		return retrieveObj(queryString,key,value);
    }

    public DocumentCatalog getId(long id) {
         return retrieveObj( DocumentCatalog.class ,id);
    }

    public  List<DocumentCatalog> searchDocumentCatalogs(String queryString, Map<String, Object> params, int start, int number) {
         return retrievePageObjs(queryString,params,start,number);
    }



}