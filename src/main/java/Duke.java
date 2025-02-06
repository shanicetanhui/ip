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

            // Exit if user types "bye"
            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            }

            // Display all tasks entered so far
            if (input.equals("list")) {
                System.out.println("____________________________________________________________");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");

            // To Do tasks
            } else if (inputParts[0].equals("todo")) {
                String description = inputParts[1];
                tasks[taskCount] = new ToDo(description);
                taskCount++;

                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1]);
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");

            // Deadline tasks
            } else if (inputParts[0].equals("deadline")) {
                String[] parts = inputParts[1].split("/by");
                String description = parts[0].trim();
                String by = parts[1].trim();
                tasks[taskCount] = new Deadline(description, by);
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1]);
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");

            // Event tasks
            } else if (inputParts[0].equals("event")) {
                String[] parts = inputParts[1].split("/from");
                String description = parts[0].trim();
                String[] dateParts = parts[1].split("/to");
                String from = dateParts[0].trim();
                String to = dateParts[1].trim();
                tasks[taskCount] = new Event(description, from, to);
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[taskCount - 1]);
                System.out.println("Now you have " + taskCount + " tasks in the list.");
                System.out.println("____________________________________________________________");

            // Marking tasks
            } else if (inputParts[0].equals("mark")) {
                int taskNumber = Integer.parseInt(inputParts[1]) - 1;
                tasks[taskNumber].markAsDone();
                System.out.println("____________________________________________________________");
                System.out.println(" Nice! I've marked this task as done:");
                System.out.println("   " + tasks[taskNumber]);
                System.out.println("____________________________________________________________");

            } else if (inputParts[0].equals("unmark")) {
                int taskNumber = Integer.parseInt(inputParts[1]) - 1;
                tasks[taskNumber].markAsNotDone();
                System.out.println("____________________________________________________________");
                System.out.println(" OK, I've marked this task as not done yet:");
                System.out.println("   " + tasks[taskNumber]);
                System.out.println("____________________________________________________________");

            // Add task to list
            } else {
                Task task = new Task(input);
                tasks[taskCount] = task;
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println(" added: " + input);
                System.out.println("____________________________________________________________");
            }
        }

        sc.close();
    }
}
