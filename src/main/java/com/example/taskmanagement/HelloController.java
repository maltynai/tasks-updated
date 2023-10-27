package com.example.taskmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ListView<Task> listView;

    ObservableList<Task> tasks = FXCollections.observableArrayList();

    public void initialize() {
        listView.setItems(tasks);
    }

    @FXML
    private Label taskName;
    @FXML
    private Label taskDescription;
    @FXML
    private Label deadline;
    @FXML
    private TextField nameTask;
    @FXML
    private TextField descriptionTask;

    DatePicker datePicker = new DatePicker();
    datePicker.setValue(LocalDate.now()); // Set an initial date (today)
    datePicker.setPromptText("Select a date"); // Placeholder text
    datePicker.setOnAction(event -> {
        LocalDate selectedDate = datePicker.getValue();
        System.out.println("Selected date: " + selectedDate);
    });
    @FXML
    protected void onListClicked(){
        int i = listView.getSelectionModel().getSelectedIndex();
        selectedText.setText(tasks.get(i).toString());

    }
}