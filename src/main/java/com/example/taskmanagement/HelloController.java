package com.example.taskmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class HelloController {
    @FXML
    private ListView<Task> listView;
    ObservableList<Task> tasks = FXCollections.observableArrayList();

    @FXML
    private Label taskType;
    @FXML
    private ChoiceBox<String> taskChoiceBox;
    protected String[] tasksType = {"Homework task","Meeting task", "Shopping task"};
    @FXML
    private Label taskName;
    @FXML
    private TextField nameTask;
    @FXML
    private Label taskDescription;
    @FXML
    private TextField descriptionTask;
    @FXML
    private Label deadline;
    @FXML
    private DatePicker deadLine;
    @FXML
    private ToggleGroup radioGroup;
    @FXML
    private RadioButton lowRadioButton;
    @FXML
    private RadioButton mediumRadioButton;
    @FXML
    private RadioButton highRadioButton;
    @FXML
    private CheckBox checkBox;

    HomeworkTask ht = new HomeworkTask();
    MeetingTask mt = new MeetingTask();
    ShoppingTask st = new ShoppingTask();

    public void initialize() {
        listView.setItems(tasks);
        taskChoiceBox.getItems().addAll(tasksType);
    }
    @FXML
    protected void onSaveButtonClick(){

        String task = taskChoiceBox.getValue();
        Date userDeadline = null;
        if (deadLine.getValue() != null){
            userDeadline = Date.from(deadLine.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        if (task == "Homework task"){
            ht.setTask(nameTask.getText(), descriptionTask.getText());
            tasks.add(ht);
            ht.setDeadline(userDeadline);
            RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
            String selectedRadioButtonText = selectedRadioButton.getText();
            Priority priority = Priority.valueOf(selectedRadioButtonText);
            ht.setPriority(priority);
            ht.markAsComplete(checkBox.isSelected());
        }
        else if (task == "Meeting task"){
            mt.setTask(nameTask.getText(), descriptionTask.getText());
            tasks.add(mt);
            mt.setDeadline(userDeadline);
            RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
            String selectedRadioButtonText = selectedRadioButton.getText();
            Priority priority = Priority.valueOf(selectedRadioButtonText);
            mt.setPriority(priority);
            mt.markAsComplete(checkBox.isSelected());
        }
        else if (task == "Shopping task"){
            st.setTask(nameTask.getText(), descriptionTask.getText());
            tasks.add(st);
            st.setDeadline(userDeadline);
            RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
            String selectedRadioButtonText = selectedRadioButton.getText();
            Priority priority = Priority.valueOf(selectedRadioButtonText);
            st.setPriority(priority);
            st.markAsComplete(checkBox.isSelected());
        }
        taskChoiceBox.setValue("");
        nameTask.setText("");
        descriptionTask.setText("");
        deadLine.setValue(null);
        lowRadioButton.setSelected(true);
        checkBox.setSelected(false);
    }

    @FXML
    protected void onListViewSelected(){
        Task selectedTask = listView.getSelectionModel().getSelectedItem();
        System.out.println(selectedTask);
        if (selectedTask != null) {
            if (selectedTask instanceof HomeworkTask) {
                HomeworkTask ht = (HomeworkTask) selectedTask;
                taskChoiceBox.setValue("Homework task");
                nameTask.setText(ht.getTaskName());
                descriptionTask.setText(ht.getDescription());
                if (ht.getDeadline() != null) {
                    deadLine.setValue(ht.getDeadline().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                }
                lowRadioButton.setSelected(ht.getPriority() == Priority.LOW);
                mediumRadioButton.setSelected(ht.getPriority() == Priority.MEDIUM);
                highRadioButton.setSelected(ht.getPriority() == Priority.HIGH);
                checkBox.setSelected(ht.isCompleted());
            }
            else if (selectedTask instanceof MeetingTask) {
                MeetingTask mt = (MeetingTask) selectedTask;
                taskChoiceBox.setValue("Meeting task");
                nameTask.setText(mt.getTaskName());
                descriptionTask.setText(mt.getDescription());
                if (mt.getDeadline() != null) {
                    deadLine.setValue(mt.getDeadline().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                }
                lowRadioButton.setSelected(mt.getPriority() == Priority.LOW);
                mediumRadioButton.setSelected(mt.getPriority() == Priority.MEDIUM);
                highRadioButton.setSelected(mt.getPriority() == Priority.HIGH);
                checkBox.setSelected(mt.isCompleted());
            }
            else if (selectedTask instanceof ShoppingTask) {
                ShoppingTask st = (ShoppingTask) selectedTask;
                taskChoiceBox.setValue("Shopping task");
                nameTask.setText(st.getTaskName());
                descriptionTask.setText(st.getDescription());
                if (st.getDeadline() != null) {
                    deadLine.setValue(st.getDeadline().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                }
                lowRadioButton.setSelected(st.getPriority() == Priority.LOW);
                mediumRadioButton.setSelected(st.getPriority() == Priority.MEDIUM);
                highRadioButton.setSelected(st.getPriority() == Priority.HIGH);
                checkBox.setSelected(st.isCompleted());
            }
        }
    }

    @FXML
    public void onChangeButtonClick() {
        Task selectedTask = listView.getSelectionModel().getSelectedItem();

        if (selectedTask != null) {
            String taskType = taskChoiceBox.getValue();
            String taskName = nameTask.getText();
            String taskDescription = descriptionTask.getText();
            LocalDate selectedDate = deadLine.getValue();
            Date userDeadline = null;

            if (selectedDate != null) {
                userDeadline = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            }

            RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
            String selectedRadioButtonText = selectedRadioButton.getText();
            Priority priority = Priority.valueOf(selectedRadioButtonText);

            boolean isCompleted = checkBox.isSelected();

            selectedTask.setTaskName(taskName);
            selectedTask.setTaskDescription(taskDescription);
            selectedTask.setDeadline(userDeadline);
            selectedTask.setPriority(priority);
            selectedTask.markAsComplete(isCompleted);

            onListViewSelected();
        }
    }

    @FXML
    public void onDeleteButtonClick() {
        Task selectedTask = listView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            tasks.remove(selectedTask);

        }
        taskChoiceBox.setValue("");
        nameTask.clear();
        descriptionTask.clear();
        deadLine.setValue(null);
        lowRadioButton.setSelected(true);
        checkBox.setSelected(false);
    }
}