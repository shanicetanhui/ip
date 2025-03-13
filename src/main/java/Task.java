public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String toSaveFormat() {
        return (this instanceof ToDo ? "T" : this instanceof Deadline ? "D" : "E")
                + " | " + (isDone ? "1" : "0") + " | " + description;
    }

    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }
}
