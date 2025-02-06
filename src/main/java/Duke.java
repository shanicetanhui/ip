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
        String[] tasks = new String[100];
        int taskCount = 0;

        while (true) {
            String input = sc.nextLine();

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
            } else {
                // Add task to list
                tasks[taskCount] = input;
                taskCount++;

                System.out.println("____________________________________________________________");
                System.out.println(" added: " + input);
                System.out.println("____________________________________________________________");
            }
        }
        sc.close();
    }
}
