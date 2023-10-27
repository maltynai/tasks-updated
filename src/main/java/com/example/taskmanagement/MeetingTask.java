package com.example.taskmanagement;

import java.util.Date;

public class MeetingTask implements Task{
    private String taskName;
    private String description;
    private boolean completed;
    private Priority priority;
    private Date  deadline;
    public void setTask(String taskName, String taskDescription) {

    }

    public void setTaskName(String taskName) {

    }

    public void setTaskDescription(String taskDescription) {

    }

    public void markAsComplete() {

    }

    public void setPriority(Priority priority) {

    }

    public void setDeadline(Date date) {

    }
    public String toString(){
        return "Meeting : "+ this.taskName + " "+this.completed;
    }
}
