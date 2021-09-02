package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.task.Task;
import duke.ui.Ui;

public class DeleteTaskCommand extends Command {
    private String arguments;

    /**
     * Creates a command that deletes a task.
     *
     * @param arguments Command arguments.
     */
    public DeleteTaskCommand(String arguments) throws Exception {
        if (arguments.length() == 0) {
            throw new Exception("Command `done` requires an arguments");
        }
        this.arguments = arguments;
    }

    /**
     * Delete a task from the user's tasklist.
     *
     * @param taskList The tasklist.
     * @param ui The instance of the {@link Ui} class.
     * @param storage The instance of the {@link Storage} class.
     * @throws Exception when unable to find task or when unable to save tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        Task task;
        try {
            int taskIndex = Integer.parseInt(arguments);
            task = taskList.removeTask(taskIndex - 1);
        } catch (NumberFormatException e) {
            throw new Exception("Unable to parse number from arguments: " + arguments);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("There is no task with the following number: " + arguments);
        }

        storage.saveTasks(taskList);
        ui.printMessage("Removed the following task:\n    " + task.toString() + "\n" + "You now have "
                + taskList.size() + " tasks in your list.");
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
