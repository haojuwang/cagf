package com.git.service;

import java.util.*;


import com.git.bean.*;

public interface DocumentCatalogService {

    public List<DocumentCatalog> listDocumentCatalogs(int start,int range);
    public List<DocumentCatalog> listDocumentCatalogDesc(int start,int range);
    public List<DocumentCatalog> listDocumentCatalogAsc(int start,int range);
    public Long getDocumentCatalogCount();

    public void saveDocumentCatalog(DocumentCatalog bean);
    public void updateDocumentCatalog(DocumentCatalog bean);
    public void deleteDocumentCatalog(Long id);

    public DocumentCatalog getDocumentCatalog(Long id);

}
