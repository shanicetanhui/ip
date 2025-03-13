/**
 * The {@code TaskList} class manages the list of tasks in the Pesto task manager.
 * It provides methods for adding, deleting, marking, and searching for tasks.
 */

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    private Ui ui;

    /**
     * Constructs a new {@code TaskList} with an existing list of tasks.
     * If the provided list is {@code null}, an empty list is initialized.
     *
     * @param tasks The list of tasks to initialize with.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks != null ? tasks : new ArrayList<>();
        this.ui = new Ui();
    }

    /**
     * Adds a new task to the list and displays a confirmation message.
     *
     * @param task The {@code Task} to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        ui.showMessage("Added: " + task + "\nNow you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Deletes a task from the list if the index is valid.
     *
     * @param index The index of the task to be deleted (zero-based).
     */
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    /**
     * Marks a task as done or not done based on the given flag.
     *
     * @param index  The index of the task to be marked (zero-based).
     * @param isDone {@code true} to mark the task as done, {@code false} to mark it as not done.
     */
    public void markTask(int index, boolean isDone) {
        if (index >= 0 && index < tasks.size()) {
            if (isDone) {
                tasks.get(index).markAsDone();
            } else {
                tasks.get(index).markAsNotDone();
            }
        }
    }

    /**
     * Retrieves a task at a specific index.
     *
     * @param index The index of the task to retrieve (zero-based).
     * @return The {@code Task} at the specified index, or {@code null} if the index is invalid.
     */
    public Task getTask(int index) {
        return (index >= 0 && index < tasks.size()) ? tasks.get(index) : null;
    }

    /**
     * Returns the list of tasks.
     *
     * @return A {@code List<Task>} containing all tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Prints all tasks in the list. If there are no tasks, a message is displayed.
     */
    public void printTasks() {
        if (tasks.isEmpty()) {
            ui.showMessage("No tasks found! Start your list today.");
        } else {
            ui.printLine();
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            ui.printLine();
        }
    }

    /**
     * Searches for tasks that contain the given keyword in their description.
     *
     * @param keyword The keyword to search for (case-insensitive).
     * @return A {@code List<Task>} containing all matching tasks.
     */
    public List<Task> findTasks(String keyword) {
        List<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}
