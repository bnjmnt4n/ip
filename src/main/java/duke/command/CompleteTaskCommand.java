package duke.command;

import duke.TaskList;
import duke.Ui;
import duke.Storage;
import duke.task.Task;

public class CompleteTaskCommand extends Command {
    private String arguments;

    public CompleteTaskCommand(String arguments) throws Exception {
        if (arguments.length() == 0) {
            throw new Exception("Command `done` requires an arguments");
        }
        this.arguments = arguments;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws Exception {
        Task task;
        try {
            int taskIndex = Integer.parseInt(arguments);
            task = taskList.getTask(taskIndex - 1);
            task.markCompleted();
        } catch (NumberFormatException e) {
            throw new Exception("Unable to parse number from arguments: " + arguments);
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("There is no task with the following number: " + arguments);
        }

        storage.saveTasks(taskList);
        ui.printMessage("Marking task as completed:\n    " + task.toString());
    }

    public boolean shouldExit() {
        return false;
    }
}