import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {
    private static final String FILE_PATH = "./data/duke.txt"; // Relative path to save file

    public static void main(String[] args) {
        String logo = " ____            _         \n"
                + "|  __ \\         | |  ___    \n"
                + "| |__) |___  ___| |_/ _ \\ \n"
                + "|  ___/ _ \\/ __| __| | | |\n"
                + "| |  |  __/\\__ \\ |_| |_| |\n"
                + "|_|   \\___||___/\\__|\\__,_|\n";
        System.out.println("Hello from\n" + logo);

        // Greeting message
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Pesto!");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        Scanner sc = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int taskCount = loadTasks(tasks);

        while (true) {
            String input = sc.nextLine();
            String[] inputParts = input.split(" ", 2);
            String command = inputParts[0];

            // Exit if user types "bye"
            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            }

            // Display all tasks entered so far
            switch (command) {
            case "list" -> {
                System.out.println("____________________________________________________________");
                if (taskCount == 0) {
                    System.out.println("No tasks found! Start your list today.");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }
                }
                System.out.println("____________________________________________________________");

                // To Do tasks
            }
            case "todo" -> {
                if (inputParts.length < 2 || inputParts[1].trim().isEmpty()) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" The description of a todo cannot be empty.");
                    System.out.println("____________________________________________________________");
                } else {
                    Task todo = new ToDo(inputParts[1]);  // Create new todo
                    taskCount = getTaskCount(tasks, taskCount, todo);
                    saveTasks(tasks, taskCount);
                }

                // Deadline tasks
            }
            case "deadline" -> {
                if (inputParts.length < 2 || !inputParts[1].contains("/by")) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" The description of a deadline must contain '/by'.");
                    System.out.println("____________________________________________________________");
                } else {
                    String[] descAndTime = inputParts[1].split("/by", 2);
                    Task deadline = new Deadline(descAndTime[0].trim(), descAndTime[1].trim());
                    taskCount = getTaskCount(tasks, taskCount, deadline);
                    saveTasks(tasks, taskCount);
                }

                // Event tasks
            }
            case "event" -> {
                if (inputParts.length < 2 || !inputParts[1].contains("/from") || !inputParts[1].contains("/to")) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" The description of an event must contain '/from' and '/to'.");
                    System.out.println("____________________________________________________________");
                } else {
                    String[] eventDetails = inputParts[1].split("/from|/to", 3);
                    Task event = new Event(eventDetails[0].trim(), eventDetails[1].trim(), eventDetails[2].trim());
                    taskCount = getTaskCount(tasks, taskCount, event);
                    saveTasks(tasks, taskCount);
                }

                // Marking tasks
            }
            case "mark" -> {
                if (inputParts.length < 2 || inputParts[1].isEmpty()) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Specify a task number to mark.");
                    System.out.println("____________________________________________________________");
                    continue;
                }
                try {
                    int taskNumber = Integer.parseInt(inputParts[1]) - 1;
                    tasks[taskNumber].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   " + tasks[taskNumber]);
                    System.out.println("____________________________________________________________");
                    saveTasks(tasks, taskCount);
                } catch (Exception e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Invalid task number.");
                    System.out.println("____________________________________________________________");
                }
            }
            case "unmark" -> {
                if (inputParts.length < 2 || inputParts[1].isEmpty()) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" You need to specify a task number to unmark.");
                    System.out.println("____________________________________________________________");
                    continue;
                }
                try {
                    int taskNumber = Integer.parseInt(inputParts[1]) - 1;
                    tasks[taskNumber].markAsNotDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   " + tasks[taskNumber]);
                    System.out.println("____________________________________________________________");
                    saveTasks(tasks, taskCount);
                } catch (Exception e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Invalid task number.");
                    System.out.println("____________________________________________________________");
                }

<<<<<<< HEAD
            } else if (inputParts[0].equals("delete")) {
                int taskNumber = Integer.parseInt(inputParts[1]) - 1;

                System.out.println("____________________________________________________________");
                System.out.println(" Noted. I've removed this task:");
                System.out.println("   " + tasks[taskNumber]);

                for (int i = taskNumber; i < taskCount - 1; i++) {
                    tasks[i] = tasks[i + 1];
                }

                tasks[taskCount - 1] = null;
                taskCount--;

                System.out.println(" Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");

            // Unknown command
            } else {
=======
                // Unknown command
            }
            default -> {
>>>>>>> branch-Level-7
                System.out.println("____________________________________________________________");
                System.out.println(" What does this mean??");
                System.out.println("____________________________________________________________");
            }
<<<<<<< HEAD
=======
            }
>>>>>>> branch-Level-7
        }

        sc.close();
    }

    private static int getTaskCount(Task[] tasks, int taskCount, Task event) {
        tasks[taskCount] = event;
        taskCount++;
        System.out.println("____________________________________________________________");
        System.out.println(" Got it. I've added this task:");
        System.out.println("   " + event);
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
        System.out.println("____________________________________________________________");
        return taskCount;
    }

    private static void saveTasks(Task[] tasks, int taskCount) {
        try {
            File file = new File(FILE_PATH);
            boolean dirsCreated = file.getParentFile().mkdirs(); // Create parent directories if they don't exist
            if (dirsCreated) {
                System.out.println("Directories created successfully.");
            } else if (!file.getParentFile().exists()) {
                System.out.println("Failed to create directories.");
            }
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < taskCount; i++) {
                writer.write(tasks[i].toSaveFormat() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
    }

    private static int loadTasks(Task[] tasks) {
        int taskCount = 0;
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                System.out.println("No previous task data found. Starting with a new task list.");
                return taskCount;  // No file, so return with taskCount = 0
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                switch (type) {
                case "T":
                    tasks[taskCount] = new ToDo(description);
                    break;
                case "D":
                    String by = parts[3];
                    tasks[taskCount] = new Deadline(description, by);
                    break;
                case "E":
                    String from = parts[3];
                    String to = parts[4];
                    tasks[taskCount] = new Event(description, from, to);
                    break;
                }

                if (isDone) {
                    tasks[taskCount].markAsDone();
                }
                taskCount++;
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error loading tasks from file.");
        }
        return taskCount;
    }
}
