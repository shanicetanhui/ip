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
        Task[] taskList = new Task[100];
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
                    System.out.println((i + 1) + ". " + taskList[i]);
                }
                System.out.println("____________________________________________________________");

            // Marking task
            } else if (inputParts[0].equals("mark")) {
                int taskNumber = Integer.parseInt(inputParts[1]) - 1;
                taskList[taskNumber].markAsDone();
                System.out.println("____________________________________________________________");
                System.out.println(" Nice! I've marked this task as done:");
                System.out.println("   " + taskList[taskNumber]);
                System.out.println("____________________________________________________________");
            } else if (inputParts[0].equals("unmark")) {
                int taskNumber = Integer.parseInt(inputParts[1]) - 1;
                taskList[taskNumber].markAsNotDone();
                System.out.println("____________________________________________________________");
                System.out.println(" OK, I've marked this task as not done yet:");
                System.out.println("   " + taskList[taskNumber]);
                System.out.println("____________________________________________________________");
            } else {
                // Add task to list
                Task task = new Task(input);
                taskList[taskCount] = task;
                taskCount++;
                System.out.println("____________________________________________________________");
                System.out.println(" added: " + input);
                System.out.println("____________________________________________________________");
            }
        }
        sc.close();
    }
}
