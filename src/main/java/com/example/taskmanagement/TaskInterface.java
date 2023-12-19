package com.example.taskmanagement;

import java.util.Date;

public interface TaskInterface {
    void setTask(String taskName, String taskDescription);
    void setTaskName(String taskName);
    void setTaskDescription(String taskDescription);
    void markAsComplete(boolean completed);
    void setPriority(Priority priority);
    void setDeadline(Date deadline);
}