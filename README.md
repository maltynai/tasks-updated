# taskManagement
The Task Management Application is designed to help you keep track of various tasks, including homework assignments, meetings, and shopping lists. It provides a user-friendly graphical interface to create, edit, and delete tasks of different types, set priorities, and manage task deadlines.

## Application Structure
The application is structured into three main components:

**User Interface (UI):** The user interface is implemented using JavaFX and provides a clean and intuitive way to interact with the application. It includes a task list view and an input form for creating and editing tasks.

**Task Classes:** The application includes three specific task classes: **'HomeworkTask'**, **'MeetingTask'**, and **'ShoppingTask'**. Each of these classes implements a common **'Task'** interface, allowing for easy management of tasks of different types.

**Task Management Logic:** The logic for managing tasks, including adding, updating, and deleting tasks, is implemented in the **'HelloController'** class, which serves as the controller for the UI.

## How to Use
1. Launch the application by running the **'HelloApplication'** class.

2. The application's UI will appear, featuring a task list on the left and an input form on the right.

3. You can select the type of task (e.g., Homework, Meeting, Shopping) from the drop-down menu, fill in the task details, set priorities, and specify deadlines.

4. Click "SAVE" to add a task to the list.

5. Click on an existing task in the list to view and edit its details.

6. Click "CHANGE" to update the task details.

7. To delete a task, select it in the list and click "DELETE."

8. Tasks are organized by type and displayed in the task list.

## Class Descriptions
**'HelloController':** The main controller class for the UI, responsible for managing user interactions and task operations.

**'HomeworkTask', 'MeetingTask', 'ShoppingTask':** Specific task classes representing homework assignments, meetings, and shopping tasks, respectively.

**'Task':** An interface defining common methods for managing tasks, such as setting details, marking as complete, setting priorities, and specifying deadlines.

**'Priority':** An enum representing task priorities with values **'LOW'**, **'MEDIUM'**, and **'HIGH'**.
