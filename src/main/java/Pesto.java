/**
 * The {@code Pesto} class represents the main entry point of the Pesto task management application.
 * It initializes the necessary components such as the {@link Storage},
 * {@link TaskList}, {@link Ui}, and {@link Parser}
 * to handle user input, manage tasks, and store data persistently.
 */

import java.util.List;

public class Pesto {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private Parser parser;

    /**
     * Initializes a new instance of the Pesto application.
     *
     * @param filePath The file path where tasks are stored and retrieved.
     */
    public Pesto(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();

        List<Task> tasks = storage.loadTasks();
        taskList = new TaskList(tasks);
    }

    /**
     * Starts the Duke application, displaying a welcome message and continuously
     * processing user input until the user exits.
     */
    public void run() {
        ui.showWelcome();
        boolean isRunning = true;

        while (isRunning) {
            String userInput = ui.getUserInput();
            isRunning = parser.parseCommand(userInput, taskList, ui, storage);
        }

        ui.showExitMessage();
    }

    /**
     * The main entry point of the application.
     * Creates an instance of Pesto and starts the program.
     * Get saved data from pesto.txt.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Pesto("data/pesto.txt").run();
    }
}
