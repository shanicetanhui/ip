import java.util.Scanner;

public class Ui {
    private static final String LINE_SEPARATOR = "____________________________________________________________";
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

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

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void showExitMessage() {
        printLine();
        System.out.println(" Bye. Hope to see you again soon!");
        printLine();
    }

    public void showMessage(String message) {
        printLine();
        System.out.println(message);
        printLine();
    }

    public void printLine() {
        System.out.println(LINE_SEPARATOR);
    }

    public void showNewTaskNumber(int taskCount) {
        System.out.println(" Now you have " + taskCount + " tasks in the list.");
    }
}
