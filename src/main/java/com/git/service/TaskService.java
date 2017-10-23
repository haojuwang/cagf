package com.git.service;

import java.util.*;


import com.git.bean.*;

public interface TaskService {

    public List<Task> listTasks(int start,int range);
    public List<Task> listTaskDesc(int start,int range);
    public List<Task> listTaskAsc(int start,int range);
    public Long getTaskCount();

    public void saveTask(Task bean);
    public void updateTask(Task bean);
    public void deleteTask(Long id);

    public Task getTask(Long id);

}
