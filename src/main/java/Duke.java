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
        String input;

        while (true) {
            input = sc.nextLine();

            // Exit if user types "bye"
            if (input.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            }

            // Echo
            System.out.println("____________________________________________________________");
            System.out.println(input);
            System.out.println("____________________________________________________________");
        }

        sc.close();
    }
}
