/**
 * The {@code Parser} class is responsible for interpreting and executing user commands.
 * It processes user input and performs corresponding actions on the {@link TaskList}.
 */

import java.util.List;

public class Parser {

    /**
     * Parses the user's command and executes the corresponding action.
     *
     * @param input   The user input command.
     * @param taskList The task list to perform operations on.
     * @param ui      The UI handler for displaying messages.
     * @param storage The storage handler for saving and loading tasks.
     * @return {@code false} if the command is "bye" (to exit the application),
     *         otherwise {@code true} to continue running the program.
     */
    public boolean parseCommand(String input, TaskList taskList, Ui ui, Storage storage) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        switch (command) {
        case "bye":
            return false;

        case "list":
            taskList.printTasks();
            break;

        case "todo":
            if (parts.length < 2) {
                ui.showMessage("The description of a todo cannot be empty.");
            } else {
                Task todo = new ToDo(parts[1]);
                taskList.addTask(todo);
                storage.saveTasks(taskList.getTasks());
            }
            break;

        case "deadline":
            if (parts.length < 2 || !parts[1].contains("/by")) {
                ui.showMessage("The description of a deadline must contain '/by'.");
            } else {
                String[] details = parts[1].split("/by", 2);
                Task deadline = new Deadline(details[0].trim(), details[1].trim());
                taskList.addTask(deadline);
                storage.saveTasks(taskList.getTasks());
            }
            break;

        case "event":
            if (parts.length < 2 || !parts[1].contains("/from") || !parts[1].contains("/to")) {
                ui.showMessage("The description of an event must contain '/from' and '/to'.");
            } else {
                String[] details = parts[1].split("/from|/to");
                Task event = new Event(details[0].trim(), details[1].trim(), details[2].trim());
                taskList.addTask(event);
                storage.saveTasks(taskList.getTasks());
            }
            break;

        case "delete": {
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                ui.showMessage("You need to specify a task number to delete.");
            } else {
                try {
                    int taskNumber = Integer.parseInt(parts[1]) - 1;
                    if (taskNumber >= 0 && taskNumber < taskList.getTasks().size()) {
                        Task deletedTask = taskList.getTask(taskNumber);
                        taskList.deleteTask(taskNumber);
                        storage.saveTasks(taskList.getTasks());

                        ui.showMessage("Noted. I've removed this task:\n"
                                + deletedTask
                                + "\nNow you have " + taskList.getTasks().size() + " tasks in the list.");
                    } else {
                        ui.showMessage("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    ui.showMessage("Invalid task number format.");
                }
            }
            break;
        }

        case "mark": {
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                ui.showMessage("Specify a task number to mark.");
            } else {
                try {
                    int taskNumber = Integer.parseInt(parts[1]) - 1;
                    if (taskNumber >= 0 && taskNumber < taskList.getTasks().size()) {
                        taskList.markTask(taskNumber, true);
                        ui.showMessage("Nice! I've marked this task as done:\n" + taskList.getTask(taskNumber));
                        storage.saveTasks(taskList.getTasks());
                    } else {
                        ui.showMessage("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    ui.showMessage("Invalid task number format.");
                }
            }
            break;
        }

        case "unmark": {
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                ui.showMessage("Specify a task number to unmark.");
            } else {
                try {
                    int taskNumber = Integer.parseInt(parts[1]) - 1;
                    if (taskNumber >= 0 && taskNumber < taskList.getTasks().size()) {
                        taskList.markTask(taskNumber, false);
                        ui.showMessage("OK, I've marked this task as not done yet:\n" + taskList.getTask(taskNumber));
                        storage.saveTasks(taskList.getTasks());
                    } else {
                        ui.showMessage("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    ui.showMessage("Invalid task number format.");
                }
            }
            break;
        }

        case "find": {
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                ui.showMessage("Please provide a keyword to search for.");
            } else {
                String keyword = parts[1].trim();
                List<Task> matchingTasks = taskList.findTasks(keyword);

                if (matchingTasks.isEmpty()) {
                    ui.showMessage("No matching tasks found.");
                } else {
                    StringBuilder result = new StringBuilder("Here are the matching tasks in your list:\n");
                    for (int i = 0; i < matchingTasks.size(); i++) {
                        result.append((i + 1)).append(". ").append(matchingTasks.get(i)).append("\n");
                    }
                    ui.showMessage(result.toString().trim());
                }
            }
            break;
        }

        default:
            ui.showMessage("What does this mean??");
        }
        return true;
    }
}
