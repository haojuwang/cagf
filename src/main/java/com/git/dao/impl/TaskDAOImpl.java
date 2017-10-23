package com.git.dao.impl;

import java.util.*;
import com.cagf.tool.util.*;

import javax.annotation.Resource;

import com.git.bean.*;
import com.git.dao.*;
import org.springframework.stereotype.Repository;
@Repository("taskDAO")
public class TaskDAOImpl extends BaseDAO<Task> implements TaskDAO
{

	//save
	public void saveTask (Task bean){
		storeObj(bean);
	}

	//saves
	public void saveTask(List<Task> beans){
		storeObjs(beans);
	}

	//remove
	public void removeTask(Long id){
		removeObj(Task.class,id);
	}

	public void removeTask(Task bean){
		removeTask(bean.getId());
	}


    public void removeTasks(List<Long> ids) {
        removeObjs(Task.class,ids);
    }

     public void updateTask(Task bean) {
        updateObj(bean);
     }

     public void updateTasks(List<Task> beans) {
        updateObjs(beans);
     }

	public long getTaskCount(String queryString) {

		return retrieveObjsCount(queryString);
	}

	public long getTaskCount(String queryString, Map<String, Object> params)	{
		return retrieveObjsCount(queryString,params);
	}

	public long  getTaskCount(String queryString, String key, Object value){
		return retrieveObjsCount(queryString,key,value);
	}


	//search
	public  List<Task> searchTasks(String queryString) {
		return retrieveObjs(queryString);
	}

	public  List<Task> searchTasks(String queryString, String key, Object value){

		return retrieveObjs(queryString,key,value);
	}
	public  List<Task> searchTasks(String queryString, Map<String, Object> params){

		return retrieveObjs(queryString,params);
	}

	public	Task	searchTask(String queryString, Map<String, Object> params){
		return retrieveObj(queryString,params);
    }

    public	Task	searchTask(String queryString){
		return retrieveObj(queryString);
    }

    public	Task	searchTask(String queryString, String key, Object value){
		return retrieveObj(queryString,key,value);
    }

    public Task getId(long id) {
         return retrieveObj( Task.class ,id);
    }

    public  List<Task> searchTasks(String queryString, Map<String, Object> params, int start, int number) {
         return retrievePageObjs(queryString,params,start,number);
    }



}