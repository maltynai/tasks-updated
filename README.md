# taskManagement
The Task Management Application is designed to help you keep track of various tasks, including homework assignments, meetings, and shopping lists. It provides a user-friendly graphical interface to create, edit, and delete tasks of different types, set priorities, and manage task deadlines.

## Application Structure
The application is structured into three main components:

**User Interface (UI):** The user interface is implemented using JavaFX and provides a clean and intuitive way to interact with the application. It includes a task list view and an input form for creating and editing tasks.

**Task Classes:** The application includes three specific task classes: **'HomeworkTask'**, **'MeetingTask'**, and **'ShoppingTask'**. Each of these classes extends a common **'Task'** class, allowing for easy management of tasks of different types. And **'Task'** implements **'TaskInterface'** interface.

**Task Management Logic:** The logic for managing tasks, including adding, updating, and deleting tasks, is implemented in the **'HelloController'** class, which serves as the controller for the UI.

**Database implementation:** Tasks are efficiently managed within the database, allowing for seamless operations such as task creation, updating existing tasks, and deletion, all while maintaining data integrity.

## How to Use
1. Clone or download **taskManagement** repository.
2. Open your database editor and run the script.sql from /src/main/sql/.
3. Open **'TaskDAO'** class and replace **url**, **username**, **password** with your actual values.
4. Open **taskManagement** repository in your code editor.
5. Launch the application by running the **'HelloApplication'** class.
6. The application's UI will appear, featuring a task list on the left and an input form on the right.
7. You can select the type of task (e.g., Homework, Meeting, Shopping) from the drop-down menu, fill in the task details, set priorities, and specify deadlines.
8. Click "SAVE" to add a task to the list on the left side.
9. Click on an existing task in the list to view, click "CLEAR" to clear the form.
10. For editing task, choose it from list, edit it, then click "SAVE".
11. To delete a task, select it in the list and click "DELETE."

## Class Descriptions
**'HelloController':** The main controller class for the UI, responsible for managing user interactions and task operations.

**'Task':** A superclass for **'HomeworkTask', 'MeetingTask', 'ShoppingTask'**.

**'HomeworkTask', 'MeetingTask', 'ShoppingTask':** Specific task classes representing homework assignments, meetings, and shopping tasks, respectively.

**'TaskInterface':** An interface defining common methods for managing tasks, such as setting details, marking as complete, setting priorities, and specifying deadlines.

**'Priority':** An enum representing task priorities with values **'LOW'**, **'MEDIUM'**, and **'HIGH'**.

**'TaskDAO':** A class for managing CRUD operatioins using database.
