package com.git.dao;

import java.util.*;


import com.git.bean.*;

public interface DocumentitemEntityDAO
{
//save
public void saveDocumentitemEntity (DocumentitemEntity bean);

//saves
public void saveDocumentitemEntity(List<DocumentitemEntity> beans);
//remove
public void removeDocumentitemEntity(Long id);

public void removeDocumentitemEntity(DocumentitemEntity bean);

public void removeDocumentitemEntitys(List<Long> ids);

public void updateDocumentitemEntity(DocumentitemEntity bean);

public void updateDocumentitemEntitys(List<DocumentitemEntity> beans);

public long getDocumentitemEntityCount(String queryString) ;

public long getDocumentitemEntityCount(String queryString, Map<String, Object> params)	;

public long  getDocumentitemEntityCount(String queryString, String key, Object value);

//search
public  List<DocumentitemEntity> searchDocumentitemEntitys(String queryString);
public  List<DocumentitemEntity> searchDocumentitemEntitys(String queryString, String key, Object value);
public  List<DocumentitemEntity> searchDocumentitemEntitys(String queryString, Map<String, Object> params);

public	DocumentitemEntity	searchDocumentitemEntity(String queryString, Map<String, Object> params);

public	DocumentitemEntity	searchDocumentitemEntity(String queryString);

public	DocumentitemEntity	searchDocumentitemEntity(String queryString, String key, Object value);


public DocumentitemEntity getId(long id) ;

public  List<DocumentitemEntity> searchDocumentitemEntitys(String queryString, Map<String, Object> params, int start, int number) ;
}