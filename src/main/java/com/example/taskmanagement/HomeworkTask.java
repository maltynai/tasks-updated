package com.example.taskmanagement;

import java.util.Date;

public class HomeworkTask implements Task{
    private String taskName;
    private String description;
    private boolean completed;
    private Priority priority;
    private Date  deadline;

    public void setTask(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.description = taskDescription;
        this.completed = false;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.description = taskDescription;
    }

    public void markAsComplete() {
        this.completed = true;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDeadline(Date date) {
        this.deadline = date;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskName() {
        return taskName;
    }

    public String toString(){
        return "Homework: "+ this.taskName + " "+this.completed;
    }




}
