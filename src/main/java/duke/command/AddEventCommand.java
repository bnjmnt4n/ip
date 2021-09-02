package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.task.Event;
import duke.task.Task;
import duke.ui.Ui;

public class AddEventCommand extends Command {
    private String arguments;

    /**
     * Creates a command that adds a {@link Event} to the user's tasks.
     *
     * @param arguments Command arguments.
     */
    public AddEventCommand(String arguments) throws Exception {
        if (arguments.length() == 0) {
            throw new Exception("Command `deadline` requires arguments");
        }
        this.arguments = arguments;
    }

    /**
     * Adds an event to the user's tasklist.
     *
     * @param taskList The tasklist.
     * @param ui The instance of the {@link Ui} class.
     * @param storage The instance of the {@link Storage} class.
     * @throws IOException when unable to save tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        Task event = Event.fromInput(arguments);
        taskList.addTask(event);

        storage.saveTasks(taskList);
        ui.printMessage("Added the following task:\n    " + event.toString() + "\n" + "You now have "
                + taskList.size() + " tasks in your list.");
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
