import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    private Ui ui;

    public TaskList(List<Task> tasks) {
        this.tasks = tasks != null ? tasks : new ArrayList<>();
        this.ui = new Ui();
    }

    public void addTask(Task task) {
        tasks.add(task);
        ui.showMessage("Added: " + task + "\nNow you have " + tasks.size() + " tasks in the list.");
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void markTask(int index, boolean isDone) {
        if (index >= 0 && index < tasks.size()) {
            if (isDone) {
                tasks.get(index).markAsDone();
            } else {
                tasks.get(index).markAsNotDone();
            }
        }
    }

    public Task getTask(int index) {
        return (index >= 0 && index < tasks.size()) ? tasks.get(index) : null;
    }

    public List<Task> getTasks() {
        return tasks;
    }

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
}
