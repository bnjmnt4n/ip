package duke.task;

import duke.DateTime;
import java.time.LocalDateTime;

public class Deadline extends Task {
    protected LocalDateTime time;

    /**
     * Constructs a new Deadline object.
     * @param description Deadline description.
     * @param time Deadline time.
     */
    public Deadline(String description, LocalDateTime time) {
        super(description);
        this.time = time;
    }

    /**
     * Constructs a new Deadline object.
     * @param description Deadline description.
     * @param time Deadline time.
     * @param isCompleted Deadline completion status.
     */
    public Deadline(String description, LocalDateTime time, boolean isCompleted) {
        super(description, isCompleted);
        this.time = time;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    /**
     * Constructs a new Deadline object from an input string.
     * @param input Input string used to create Deadline object.
     */
    public static Deadline fromInput(String input) throws Exception {
        String[] deadlineInputs = input.trim().split("\\s+/by\\s+", 2);

        if (deadlineInputs.length == 1) {
            if (deadlineInputs[0].length() == 0) {
                throw new Exception("Deadline must have description and time");
            } else {
                throw new Exception("Deadline must have time");
            }
        }

        if (deadlineInputs.length != 2) {
            throw new Exception("Deadline must have description and time");
        }

        String description = deadlineInputs[0];
        LocalDateTime time = DateTime.parse(deadlineInputs[1]);

        return new Deadline(description, time);
    }

    @Override
    public String toString() {
        String timeStr = DateTime.stringify(this.time);

        return "[D]" + super.toString() + " (by: " + timeStr + ")";
    }
}
