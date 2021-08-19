public class Task {
    protected String description;
    protected boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        String statusIcon = this.isCompleted ? "X" : " ";
        return "[" + statusIcon + "] " + this.description;
    }
}