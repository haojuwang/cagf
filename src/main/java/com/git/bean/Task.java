package com.git.bean;
// Generated 2017-10-22 18:06:10 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Task generated by hbm2java
 */
public class Task  implements java.io.Serializable {


     private Long id;
     private String name;
     private String description;
     private Date plannedStartDate;
     private Date plannedEndDate;
     private Set<Task> children = new HashSet<Task>(0);
     private Task parent;

    public Task() {
    }

    public Task(String name, String description, Date plannedStartDate, Date plannedEndDate, Set<Task> children, Task parent) {
       this.name = name;
       this.description = description;
       this.plannedStartDate = plannedStartDate;
       this.plannedEndDate = plannedEndDate;
       this.children = children;
       this.parent = parent;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getPlannedStartDate() {
        return this.plannedStartDate;
    }
    
    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }
    public Date getPlannedEndDate() {
        return this.plannedEndDate;
    }
    
    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }
    public Set<Task> getChildren() {
        return this.children;
    }
    
    public void setChildren(Set<Task> children) {
        this.children = children;
    }
    public Task getParent() {
        return this.parent;
    }
    
    public void setParent(Task parent) {
        this.parent = parent;
    }




}

