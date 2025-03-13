import java.util.List;

public class Duke {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private Parser parser;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();

        List<Task> tasks = storage.loadTasks();
        taskList = new TaskList(tasks);
    }

    public void run() {
        ui.showWelcome();
        boolean isRunning = true;

        while (isRunning) {
            String userInput = ui.getUserInput();
            isRunning = parser.parseCommand(userInput, taskList, ui, storage);
        }

        ui.showExitMessage();
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}
