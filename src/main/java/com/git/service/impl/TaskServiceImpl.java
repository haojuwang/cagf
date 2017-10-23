package com.git.service.impl;

import java.util.*;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.git.bean.*;
import com.git.dao.*;
import com.git.service.*;

@Service("taskService")
public class  TaskServiceImpl implements TaskService {

    private String list_all_desc = "from Task bean order by bean.id desc";
    private String list_all_asc = "from Task bean order by bean.id asc";
    private String sql_count = "from Task ";

@Resource
TaskDAO taskDAO;

    @Transactional
    public List<Task> listTasks(int start,int range){

        return this.taskDAO.searchTasks(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Task> listTaskDesc(int start,int range){
        return this.taskDAO.searchTasks(list_all_desc,null,start,range);
        }

    @Transactional
    public List<Task> listTaskAsc(int start,int range){
        return this.taskDAO.searchTasks(list_all_asc,null,start,range);

    }
    @Transactional
    public Long getTaskCount(){
        return this.taskDAO.getTaskCount(sql_count);
     }

    @Transactional
    public void saveTask(Task bean){
         this.taskDAO.saveTask(bean);
    }

    @Transactional
    public void updateTask(Task bean){
         this.taskDAO.updateTask(bean);
    }

    @Transactional
    public void deleteTask(Long id){
        this.taskDAO.removeTask(id);
   }

    @Transactional
    public Task getTask(Long id){
       return this.taskDAO.getId(id);
      }

}
