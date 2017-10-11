package com.git.dao;

import java.util.*;


import com.git.bean.*;

public interface DocumentCatalogDAO
{
//save
public void saveDocumentCatalog (DocumentCatalog bean);

//saves
public void saveDocumentCatalog(List<DocumentCatalog> beans);
//remove
public void removeDocumentCatalog(Long id);

public void removeDocumentCatalog(DocumentCatalog bean);

public void removeDocumentCatalogs(List<Long> ids);

public void updateDocumentCatalog(DocumentCatalog bean);

public void updateDocumentCatalogs(List<DocumentCatalog> beans);

public long getDocumentCatalogCount(String queryString) ;

public long getDocumentCatalogCount(String queryString, Map<String, Object> params)	;

public long  getDocumentCatalogCount(String queryString, String key, Object value);

//search
public  List<DocumentCatalog> searchDocumentCatalogs(String queryString);
public  List<DocumentCatalog> searchDocumentCatalogs(String queryString, String key, Object value);
public  List<DocumentCatalog> searchDocumentCatalogs(String queryString, Map<String, Object> params);

public	DocumentCatalog	searchDocumentCatalog(String queryString, Map<String, Object> params);

public	DocumentCatalog	searchDocumentCatalog(String queryString);

public	DocumentCatalog	searchDocumentCatalog(String queryString, String key, Object value);


public DocumentCatalog getId(long id) ;

public  List<DocumentCatalog> searchDocumentCatalogs(String queryString, Map<String, Object> params, int start, int number) ;
}