/**
 * The {@code Task} class represents a general task in the Pesto task manager.
 * It serves as a base class for specific task types such as {@link ToDo}, {@link Deadline}, and {@link Event}.
 */

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new {@code Task} with the given description.
     * The task is initially marked as not done.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Returns the description of the task.
     *
     * @return The task description as a {@code String}.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a formatted string representation of the task for saving to a file.
     * The format is:
     * <pre>
     * Type | Done (1 or 0) | Description
     * </pre>
     * Example:
     * <pre>
     * T | 0 | Read book
     * D | 1 | Submit project | 2023-12-31
     * </pre>
     *
     * @return The formatted string for file storage.
     */
    public String toSaveFormat() {
        return (this instanceof ToDo ? "T" : this instanceof Deadline ? "D" : "E")
                + " | " + (isDone ? "1" : "0") + " | " + description;
    }

    /**
     * Returns a string representation of the task for display in the task list.
     * The format is:
     * <pre>
     * [X] Task description (if done)
     * [ ] Task description (if not done)
     * </pre>
     *
     * @return The formatted task string.
     */
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }
}
