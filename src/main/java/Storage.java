/**
 * The {@code Storage} class handles loading and saving tasks to a file.
 * It is responsible for persisting task data between program runs.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    private String filePath;

    /**
     * Constructs a new {@code Storage} instance with the specified file path.
     *
     * @param filePath The file path where task data is stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the specified file and returns them as a list.
     * If the file does not exist, an empty list is returned.
     *
     * @return A {@code List<Task>} containing tasks loaded from the file.
     */
    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return tasks;
            }

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(" \\| ");
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                Task task = null;
                switch (type) {
                case "T":
                    task = new ToDo(description);
                    break;
                case "D":
                    task = new Deadline(description, parts[3]);
                    break;
                case "E":
                    task = new Event(description, parts[3], parts[4]);
                    break;
                }

                if (task != null) {
                    if (isDone) task.markAsDone();
                    tasks.add(task);
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error loading tasks from file.");
        }
        return tasks;
    }

    /**
     * Saves the provided list of tasks to a file.
     * If the file or directories do not exist, they are created automatically.
     *
     * @param tasks The {@code List<Task>} of tasks to be saved.
     */
    public void saveTasks(List<Task> tasks) {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file);
            for (Task task : tasks) {
                writer.write(task.toSaveFormat() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks to file.");
        }
    }
}
