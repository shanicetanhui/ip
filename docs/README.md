# Pesto - User Guide


## Quick Start

1. Ensure you have Java 17.
2. Download the latest `pesto.jar`.
3. Open a terminal and navigate to the folder containing `pesto.jar`.
4. Run the program using the command:

```angular2html
java -jar pesto.jar
```
5. Start interacting with Pesto by entering commands.


## Feature
### 1. Adding a ToDo Task
Adds a task that needs to be done.

Format:
```angular2html
todo TASK_DESCRIPTION
```
Example:
```angular2html
todo read book
```
Expected Output: 
```angular2html
____________________________________________________________
Added: [T][ ] read book
Now you have 1 task in the list.
____________________________________________________________
```
### 2. Adding a Deadline Task
Adds a task that has a due date.

Format:
```angular2html
deadline TASK_DESCRIPTION /by DATE_OR_TIME
```
Example:
```angular2html
deadline submit assignment /by 2023-12-31
```
Expected Output:
```angular2html
____________________________________________________________
Added: [D][ ] submit assignment (by: 2023-12-31)
Now you have 2 tasks in the list.
____________________________________________________________
```
### 3. Adding an Event Task
Adds an event with a start and end time.

Format:
```angular2html
event TASK_DESCRIPTION /from START_TIME /to END_TIME
```
Example:
```angular2html
event project meeting /from Monday 2pm /to Monday 4pm
```
Expected Output:
```angular2html
____________________________________________________________
Added: [E][ ] project meeting (from: Monday 2pm to: Monday 4pm)
Now you have 3 tasks in the list.
____________________________________________________________
```
### 4. Listing All Tasks
Shows all tasks in your list.

Format:
```angular2html
list
```
Expected Output:
```angular2html
____________________________________________________________
Here are the tasks in your list:
1. [T][ ] read book
2. [D][ ] submit assignment (by: 2023-12-31)
3. [E][ ] project meeting (from: Monday 2pm to: Monday 4pm)
____________________________________________________________
```
### 5. Marking a Task as Done
Marks a task as done.

Format:
```angular2html
mark TASK_NUMBER
```
Example:
```angular2html
mark 1
```
Expected Output:
```angular2html
____________________________________________________________
Nice! I've marked this task as done:
[T][X] read book
____________________________________________________________
```
### 6. Unmarking a Task
Marks a task as not done.

Format:
```angular2html
unmark TASK_NUMBER
```
Example:
```angular2html
unmark 1
```
Expected Output:
```angular2html
____________________________________________________________
OK, I've marked this task as not done yet:
[T][ ] read book
____________________________________________________________
```
### 7. Deleting a Task
Removes a task from the list.

Format:
```angular2html
delete TASK_NUMBER
```
Example:
```angular2html
delete 2
```
Expected Output:
```angular2html
____________________________________________________________
Noted. I've removed this task:
[D][ ] submit assignment (by: 2023-12-31)
Now you have 2 tasks in the list.
____________________________________________________________
```
### 8. Finding Tasks
Searches for tasks containing a keyword.

Format:
```angular2html
find KEYWORD
```
Example:
```angular2html
find book
```
Expected Output:
```angular2html
____________________________________________________________
Here are the matching tasks in your list:
1. [T][X] read book
____________________________________________________________
```
### 9. Exiting the Program
Closes Pesto.

Format:
```angular2html
bye
```
Expected Output:
```angular2html
____________________________________________________________
Bye. Hope to see you again soon!
____________________________________________________________
```
