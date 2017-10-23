package com.git.dao;

import java.util.*;


import com.git.bean.*;

public interface TaskDAO
{
//save
public void saveTask (Task bean);

//saves
public void saveTask(List<Task> beans);
//remove
public void removeTask(Long id);

public void removeTask(Task bean);

public void removeTasks(List<Long> ids);

public void updateTask(Task bean);

public void updateTasks(List<Task> beans);

public long getTaskCount(String queryString) ;

public long getTaskCount(String queryString, Map<String, Object> params)	;

public long  getTaskCount(String queryString, String key, Object value);

//search
public  List<Task> searchTasks(String queryString);
public  List<Task> searchTasks(String queryString, String key, Object value);
public  List<Task> searchTasks(String queryString, Map<String, Object> params);

public	Task	searchTask(String queryString, Map<String, Object> params);

public	Task	searchTask(String queryString);

public	Task	searchTask(String queryString, String key, Object value);


public Task getId(long id) ;

public  List<Task> searchTasks(String queryString, Map<String, Object> params, int start, int number) ;
}