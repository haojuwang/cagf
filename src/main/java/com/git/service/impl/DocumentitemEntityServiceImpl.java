package com.git.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.git.bean.*;
import com.git.dao.*;
import com.git.service.*;

@Service("documentitemEntityService")
public class  DocumentitemEntityServiceImpl implements DocumentitemEntityService {

    private String list_all_desc = "from DocumentitemEntity bean order by bean.id desc";
    private String list_all_asc = "from DocumentitemEntity bean order by bean.id asc";
    private String sql_count = "from DocumentitemEntity ";

@Resource
DocumentitemEntityDAO documentitemEntityDAO;

    @Transactional
    public List<DocumentitemEntity> listDocumentitemEntitys(int start,int range){

        return this.documentitemEntityDAO.searchDocumentitemEntitys(list_all_desc,null,start,range);
        }

    @Transactional
    public List<DocumentitemEntity> listDocumentitemEntityDesc(int start,int range){
        return this.documentitemEntityDAO.searchDocumentitemEntitys(list_all_desc,null,start,range);
        }

    @Transactional
    public List<DocumentitemEntity> listDocumentitemEntityAsc(int start,int range){
        return this.documentitemEntityDAO.searchDocumentitemEntitys(list_all_asc,null,start,range);

    }
    @Transactional
    public Long getDocumentitemEntityCount(){
        return this.documentitemEntityDAO.getDocumentitemEntityCount(sql_count);
     }

    @Transactional
    public void saveDocumentitemEntity(DocumentitemEntity bean){
         this.documentitemEntityDAO.saveDocumentitemEntity(bean);
    }

    @Transactional
    public void updateDocumentitemEntity(DocumentitemEntity bean){
         this.documentitemEntityDAO.updateDocumentitemEntity(bean);
    }

    @Transactional
    public void deleteDocumentitemEntity(Long id){
        this.documentitemEntityDAO.removeDocumentitemEntity(id);
   }

    @Transactional
    public DocumentitemEntity getDocumentitemEntity(Long id){
       return this.documentitemEntityDAO.getId(id);
      }

}
