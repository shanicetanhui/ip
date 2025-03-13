/**
 * The {@code Ui} class handles all user interactions in the Pesto task manager.
 * It is responsible for displaying messages, taking user input, and formatting output.
 */

import java.util.Scanner;

public class Ui {
    private static final String LINE_SEPARATOR = "____________________________________________________________";
    private Scanner scanner;

    /**
     * Constructs a new {@code Ui} instance and initializes a {@code Scanner} for user input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message when the application starts.
     */
    public void showWelcome() {
        String logo = " ____            _         \n"
                + "|  __ \\         | |  ___    \n"
                + "| |__) |___  ___| |_/ _ \\ \n"
                + "|  ___/ _ \\/ __| __| | | |\n"
                + "| |  |  __/\\__ \\ |_| |_| |\n"
                + "|_|   \\___||___/\\__|\\__,_|\n";
        System.out.println("Hello from\n" + logo);
        printLine();
        System.out.println(" Hello! I'm Pesto!");
        System.out.println(" What can I do for you?");
        printLine();
    }

    /**
     * Reads and returns user input from the command line.
     *
     * @return The user's input as a {@code String}.
     */
    public String getUserInput() {
        return scanner.nextLine();
    }

    /**
     * Displays the exit message when the user quits the application.
     */
    public void showExitMessage() {
        printLine();
        System.out.println(" Bye. Hope to see you again soon!");
        printLine();
    }

    /**
     * Displays a formatted message with separators.
     *
     * @param message The message to display.
     */
    public void showMessage(String message) {
        printLine();
        System.out.println(message);
        printLine();
    }

    /**
     * Prints a horizontal line separator.
     */
    public void printLine() {
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Displays the number of tasks currently in the task list.
     *
     * @param taskCount The total number of tasks in the list.
     */
    public void showNewTaskNumber(int taskCount) {
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
    }
}
