package com.example.taskmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Date;
import java.time.ZoneId;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class HelloController {
    @FXML
    private ListView<Task> listView;

    ObservableList<Task> tasks = FXCollections.observableArrayList();
//    public void initialize() {
//        listView.setItems(tasks);
//    }

    @FXML
    private Label taskType;
    @FXML
    private ChoiceBox<String> taskChoiceBox;
    protected String[] tasksType = {"Homework task","Meeting task", "Shopping task"};
    public void initialize() {
        taskChoiceBox.getItems().addAll(tasksType);
//        taskChoiceBox.setOnAction(this::getTask);
    }
//    public void getTask(ActionEvent event){
//        String task = taskChoiceBox.getValue();
//    }

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

    HomeworkTask ht = new HomeworkTask();
    MeetingTask mt = new MeetingTask();
    ShoppingTask st = new ShoppingTask();

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
        }
        else if (task == "Meeting task"){
            mt.setTask(nameTask.getText(), descriptionTask.getText());
            tasks.add(mt);
            mt.setDeadline(userDeadline);
            RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
            String selectedRadioButtonText = selectedRadioButton.getText();
            Priority priority = Priority.valueOf(selectedRadioButtonText);
            ht.setPriority(priority);
        }
        else if (task == "Shopping task"){
            st.setTask(nameTask.getText(), descriptionTask.getText());
            tasks.add(st);
            st.setDeadline(userDeadline);
            RadioButton selectedRadioButton = (RadioButton) radioGroup.getSelectedToggle();
            String selectedRadioButtonText = selectedRadioButton.getText();
            Priority priority = Priority.valueOf(selectedRadioButtonText);
            ht.setPriority(priority);
        }
    }


//    @FXML
//    protected void onListClicked(){
//        int i = listView.getSelectionModel().getSelectedIndex();
//        selectedText.setText(tasks.get(i).toString());
//
//    }

//    @FXML
//    protected void onListViewSelected(){
//        int i = listView.getSelectionModel().getSelectedIndex();
//        label.setText(""+i);
//
//        HomeworkTask ht = (HomeworkTask) tasks.get(i);
//
//        inputName.setText(ht.getTaskName());
//        inputDesc.setText(ht.getDescription());
//    }
}