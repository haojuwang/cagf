package com.git.service;

import java.util.*;


import com.git.bean.*;

public interface DocumentitemEntityService {

    public List<DocumentitemEntity> listDocumentitemEntitys(int start,int range);
    public List<DocumentitemEntity> listDocumentitemEntityDesc(int start,int range);
    public List<DocumentitemEntity> listDocumentitemEntityAsc(int start,int range);
    public Long getDocumentitemEntityCount();

    public void saveDocumentitemEntity(DocumentitemEntity bean);
    public void updateDocumentitemEntity(DocumentitemEntity bean);
    public void deleteDocumentitemEntity(Long id);

    public DocumentitemEntity getDocumentitemEntity(Long id);

}
