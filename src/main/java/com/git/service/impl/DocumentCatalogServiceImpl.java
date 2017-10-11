package com.git.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.git.bean.*;
import com.git.dao.*;
import com.git.service.*;

@Service("documentCatalogService")
public class  DocumentCatalogServiceImpl implements DocumentCatalogService {

    private String list_all_desc = "from DocumentCatalog bean order by bean.id desc";
    private String list_all_asc = "from DocumentCatalog bean order by bean.id asc";
    private String sql_count = "from DocumentCatalog ";

@Resource
DocumentCatalogDAO documentCatalogDAO;

    @Transactional
    public List<DocumentCatalog> listDocumentCatalogs(int start,int range){

        return this.documentCatalogDAO.searchDocumentCatalogs(list_all_desc,null,start,range);
        }

    @Transactional
    public List<DocumentCatalog> listDocumentCatalogDesc(int start,int range){
        return this.documentCatalogDAO.searchDocumentCatalogs(list_all_desc,null,start,range);
        }

    @Transactional
    public List<DocumentCatalog> listDocumentCatalogAsc(int start,int range){
        return this.documentCatalogDAO.searchDocumentCatalogs(list_all_asc,null,start,range);

    }
    @Transactional
    public Long getDocumentCatalogCount(){
        return this.documentCatalogDAO.getDocumentCatalogCount(sql_count);
     }

    @Transactional
    public void saveDocumentCatalog(DocumentCatalog bean){
         this.documentCatalogDAO.saveDocumentCatalog(bean);
    }

    @Transactional
    public void updateDocumentCatalog(DocumentCatalog bean){
         this.documentCatalogDAO.updateDocumentCatalog(bean);
    }

    @Transactional
    public void deleteDocumentCatalog(Long id){
        this.documentCatalogDAO.removeDocumentCatalog(id);
   }

    @Transactional
    public DocumentCatalog getDocumentCatalog(Long id){
       return this.documentCatalogDAO.getId(id);
      }

}
