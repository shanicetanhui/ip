import java.util.Scanner;

public class Duke {
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
        int taskCount = 0;

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
            if (command.equals("list")) {
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
            } else if (command.equals("todo")) {
                if (inputParts.length < 2 || inputParts[1].trim().isEmpty()) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" The description of a todo cannot be empty.");
                    System.out.println("____________________________________________________________");
                } else {
                    Task todo = new ToDo(inputParts[1]);  // Create new todo
                    taskCount = getTaskCount(tasks, taskCount, todo);
                }

            // Deadline tasks
            } else if (command.equals("deadline")) {
                if (inputParts.length < 2 || !inputParts[1].contains("/by")) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" The description of a deadline must contain '/by'.");
                    System.out.println("____________________________________________________________");
                } else {
                    String[] descAndTime = inputParts[1].split("/by", 2);
                    Task deadline = new Deadline(descAndTime[0].trim(), descAndTime[1].trim());
                    taskCount = getTaskCount(tasks, taskCount, deadline);
                }

            // Event tasks
            } else if (command.equals("event")) {
                if (inputParts.length < 2 || !inputParts[1].contains("/from") || !inputParts[1].contains("/to")) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" The description of an event must contain '/from' and '/to'.");
                    System.out.println("____________________________________________________________");
                } else {
                    String[] eventDetails = inputParts[1].split("/from|/to", 3);
                    Task event = new Event(eventDetails[0].trim(), eventDetails[1].trim(), eventDetails[2].trim());
                    taskCount = getTaskCount(tasks, taskCount, event);
                }

            // Marking tasks
            } else if (command.equals("mark")) {
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
                } catch (Exception e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Invalid task number.");
                    System.out.println("____________________________________________________________");
                }
            } else if (command.equals("unmark")) {
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
                } catch (Exception e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Invalid task number.");
                    System.out.println("____________________________________________________________");
                }

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
                System.out.println("____________________________________________________________");
                System.out.println(" What does this mean??");
                System.out.println("____________________________________________________________");
            }

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
}
